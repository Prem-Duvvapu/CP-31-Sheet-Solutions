import java.io.*;
import java.util.*;

public class Coprime {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int[] a = new int[n];

            for (int i=0;i<n;i++)
                a[i] = fr.nextInt();

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
    public void solve(int n, int[] a) {
        int[] lastIndex = new int[1000+1];
        Arrays.fill(lastIndex,-1);
        int res=-1;

        for (int i=0;i<n;i++)
            lastIndex[a[i]] = i+1;

        for (int i=1;i<=1000;i++) {
            if (lastIndex[i]==-1)
                    continue;

            for (int j=i;j<=1000;j++) {
                if (lastIndex[j]==-1)
                    continue;

                if (getGCD(i,j)==1)
                    res = Math.max(res, lastIndex[i]+lastIndex[j]);
            }
        }

        sb.append(res);
    }

    private int getGCD(int a,int b) {
        if (b==0)
            return a;

        return getGCD(b,a%b);
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