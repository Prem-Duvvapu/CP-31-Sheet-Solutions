import java.io.*;
import java.util.*;

public class MakeThemEqual {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            char c = fr.next().charAt(0);
            String s = fr.next();

            //make call to execute the logic
            solution.solve(n,c,s);

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
    public void solve(int n,char c,String s) {
        int notCcnt = 0;
        for (char ch: s.toCharArray())
            if (ch != c)
                notCcnt++;

        if (notCcnt == 0) {
            sb.append(0).append("\n");
            return;
        } else if (s.charAt(n-1) == c) {
            sb.append(1).append("\n");
            sb.append(n);
            return;
        } else {
            boolean flag = true;

            for (int i=n-1;i>1;i--) {
                if (s.charAt(i-1) != c)
                    continue;

                for (int j=2*i;j<=n;j+=i) {
                    if (s.charAt(j-1) != c) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    sb.append(1).append("\n");
                    sb.append(i);
                    return;
                }
            }
        }

        sb.append(2).append("\n");
        sb.append(n-1).append(" ").append(n);
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