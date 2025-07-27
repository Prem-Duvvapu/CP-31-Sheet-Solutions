import java.io.*;
import java.util.*;

public class DolceVita {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            long x = fr.nextLong();
            long[] a = new long[n];

            for (int i=0;i<n;i++)
                a[i] = fr.nextLong();

            //make call to execute the logic
            solution.solve(n,x,a);

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
    public void solve(int n,long x,long[] a) {
        long res = 0;
        Arrays.sort(a);
        long sum=Arrays.stream(a).sum();
        int currDay = 0;

        for (int i=n-1;i>=0;i--) {
            if (sum+(i+1)*currDay > x) {
                sum -= a[i];
                continue;
            }

            long diff = x - (sum+(i+1)*currDay);
            long freq = diff/(i+1) + 1;
            res += (freq * (i+1));

            currDay += freq;
            sum -= a[i];
        }

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