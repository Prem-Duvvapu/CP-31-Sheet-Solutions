import java.io.*;
import java.util.*;

public class Raspberries {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n=fr.nextInt();
            int k=fr.nextInt();
            int[] a=new int[n];

            for (int i=0;i<n;i++)
                a[i]=fr.nextInt();

            //make call to execute the logic
            solution.solve(a,k,n);

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
    public void solve(int[] a,int k,int n) {


        if (k == 2 || k == 3 || k == 5) {
            int minOps = 5;

            for (int val : a) {
                if (val % k == 0) {
                    sb.append(0);
                    return;
                }
                minOps = Math.min(minOps, k - val % k);
            }

            sb.append(minOps);
            return;
        }

        //if k==4
        int twosCnt = 0;
        int minOps = 4;
        for (int val : a) {
            twosCnt += getTwoFactorsCnt(val);
            minOps = Math.min(minOps, 4 - val % 4);
        }

        sb.append(Math.min(minOps,Math.max(0,2-twosCnt)));
    }

    private int getTwoFactorsCnt(int n) {
        int cnt=0;

        while (n%2==0) {
            cnt++;
            n/=2;
        }

        return cnt;
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