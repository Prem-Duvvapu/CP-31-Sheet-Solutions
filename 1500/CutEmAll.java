import java.io.*;
import java.util.*;

public class CutEmAll {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

//        int t=fr.nextInt();
        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int[][] edges = new int[n-1][2];
            for (int i=0;i<edges.length;i++) {
                edges[i][0] = fr.nextInt();
                edges[i][1] = fr.nextInt();
            }

            //make call to execute the logic
            solution.solve(n, edges);

            //new line after test case ans
            solution.sb.append("\n");
        }

        out.println(solution.sb);

        out.close();
    }
}

class Solution {
    public static final int INT_MOD=1_000_000_007;
    public static final long LONG_MOD=1_000_000_007L;

    public StringBuilder sb=new StringBuilder();

    //write logic here and print the result
    public void solve(int n,int[][] edges) {
        if ((n&1) == 1) {
            sb.append(-1);
            return;
        }

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0;i<=n;i++)
            adjList.add(new ArrayList<>());

        for (var edge: edges){
            int u = edge[0];
            int v = edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        int[] size = new int[n+1];
        Arrays.fill(size,1);
        dfs(1,-1,size,adjList,n);

        int res = 0;
        for (int i=2;i<=n;i++) {
            if ((size[i] & 1) == 0)
                res++;
        }

        sb.append(res);
    }

    private void dfs(int curr, int parent, int[] size, List<List<Integer>> adjList, int n) {
        for (int ngbr: adjList.get(curr)) {
            if (ngbr == parent)
                continue;

            dfs(ngbr,curr,size,adjList,n);
            size[curr] += size[ngbr];
        }
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br=new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st==null || !st.hasMoreElements()) {
            try {
                st=new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str="";
        try {
            str=br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }
}