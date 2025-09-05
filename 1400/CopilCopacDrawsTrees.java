import java.io.*;
import java.util.*;

public class CopilCopacDrawsTrees {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
//        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int[][] edges = new int[n][2];

            for (int i=0;i<n-1;i++) {
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

class Pair<U, V> {
    public U first;
    public V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}


class Solution {
    public static final int INT_MOD=1_000_000_007;
    public static final long LONG_MOD=1_000_000_007L;

    public StringBuilder sb=new StringBuilder();

    //write logic here and print the result
    public void solve(int n,int[][] edges) {
        List<List<Pair>> adjList = new ArrayList<>();
        int[] dp = new int[n+1];
        int[] firstReachedIndex = new int[n+1];
        int res = 0;

        for (int i=0;i<n+1;i++)
            adjList.add(new ArrayList<>());

        for (int i=0;i<n;i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adjList.get(u).add(new Pair<>(v,i));
            adjList.get(v).add(new Pair<>(u,i));
        }

        dp[1] = 1;
        firstReachedIndex[1] = 0;
        dfs(1,dp,firstReachedIndex,adjList,n);

        for (int i=1;i<n+1;i++)
            res = Math.max(res, dp[i]);

        sb.append(res);
    }

    private void dfs(int u, int[] dp, int[] firstReachedIndex, List<List<Pair>> adjList, int n) {
        for (Pair ngbr: adjList.get(u)) {
            int v = (int)ngbr.first;
            int vIndex = (int)ngbr.second;

            if (dp[v] == 0) {
                dp[v] = dp[u];
                if (vIndex < firstReachedIndex[u])
                    dp[v] += 1;

                firstReachedIndex[v] = vIndex;
                dfs(v,dp,firstReachedIndex,adjList,n);
            }
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