import java.io.*;
import java.util.*;

public class MirrorGrid {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int[][] a = new int[n][n];

            for (int i=0;i<n;i++) {
                String s = fr.next();

                for (int j = 0; j < n; j++)
                    a[i][j] = '1' - s.charAt(j);
            }

            //make call to execute the logic
            solution.solve(n,a);

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
    public void solve(int n,int[][] a) {
        int res = 0;
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;

        while (rowStart<rowEnd && colStart<colEnd) {
            int[] temp = new int[colEnd-colStart];

            //top
            int pos = 0;
            for (int j=colStart;j<colEnd;j++)
                temp[pos++] += a[rowStart][j];

            //right
            pos = 0;
            for (int i=rowStart;i<rowEnd;i++)
                temp[pos++] += a[i][colEnd];

            //bottom
            pos = 0;
            for (int j=colEnd;j>colStart;j--)
                temp[pos++] += a[rowEnd][j];

            //left
            pos = 0;
            for (int i=rowEnd;i>rowStart;i--)
                temp[pos++] += a[i][colStart];

            for (int i=0;i<temp.length;i++) {
                if (temp[i]==1 || temp[i]==3)
                    res += 1;
                else if (temp[i]==2)
                    res += 2;
            }

            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
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