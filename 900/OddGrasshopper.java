import java.io.*;
import java.util.*;

public class OddGrasshopper {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            long x=fr.nextLong();
            long n=fr.nextLong();

            //make call to execute the logic
            solution.solve(x,n);

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
    public void solve(long x,long n) {
        if (n%4==0) {
            sb.append(x);
        } else if (n%4==1) {
            if ((x&1)==0)
                sb.append(x-n);
            else
                sb.append(x+n);
        } else if (n%4==2) {
            if ((x&1)==0)
                sb.append(x+1);
            else
                sb.append(x-1);
        } else {
            if ((x&1)==0)
                sb.append(x+(n+1));
            else
                sb.append((x-(n+1)));
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