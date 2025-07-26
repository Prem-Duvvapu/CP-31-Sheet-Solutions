import java.io.*;
import java.util.*;

public class StoneAgeProblem {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

//        int t=fr.nextInt();
         int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int q = fr.nextInt();
            long[] a = new long[n];

            for (int i=0;i<n;i++)
                a[i] = fr.nextLong();

            //make call to execute the logic
            solution.solve(n,q,a,fr);

            //new line after test case ans
            solution.sb.append("\n");
        }

        out.println(solution.sb);

        out.close();
    }
}

class Pair {
    long value;
    int lastUpdated;

    Pair(long value, int lastUpdated) {
        this.value = value;
        this.lastUpdated = lastUpdated;
    }
}

class Solution {
    public static final int INT_MOD=1_000_000_007;
    public static final long LONG_MOD=1_000_000_007L;

    public StringBuilder sb=new StringBuilder();

    //write logic here and print the result
    public void solve(int n,int q,long[] a,FastReader fr) {
        Pair[] lastQuery = new Pair[n+1];
        long[] res = new long[q+1];
        long totalSum = 0;
        int lastQuery2 = -1;
        long lastQuery2Val = 0;

        for (long val: a)
            totalSum += val;

        for (int i=1;i<=n;i++)
            lastQuery[i] = new Pair(a[i-1],0);

        for (int j=1;j<=q;j++) {
            int t = fr.nextInt();
            int i = 0;
            if (t == 1)
                i = fr.nextInt();
            long x = fr.nextInt();

            if (t == 1) {
                if (lastQuery[i].lastUpdated<lastQuery2) {
                    totalSum -= lastQuery2Val;
                    totalSum += x;
                    lastQuery[i].value = x;
                    lastQuery[i].lastUpdated = j;
                } else {
                    totalSum -= lastQuery[i].value;
                    totalSum += x;
                    lastQuery[i].value = x;
                    lastQuery[i].lastUpdated = j;
                }
            } else {
                totalSum = n*x;
                lastQuery2 = j;
                lastQuery2Val = x;
            }

            res[j] = totalSum;
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int i=1;i<=q;i++)
            sj.add(Long.toString(res[i]));

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