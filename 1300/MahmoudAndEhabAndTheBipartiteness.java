import java.io.*;
import java.util.*;

public class MahmoudAndEhabAndTheBipartiteness {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

//        int t=fr.nextInt();
        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            List<List<Integer>> adjList = new ArrayList<>();
            int[] degree = new int[n+1];

            for (int i=0;i<=n;i++)
                adjList.add(new ArrayList<>());

            for (int i=1;i<n;i++) {
                int u = fr.nextInt();
                int v = fr.nextInt();

                adjList.get(u).add(v);
                adjList.get(v).add(u);
                degree[u]++;
                degree[v]++;
            }

            //make call to execute the logic
            solution.solve(n,adjList,degree);

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
    public void solve(int n,List<List<Integer>> adjList,int[] degree) {
        int[] color = new int[n+1];
        long res = 0;

        Arrays.fill(color,-1);

        if (!isBipartitie(1,0,color,adjList)) {
            sb.append(0);
            return;
        }

        int oneCnt = 0;
        int zeroCnt = 0;

        for (int i=1;i<=n;i++) {
            if (color[i] == 0)
                zeroCnt++;
            else
                oneCnt++;
        }

        for (int i=1;i<=n;i++) {
            if (color[i] == 0)
                res += (oneCnt - degree[i]);
            else
                res += (zeroCnt - degree[i]);
        }

        sb.append(res/2);
    }

    private boolean isBipartitie(int currNode,int currColor,int[] color,List<List<Integer>> adjList) {
        color[currNode] = currColor;

        for (int ngbr: adjList.get(currNode)) {
            if (color[ngbr] == -1) {
                if (!isBipartitie(ngbr,1-currColor,color,adjList))
                    return false;
            } else if (color[ngbr] == currColor) {
                return false;
            }
        }

        return  true;
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