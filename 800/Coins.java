import java.io.*;
import java.util.*;

public class Coins {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            long n=fr.nextLong();
            long k=fr.nextLong();

            //make call to execute the logic
            solution.solve(n,k);

            solution.res.append("\n");
        }

        out.println(solution.res);

        out.close();
    }
}

class Solution {
    public static final int MOD=1_000_000_007;
    public StringBuilder res=new StringBuilder();

    //write logic here and print the result
    public void solve(long n,long k) {
        if ((n&1)==0L) {
            res.append("YES");
            return;
        }

        if ((n&1)==1L && (k&1)==0L) {
            res.append("NO");
            return;
        }

        res.append("YES");
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