import java.io.*;
import java.util.*;

public class MortalKombatTower {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
//        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int[] a = new int[n];
            for (int i=0;i<n;i++)
                a[i] = fr.nextInt();

            //make call to execute the logic
            solution.solve(n,a);

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
    public void solve(int n,int[] a) {
        int[][] dp = new int[n][2];
        for (int[] arr: dp)
            Arrays.fill(arr,-1);

        int res = helper(0,0,a,n,dp);
        sb.append(res);
    }

    private int helper(int i,int isMe, int[] a, int n,int[][] dp) {
        if (i == n-2 || i == n-1) {
            if (isMe == 0 && a[i] == 1)
                return 1;
            return 0;
        }

        if (dp[i][isMe] != -1)
            return dp[i][isMe];

        // one kill
        int oneKill = (isMe == 1) ? 0: a[i];
        oneKill += helper(i+1,1 - isMe,a,n,dp);

        // two kills
        int twoKills = (isMe == 1) ? 0: (a[i] + a[i+1]);
        twoKills += helper(i+2,1 - isMe,a,n,dp);

        return dp[i][isMe] = Math.min(oneKill, twoKills);
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