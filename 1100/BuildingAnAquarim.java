import java.io.*;
import java.util.*;

public class BuildingAnAquarim {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take
            int n=fr.nextInt();
            int x=fr.nextInt();
            int[] a=new int[n];

            for (int i=0;i<n;i++)
                a[i]=fr.nextInt();

            //make call to execute the logic
            solution.solve(n,x,a);

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
    public void solve(int n,int x,int[] a) {
        long low=0;
        long high=(long)1e10;
        long ans=0;

        while (low<=high) {
            long mid=low+(high-low)/2;

            if (isPossible(mid,n,x,a)) {
                ans=mid;
                low=mid+1;
            } else {
                high=mid-1;
            }
        }

        sb.append(ans);
    }

    private boolean isPossible(long mid, int n, int x, int[] a) {
        long w=0;

        for (int val: a) {
            w=w+Math.max(0,mid-val);
        }

        return (w<=(long)x);
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