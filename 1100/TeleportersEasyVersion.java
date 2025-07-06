import java.io.*;
import java.util.*;

public class TeleportersEasyVersion {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int c = fr.nextInt();
            int[] a = new int[n+1];

            for (int i=1;i<n+1;i++)
                a[i] = fr.nextInt();

            //make call to execute the logic
            solution.solve(n,c,a);

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
    public void solve(int n,int c,int[] a) {
        int maxTeleporters = 0;
        long[] reqCoins = new long[n+1];

        for (int i=1;i<n+1;i++)
            reqCoins[i] = (a[i]+i);

        Arrays.sort(reqCoins);
        for (int i=1;i<n+1;i++) {
            if (reqCoins[i]>c)
                break;

            maxTeleporters++;
            c-=reqCoins[i];
        }

        sb.append(maxTeleporters);
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