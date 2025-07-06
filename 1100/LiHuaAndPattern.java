import java.io.*;
import java.util.*;

public class LiHuaAndPattern {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int k = fr.nextInt();
            int[][] a = new int[n][n];

            for (int i=0;i<n;i++)
                for (int j=0;j<n;j++)
                    a[i][j]=fr.nextInt();

            //make call to execute the logic
            solution.solve(n,k,a);

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
    public void solve(int n,int k,int[][] a) {
        int topRow = 0;
        int bottomRow = n-1;
        int reqOps = 0;

        while (topRow<bottomRow) {
            for (int i=0;i<n;i++)
                reqOps += Math.abs(a[topRow][i]-a[bottomRow][n-1-i]);

            topRow++;
            bottomRow--;
        }

        if (topRow==bottomRow) {
            for (int i=0;i<n/2;i++)
                reqOps += Math.abs(a[topRow][i]-a[bottomRow][n-1-i]);
        }

        if (k<reqOps)
            sb.append("No");
        else {
            k -= reqOps;

            if ((n&1)==1)
                sb.append("Yes");
            else if ((k&1)==1)
                sb.append("No");
            else
                sb.append("Yes");
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