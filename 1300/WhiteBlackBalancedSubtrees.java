import java.io.*;
import java.util.*;

public class WhiteBlackBalancedSubtrees {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int[] a = new int[n-1];

            for (int i=0;i<a.length;i++)
                a[i] = fr.nextInt();

            String s = fr.next();

            //make call to execute the logic
            solution.solve(n, a, s);

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
    public void solve(int n, int[] a, String s) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] res = {0};

        for (int i=0;i<n+1;i++)
            adjList.add(new ArrayList<>());

        for (int i=0;i<a.length;i++) {
            int child = (i+2);
            int parent = a[i];
            adjList.get(parent).add(child);
        }

        dfs(1,res,adjList,s);
        sb.append(res[0]);
    }

    private int[] dfs(int curr, int[] res, List<List<Integer>> adjList, String s) {
        int whiteCnt = 0;
        int blackCnt = 0;

        if (s.charAt(curr-1) == 'W')
            whiteCnt++;
        else
            blackCnt++;

        for (int ngbr: adjList.get(curr)) {
            int[] wbCnt = dfs(ngbr,res,adjList,s);

            whiteCnt += wbCnt[0];
            blackCnt += wbCnt[1];
        }

        if (whiteCnt == blackCnt)
            res[0]++;

        return  new int[]{whiteCnt,blackCnt};
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