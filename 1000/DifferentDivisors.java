import java.io.*;
import java.util.*;

public class DifferentDivisors {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int d=fr.nextInt();

            //make call to execute the logic
            solution.solve(d);

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
    public void solve(long d) {
        long p=0;
        long q=0;

        long i=d+1;
        while (true) {
            if (isPrime(i)) {
                p=i;
                break;
            }
            i++;
        }

        i=p+d;
        while (true) {
            if (isPrime(i)) {
                q=i;
                break;
            }
            i++;
        }

        long res=Math.min(p*q,p*p*p);
        sb.append(res);
    }

    private boolean isPrime(long n) {
        if (n<=1)
            return false;

        if (n==2)
            return true;

        if (n%2==0)
            return false;

        for (long i=3;i*i<=n;i+=2) {
            if (n%i==0)
                return false;
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