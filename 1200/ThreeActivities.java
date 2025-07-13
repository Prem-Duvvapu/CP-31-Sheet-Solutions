import java.io.*;
import java.util.*;

public class ThreeActivities {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            int[] c = new int[n];

            for (int i=0;i<n;i++)
                a[i] = fr.nextInt();

            for (int i=0;i<n;i++)
                b[i] = fr.nextInt();

            for (int i=0;i<n;i++)
                c[i] = fr.nextInt();

            //make call to execute the logic
            solution.solve(n,a,b,c);

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
    public void solve(int n,int[] a,int[] b,int[] c) {
        int[][][][] dp = new int[n][2][2][2];

        for (int i=0;i<n;i++)
            for (int j=0;j<2;j++)
                for (int k=0;k<2;k++)
                    for (int l=0;l<2;l++)
                        dp[i][j][k][l]=-1;

        int res = helper(0,0,0,0,a,b,c,n,dp);
        sb.append(res);
    }

    private int helper(int pos, int s,int m,int g, int[] a, int[] b, int[] c, int n,int[][][][] dp) {
        if (s+m+g==3 || pos==n)
            return 0;

        if (dp[pos][s][m][g]!=-1)
            return dp[pos][s][m][g];

        int res = 0;
        if (s==0)
            res = Math.max(res, a[pos] + helper(pos+1,1,m,g,a,b,c,n,dp));

        if (m==0)
            res = Math.max(res, b[pos] + helper(pos+1,s,1,g,a,b,c,n,dp));

        if (g==0)
            res = Math.max(res, c[pos] + helper(pos+1,s,m,1,a,b,c,n,dp));

        res = Math.max(res,helper(pos+1,s,m,g,a,b,c,n,dp));

        return dp[pos][s][m][g] = res;
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