import java.io.*;
import java.util.*;

public class PalindromeBasis {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
//        int t=1;

        Solution solution=new Solution();

        int MAX_N = 4*1_000_0;
        List<Integer> palindromes = new ArrayList<>();

        for (int i=1;i<=MAX_N;i++) {
            String s = String.valueOf(i);
            if (s.contentEquals(new StringBuilder(s).reverse()))
                palindromes.add(i);
        }

        long[][] dp = new long[palindromes.size()][MAX_N+1];
        for (long[] arr: dp)
            Arrays.fill(arr,-1);

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();

            //make call to execute the logic
            solution.solve(n,palindromes,dp);

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
    public void solve(int n,List<Integer> palindromes,long[][] dp) {
        long res = helper(0,n,palindromes,dp);
        sb.append(res);
    }

    private long helper(int i, int n, List<Integer> palindromes, long[][] dp) {
        if (n == 0)
            return 1;

        if (i>=palindromes.size() || n < 0)
            return 0;

        if (dp[i][n] != -1)
            return dp[i][n];

        long pickAndStay = helper(i,n-palindromes.get(i),palindromes,dp);
        long move = helper(i+1,n,palindromes,dp);

        return dp[i][n] = (pickAndStay + move)%LONG_MOD;
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