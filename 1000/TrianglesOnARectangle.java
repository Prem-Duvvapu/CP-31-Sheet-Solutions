import java.io.*;
import java.util.*;

public class TrianglesOnARectangle {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int w=fr.nextInt();
            int h=fr.nextInt();

            //make call to execute the logic
            solution.solve(w,h,fr);

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
    public void solve(long w,long h,FastReader fr) {
        long doubleMaxArea=0;

        for (int i=0;i<4;i++) {
            int k=fr.nextInt();
            int first=0;
            int last=0;
            for (int j=0;j<k;j++) {
                int curr=fr.nextInt();
                if (j==0)
                    first=curr;
                else if (j==k-1)
                    last=curr;
            }

            long doubleCurrArea=0;
            if (i<2)
                doubleCurrArea=(last-first)*h;
            else
                doubleCurrArea=(last-first)*w;

            doubleMaxArea=Math.max(doubleMaxArea,doubleCurrArea);
        }

        sb.append(doubleMaxArea);
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