import java.io.*;
import java.util.*;

public class EhabAndPatheticMEXs {
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
            solution.solve(n,edges);

            //new line after test case ans
            solution.sb.append("\n");
        }

        out.println(solution.sb);

        out.close();
    }
}

class Pair {
    int node;
    int index;

    Pair(int node,int index) {
        this.node = node;
        this.index = index;
    }
}

class Solution {
    public static final int INT_MOD=1_000_000_007;
    public static final long LONG_MOD=1_000_000_007L;

    public StringBuilder sb=new StringBuilder();

    //write logic here and print the result
    public void solve(int n,int[][] edges) {
        int[] res = new int[n-1];
        List<List<Pair>> adjList = new ArrayList<>();

        Arrays.fill(res,-1);
        for (int i=0;i<n+1;i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i=0;i<edges.length;i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adjList.get(u).add(new Pair(v,i));
            adjList.get(v).add(new Pair(u,i));
        }

        int curr = 0;

        for (int i=1;i<=n;i++) {
            if (adjList.get(i).size() >= 3) {
                for (int j=0;j<3;j++) {
                    res[adjList.get(i).get(j).index] = curr++;
                }
                break;
            }
        }

        for (int i=1;i<=n;i++) {
            for (int j=0;j<adjList.get(i).size();j++) {
                if (res[adjList.get(i).get(j).index] == -1) {
                    res[adjList.get(i).get(j).index] = curr++;
                }
            }
        }

        StringJoiner sj = new StringJoiner("\n");
        for (int val: res)
            sj.add(String.valueOf(val));

        sb.append(sj);
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