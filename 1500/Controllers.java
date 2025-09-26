import java.io.*;
import java.util.*;

public class Controllers {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

//        int t=fr.nextInt();
        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            String s = fr.next();
            int q = fr.nextInt();
            int[][] queries = new int[q][2];
            for (int i=0;i<q;i++) {
                queries[i][0] = fr.nextInt();
                queries[i][1] = fr.nextInt();
            }

            //make call to execute the logic
            solution.solve(n,s,queries);

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
    public void solve(int n,String s,int[][] queries) {
        long c1 = 0;
        for (char ch: s.toCharArray()) {
            if (ch == '+')
                c1++;
        }
        c1 = Math.min(c1,n-c1);
        long c2 = n-c1;


        StringJoiner sj = new StringJoiner("\n");
        for (int[] query: queries) {
            if (c1 == c2) {
                sj.add("YES");
                continue;
            }

            long a = Math.max(query[0],query[1]);
            long b = Math.min(query[0],query[1]);

            if (a == b) {
                sj.add("NO");
                continue;
            }

            long lcm = getLCM(a,b);
            long x = lcm/a;
            long y = lcm/b;

            // a*x = b*y

            long diff = Math.abs(c1 - c2);
            if (diff % Math.abs(x-y) != 0) {
                sj.add("NO");
            } else {
                long p = diff / Math.abs(x-y);
                if (p*(x+y) <= n)
                    sj.add("YES");
                else
                    sj.add("NO");
            }
        }

        sb.append(sj);
    }

    private long getLCM(long a, long b) {
        return (a*b)/getGCD(a,b);
    }

    private long getGCD(long a, long b) {
        if (b == 0)
            return a;

        return getGCD(b,a%b);
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