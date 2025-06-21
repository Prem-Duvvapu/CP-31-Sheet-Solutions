import java.io.*;
import java.util.*;

public class NumbersBox {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n=fr.nextInt();
            int m=fr.nextInt();
            int[][] a=new int[n][m];

            for (int i=0;i<n;i++)
                for (int j=0;j<m;j++)
                    a[i][j]=fr.nextInt();

            //make call to execute the logic
            solution.solve(n,m,a);

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
    public void solve(int n,int m,int[][] a) {
        int res=0;
        int minVal=101;
        int negCnt=0;

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                res+=Math.abs(a[i][j]);
                minVal=Math.min(minVal,Math.abs(a[i][j]));

                if (a[i][j]<0)
                    negCnt++;
            }
        }

        if ((negCnt&1)==1)
            res-=2*minVal;

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