import java.io.*;
import java.util.*;

public class CardboardForPictures {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n=fr.nextInt();
            long c=fr.nextLong();
            long[] s=new long[n];

            for (int i=0;i<n;i++)
                s[i]=fr.nextLong();

            //make call to execute the logic
            solution.solve(n,c,s);

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
    public void solve(int n,long c,long[] s) {
        long low=0;
        long high=(long)1e9;
        long res=0;

        while (low<=high) {
            long mid=low+(high-low)/2;

            if (isPossible(mid,n,c,s)) {
                res=mid;
                low=mid+1;
            } else {
                high=mid-1;
            }
        }

        sb.append(res);
    }

    private boolean isPossible(long mid, int n, long c, long[] s) {
        long total=0;

        for (long side: s) {
            total+=((side+2*mid)*(side+2*mid));

            if (total>c)
                return false;
        }

        return true;
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