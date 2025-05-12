import java.io.*;
import java.util.*;

public class JellyfishAndUndertale {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int a=fr.nextInt();
            int b=fr.nextInt();
            int n=fr.nextInt();
            int[] x=new int[n];

            for (int i=0;i<n;i++)
                x[i]=fr.nextInt();

            //make call to execute the logic
            solution.solve(x,a,b,n);

            //new line after test case ans
            solution.sb.append("\n");
        }

        out.println(solution.sb);

        out.close();
    }
}

class Solution {
    public static final int MOD=1_000_000_007;
    public StringBuilder sb=new StringBuilder();

    //write logic here and print the result
    public void solve(int[] x,int a,int b,int n) {
        long res=b;

        for (int val: x)
            res+=Math.min(val,a-1);

        sb.append(res);
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