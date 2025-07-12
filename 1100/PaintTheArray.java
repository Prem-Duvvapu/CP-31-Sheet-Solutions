import java.io.*;
import java.util.*;

public class PaintTheArray {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            long[] a = new long[n];

            for (int i=0;i<n;i++)
                a[i]=fr.nextLong();

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
    public void solve(int n,long[] a) {
        long gcd1 = a[0];
        long gcd2 = a[1];

        for (int i=2;i<n;i+=2)
            gcd1 = getGCD(gcd1,a[i]);

        for (int i=3;i<n;i+=2)
            gcd2 = getGCD(gcd2,a[i]);

        boolean flag1 = true;
        boolean flag2 = true;

        for (int i=1;i<n;i+=2) {
            if (a[i]%gcd1==0) {
                flag1 = false;
                break;
            }
        }

        for (int i=0;i<n;i+=2) {
            if (a[i]%gcd2==0) {
                flag2 = false;
                break;
            }
        }

        if (flag1)
            sb.append(gcd1);
        else if (flag2)
            sb.append(gcd2);
        else
            sb.append(0);
    }

    public long getGCD(long a,long b) {
        if (b==0)
            return a;

        return getGCD(b,a%b);
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