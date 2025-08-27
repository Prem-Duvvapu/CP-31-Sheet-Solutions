import java.io.*;
import java.util.*;

public class Shuffle {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int x = fr.nextInt();
            int m = fr.nextInt();

            //make call to execute the logic
            solution.solve(n,x,m,fr);

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
    public void solve(int n,int x,int m,FastReader fr) {
        int left = n+1;
        int right = -1;

        for (int i=0;i<m;i++) {
            int l = fr.nextInt();
            int r = fr.nextInt();

            if (l <= x && x <= r) {
                left = Math.min(left, l);
                right = Math.max(right, r);
            } else if ((left <= l && l <= right) || (left <= r && r <= right)) {
                left = Math.min(left, l);
                right = Math.max(right, r);
            }
        }

        int res = Math.max(1,right - left + 1);

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