import java.io.*;
import java.util.*;

public class BracketColoring {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
//        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n  = fr.nextInt();
            String s = fr.next();

            //make call to execute the logic
            solution.solve(n,s);

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
    public void solve(int n,String s) {
        int[] bal = new int[n];

        if (s.charAt(0) == '(')
            bal[0] = 1;
        else
            bal[0] = -1;

        for (int i=1;i<n;i++) {
            if (s.charAt(i) == '(')
                bal[i] = bal[i-1] + 1;
            else
                bal[i] = bal[i-1] - 1;
        }

        if (bal[n-1] != 0) {
            sb.append(-1);
            return;
        }

        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int val: bal) {
            minVal = Math.min(minVal, val);
            maxVal = Math.max(maxVal, val);
        }

        StringJoiner sj = new StringJoiner(" ");
        if (minVal == 0 || maxVal == 0) {
            sb.append(1).append("\n");
            for (int i=0;i<n;i++)
                sj.add("1");
            sb.append(sj);
        } else {
            sb.append(2).append("\n");
            for (int i=0;i<n;i++) {
                if (bal[i] > 0) {
                    sj.add("1");
                } else if (bal[i] < 0) {
                    sj.add("2");
                } else {
                    if (bal[i-1] > 0)
                        sj.add("1");
                    else
                        sj.add("2");
                }
            }
            sb.append(sj);
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