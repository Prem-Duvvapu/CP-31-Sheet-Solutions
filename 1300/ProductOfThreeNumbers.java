import java.io.*;
import java.util.*;

public class ProductOfThreeNumbers {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            long n = fr.nextLong();

            //make call to execute the logic
            solution.solve(n);

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
    public void solve(long n) {
        for (long i=2;i*i<=n;i++) {
            if (n%i == 0) {
                long firstFactor = -1;
                long f1 = i;
                long f2 = n/i;

                // split f1
                firstFactor = f2;
                for (long j=2;j*j<=f1;j++) {
                    if (f1%j == 0) {
                        long f3 = j;
                        long f4 = f1/j;

                        if (f3 != firstFactor && f4 != firstFactor && f3 != f4) {
                            sb.append("YES").append("\n");
                            sb.append(firstFactor).append(" ").append(f3).append(" ").append(f4);
                            return;
                        }
                    }
                }

                // split f2
                firstFactor = f1;
                for (long j=2;j*j<=f2;j++) {
                    if (f2%j == 0) {
                        long f3 = j;
                        long f4 = f2/j;

                        if (f3 != firstFactor && f4 != firstFactor && f3 != f4) {
                            sb.append("YES").append("\n");
                            sb.append(firstFactor).append(" ").append(f3).append(" ").append(f4);
                            return;
                        }
                    }
                }
            }
        }

        sb.append("NO");
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