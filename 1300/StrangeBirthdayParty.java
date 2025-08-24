import java.io.*;
import java.util.*;

public class StrangeBirthdayParty {
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
            int[] k = new int[n];
            int[] c = new int[m];

            for (int i=0;i<n;i++)
                k[i] = fr.nextInt();

            for (int i=0;i<m;i++)
                c[i] = fr.nextInt();

            //make call to execute the logic
            solution.solve(n,m,k,c);

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
    public void solve(int n,int m,int[] k,int[] c) {
        long res = 0;
        Arrays.sort(k);
        int lastBoughtGiftIndex = -1;

        for (int i=n-1;i>=0;i--) {
            lastBoughtGiftIndex++;
            if (lastBoughtGiftIndex+1 > k[i])
                res += c[k[i]-1];
            else
                res += c[lastBoughtGiftIndex];
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