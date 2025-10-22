import java.io.*;
import java.util.*;

public class Pride {
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
        if (n == 1) {
            if (a[0] == 1)
                sb.append(0);
            else
                sb.append(-1);
            return;
        }

        int minDist = n;

        for (int i=0;i<n;i++) {
            int gcd = a[i];
            for (int j=i+1;j<n;j++) {
                gcd = getGCD(gcd,a[j]);
                if (gcd == 1) {
                    minDist = Math.min(minDist, j - i - 1);
                }
            }
        }

        if (minDist == n) {
            sb.append(-1);
            return;
        }

        int res = minDist;
        for (int val: a)
            if (val != 1)
                res++;

        sb.append(res);
    }

    private int getGCD(int a,int b) {
        if (a == 0)
            return b;

        return getGCD(b%a, a);
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