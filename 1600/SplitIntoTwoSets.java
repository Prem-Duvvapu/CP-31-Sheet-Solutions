import java.io.*;
import java.util.*;

public class SplitIntoTwoSets {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
//        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int[][] dominoes = new int[n][2];

            for (int i=0;i<n;i++) {
                dominoes[i][0] = fr.nextInt();
                dominoes[i][1] = fr.nextInt();
            }

            //make call to execute the logic
            solution.solve(n,dominoes);

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
    public void solve(int n,int[][] dominoes) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0;i<=n;i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] domino: dominoes) {
            int a = domino[0];
            int b = domino[1];

            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        for (int i=1;i<=n;i++) {
            if (adjList.get(i).size() > 2) {
                sb.append("NO");
                return;
            }
        }

        int[] color = new int[n+1];
        Arrays.fill(color,-1);

        for (int i=1;i<=n;i++) {
            if (color[i] == -1) {
                boolean bipartite = isBipartite(i,color,1,adjList);
                if (!bipartite) {
                    sb.append("NO");
                    return;
                }
            }
        }

        sb.append("YES");
    }

    private boolean isBipartite(int i, int[] color,int prevColor, List<List<Integer>> adjList) {
        color[i] = 1 - prevColor;

        for (int ngbr: adjList.get(i)) {
            if (color[ngbr] == -1 && ngbr!=i) {
                if (!isBipartite(ngbr,color,color[i],adjList)) {
                    return false;
                }
            } else if (color[ngbr] == color[i]) {
                return false;
            }
        }

        return true;
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