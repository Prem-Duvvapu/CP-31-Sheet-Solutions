import java.io.*;
import java.util.*;

public class BallInBerland {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
//        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int a = fr.nextInt();
            int b = fr.nextInt();
            int k = fr.nextInt();
            int[] A = new int[k];
            int[] B = new int[k];

            for (int i=0;i<k;i++)
                A[i] = fr.nextInt();

            for (int i=0;i<k;i++)
                B[i] = fr.nextInt();

            //make call to execute the logic
            solution.solve(a,b,k,A,B);

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
    public void solve(int a,int b,int k,int[] A,int[] B) {
        long res = 0;
        int[] degree = new int[2*1_000_00 + 1];

        for (int i=0;i<k;i++) {
            degree[A[i]]++;
            degree[B[i] + 1_000_00]++;
        }

        for (int i=0;i<k;i++) {
            int curr = k - (degree[A[i]] + degree[B[i] + 1_000_00] - 1);
            res += curr;
        }

        res /= 2;
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