import java.io.*;
import java.util.*;

public class AndSequences {
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
        int totalAnd = a[0];
        for (int i=1;i<n;i++)
            totalAnd &= a[i];

        int cnt = 0;
        for (int val: a)
            if (val == totalAnd)
                cnt++;

        if (cnt < 2) {
            sb.append(0);
            return;
        }

        long x = ((long)cnt * (cnt-1))%LONG_MOD;
        long y = fact(n-2);

        long res = (x * y)%LONG_MOD;
        sb.append(res);
    }

    public long fact(int n) {
        long res = 1;
        for (int i=2;i<=n;i++)
            res = (res*i)%LONG_MOD;

        return res;
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