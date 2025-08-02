import java.io.*;
import java.util.*;

public class OddQueries {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n=fr.nextInt();
            int q=fr.nextInt();
            long[] a=new long[n];

            for (int i=0;i<n;i++)
                a[i]=fr.nextLong();

            //make call to execute the logic
            solution.solve(a,q,n,fr);

            //new line after test case ans
//            solution.sb.append("\n");
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
    public void solve(long[] a,int q,int n,FastReader fr) {
        long[] prefixSum=new long[n];
        prefixSum[0]=a[0];

        for (int i=1;i<n;i++)
            prefixSum[i]=(prefixSum[i-1]+a[i]);

        for (int i=0;i<q;i++) {
            int l=fr.nextInt()-1;
            int r=fr.nextInt()-1;
            long k=fr.nextLong();
            long sum=0L;

            if (l>0)
                sum+=prefixSum[l-1];
            sum+=(r-l+1)*k;
            sum+=(prefixSum[n-1]-prefixSum[r]);

            if ((sum&1L)==1L)
                sb.append("Yes").append("\n");
            else
                sb.append("No").append("\n");
        }
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