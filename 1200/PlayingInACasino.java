import java.io.*;
import java.util.*;

public class PlayingInACasino {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int m = fr.nextInt();
            int[][] c = new int[n][m];

            for (int i=0;i<n;i++)
                for (int j=0;j<m;j++)
                    c[i][j] = fr.nextInt();

            //make call to execute the logic
            solution.solve(n,m,c);

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
    public void solve(int n,int m,int[][] c) {
        long res = 0;

        for (int j=0;j<m;j++) {
            long[] colArr = new long[n];
            long suffixSum = 0;
            long subCnt = 1;

            for (int i=0;i<n;i++)
                colArr[i] = c[i][j];

            Arrays.sort(colArr);

            for (int i=n-1;i>0;i--) {
                suffixSum += colArr[i];
                res += (suffixSum - colArr[i-1]*subCnt);
                subCnt++;
            }
        }

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