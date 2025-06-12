import java.io.*;
import java.util.*;

public class RedVersusBlue {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n=fr.nextInt();
            int r=fr.nextInt();
            int b=fr.nextInt();

            //make call to execute the logic
            solution.solve(n,r,b);

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
    public void solve(int n,int r,int b) {
        StringBuilder res=new StringBuilder();

        int p=r/(b+1);
        int q=r%(b+1);

        //Pigeonhole principle
        //Total (b+1) regions
        //(p+1) R's in q regions and p R's in remaining regions

        while (q-- > 0) {
            attach(res,p+1,'R');
            res.append('B');
        }

        while (res.length() < n) {
            attach(res,p,'R');
            if (res.length()<n)
                res.append('B');
        }

        sb.append(res);
    }

    public void attach(StringBuilder sb,int freq,char ch) {
        for (int i=0;i<freq;i++)
            sb.append(ch);
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