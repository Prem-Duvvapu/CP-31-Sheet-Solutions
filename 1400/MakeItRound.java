import java.io.*;
import java.util.*;

public class MakeItRound {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
//        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            long n = fr.nextLong();
            long m = fr.nextLong();

            //make call to execute the logic
            solution.solve(n,m);

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
    public void solve(long n,long m) {
        int cnt2 = 0;
        int cnt5 = 0;
        long temp = n;

        while (temp%2 == 0) {
            cnt2++;
            temp /= 2;
        }

        while (temp%5 == 0) {
            cnt5++;
            temp /= 5;
        }

        for (int i=18;i>=0;i--) {
            int reqCnt2 = i;
            int reqCnt5 = i;

            reqCnt2 = Math.max(reqCnt2-cnt2,0);
            reqCnt5 = Math.max(reqCnt5-cnt5,0);

            long k = (long)Math.pow(2,reqCnt2) * (long)Math.pow(5,reqCnt5);
            if (m < k)
                continue;

            long f = m - m%k;
            sb.append(n*f);
            return;
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