import java.io.*;
import java.util.*;

public class ChatBan {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            long k = fr.nextLong();
            long x = fr.nextLong();

            //make call to execute the logic
            solution.solve(k, x);

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
    public void solve(long k, long x) {
        long totalSum = getSum(k) + getSum(k-1);
        if (totalSum <= x) {
            sb.append(2*k-1);
            return;
        }

        long low = 1;
        long high = 2*k-1;
        long res = 1;

        while (low < high) {
            long mid = low + (high - low)/2;

            long currSum = 0;
            if (mid <= k)
                currSum = getSum(mid);
            else {
                currSum = getSum(k) + getSum(k-1) - getSum(2*k - mid - 1);
            }

            if (currSum < x) {
                low = mid+1;
            } else if (currSum > x) {
                res = mid;
                high = mid;
            } else {
                res = mid;
                break;
            }
        }

        sb.append(res);
    }

    public long getSum(long n) {
        if (n <= 0) return 0;
        if ((n & 1) == 0) {  // n is even
            return (n / 2) * (n + 1);
        } else {             // n+1 is even
            return ((n + 1) / 2) * n;
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