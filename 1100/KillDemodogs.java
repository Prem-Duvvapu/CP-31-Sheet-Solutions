import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class KillDemodogs {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            long n = fr.nextLong();

            //make call to execute the logic
            solution.solve(n);

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
    public void solve(long n) {
        BigInteger N = BigInteger.valueOf(n);
        BigInteger BIG_INT_MOD = BigInteger.valueOf(LONG_MOD);

        BigInteger sumOfN = N.multiply(N.add(BigInteger.ONE)).divide(BigInteger.TWO);
        BigInteger sumOfNsq = sumOfN.multiply(N.multiply(BigInteger.TWO).add(BigInteger.ONE)).divide(BigInteger.valueOf(3));

        BigInteger res = sumOfNsq.multiply(BigInteger.TWO).add(sumOfN);
        res = res.subtract(N.multiply(N)).subtract(N);
        res = res.multiply(BigInteger.valueOf(2022)).mod(BIG_INT_MOD);

        sb.append(res.toString());
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