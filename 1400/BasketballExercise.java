import java.io.*;
import java.util.*;

public class BasketballExercise {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

//        int t=fr.nextInt();
        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i=0;i<n;i++)
                a[i] = fr.nextInt();

            for (int i=0;i<n;i++)
                b[i] = fr.nextInt();

            //make call to execute the logic
            solution.solve(n,a,b);

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
    public void solve(int n,int[] a,int[] b) {
        long[][] dp = new long[n][2];

        for (long[] arr: dp)
            Arrays.fill(arr,-1);

        long res1 = a[0] + helper(1,1,a,b,dp);
        long res2 = b[0] + helper(1,0,a,b,dp);

        sb.append(Math.max(res1,res2));
    }

    private long helper(int i, int flag, int[] a, int[] b,long[][] dp) {
        if (i >= a.length)
            return 0;

        if (dp[i][flag] != -1)
            return dp[i][flag];

        long pick = 0;
        long notPick = 0;
        if (flag == 0) {
            pick = a[i] + helper(i+1,1,a,b,dp);
            notPick = helper(i+1,0,a,b,dp);
        } else {
            pick = b[i] + helper(i+1,0,a,b,dp);
            notPick = helper(i+1,1,a,b,dp);
        }

        return dp[i][flag] = Math.max(pick,notPick);
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