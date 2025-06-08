import java.io.*;
import java.util.*;

public class BeautifulArray {
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
            int b=fr.nextInt();
            long s=fr.nextLong();

            //make call to execute the logic
            solution.solve(n,k,b,s);

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
    public void solve(long n,long k,long b,long s) {
        long minS=k*b;
        long maxS=k*b+n*(k-1);

        if (s<minS || s>maxS) {
            sb.append(-1);
            return;
        }

        long[] res=new long[(int)n];
        res[0]=k*b;
        s-=k*b;

        for (int i=0;i<n;i++) {
            res[i]+=Math.min(s,k-1);
            s-=Math.min(s,k-1);
        }

        StringJoiner sj=new StringJoiner(" ");
        for (long val: res)
            sj.add(Long.toString(val));

        sb.append(sj);
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