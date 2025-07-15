import java.io.*;
import java.util.*;

public class PlusMinusPermutation {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int x = fr.nextInt();
            int y = fr.nextInt();

            //make call to execute the logic
            solution.solve(n,x,y);

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
    public void solve(long n,long x,long y) {
        long xf = n/x;
        long yf = n/y;

        long xyLcm = lcm(x,y);
        long lcmf = n/xyLcm;

        xf -= lcmf;
        yf -= lcmf;

        xf = n-xf;

        long totalSum = (n*(n+1))/2;
        long firstSum = totalSum - (xf*(xf+1))/2;
        long secondSum = (yf*(yf+1))/2;

        sb.append(firstSum - secondSum);
    }

    private long gcd(long a,long b) {
        if (b==0)
            return a;

        return gcd(b,a%b);
    }

    private long lcm(long a,long b) {
        return (a/gcd(a,b))*b;
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