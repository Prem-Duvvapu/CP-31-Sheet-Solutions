import java.io.*;
import java.util.*;

public class JohnnyAndAncientComputer {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            long a=fr.nextLong();
            long b=fr.nextLong();

            //make call to execute the logic
            solution.solve(a,b);

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
    public void solve(long a,long b) {
        int ops=0;

        if (a>b) {
            while (a>b) {
                long temp=a;
                ops++;

                for (int i=0;i<3;i++) {
                    if (a%2==0) {
                        a/=2;
                        if (a==b) {
                            sb.append(ops);
                            return;
                        }
                    }
                }

                if (a==temp)
                    break;
            }
        } else if (a<b) {
            while (a<b) {
                long temp=a;
                ops++;

                for (int i=0;i<3;i++) {
                    a*=2;
                    if (a==b) {
                        sb.append(ops);
                        return;
                    }
                }

                if (a==temp)
                    break;
            }
        }

        if (a==b)
            sb.append(ops);
        else
            sb.append(-1);
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