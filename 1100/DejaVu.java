import java.io.*;
import java.util.*;

public class DejaVu {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n=fr.nextInt();
            int q=fr.nextInt();
            int[] a=new int[n];
            int[] x=new int[q];

            for (int i=0;i<n;i++)
                a[i]=fr.nextInt();

            for (int i=0;i<q;i++)
                x[i]=fr.nextInt();

            //make call to execute the logic
            solution.solve(n,q,a,x);

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
    public void solve(int n,int q,int[] a,int[] x) {
        long[] res=new long[n];
        long[] sum=new long[q];
        boolean[] visited=new boolean[31];

        for (int i=0;i<n;i++)
            res[i]=a[i];

        for (int j=0;j<q;j++) {
            if (visited[x[j]])
                continue;
            visited[x[j]]=true;
            int power2=power(2,x[j]);

            for (int i=0;i<n;i++) {
                if (res[i]%power2==0)
                    res[i]+=(power2/2);
            }
        }

        StringJoiner sj=new StringJoiner(" ");
        for (long val: res)
            sj.add(Long.toString(val));

        sb.append(sj);
    }

    public int power(int base,int x) {
        if (base==1 || x==0)
            return 1;

        int res=1;
        while (x>0) {
            if (x%2==1) {
                res*=base;
                x-=1;
            } else {
                base*=base;
                x/=2;
            }
        }

        return res;
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