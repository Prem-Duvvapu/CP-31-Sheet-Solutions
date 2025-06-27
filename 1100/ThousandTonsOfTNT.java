import java.io.*;
import java.util.*;

public class ThousandTonsOfTNT {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n=fr.nextInt();
            int[] a=new int[n];

            for (int i=0;i<n;i++)
                a[i]=fr.nextInt();

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
        List<Integer> factors=getFactors(n);
        long maxDiff=0;

        for (int divisor: factors) {
            long minSum=Long.MAX_VALUE;
            long maxSum=Long.MIN_VALUE;

            for (int i=0;i<n;i+=divisor) {
                long currSum=0;
                for (int j=i;j<i+divisor;j++)
                    currSum+=a[j];

                minSum=Math.min(minSum,currSum);
                maxSum=Math.max(maxSum,currSum);
            }

            maxDiff=Math.max(maxDiff,maxSum-minSum);
        }

        sb.append(maxDiff);
    }

    private List<Integer> getFactors(int n) {
        List<Integer> factors=new ArrayList<>();

        for (int i=1;(long)i*i<=(long)n;i++) {
            if (n%i==0) {
                factors.add(i);

                if (i!=n/i)
                    factors.add(n/i);
            }
        }

        return factors;
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