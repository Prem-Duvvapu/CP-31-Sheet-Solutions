import java.io.*;
import java.util.*;

public class Desorting {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n=fr.nextInt();
            int[] a=new int[n];

            for (int i=0;i<n;i++)
                a[i]=fr.nextInt();

            //make call to execute the logic
            solution.solve(a,n,out);
        }

        out.close();
    }
}

class Solution {
    //write logic here and print the result
    public void solve(int[] a,int n,PrintWriter out) {
        int minOps=Integer.MAX_VALUE;

        for (int i=1;i<n;i++) {
            if (a[i]-a[i-1]<0) {
                out.println(0);
                return;
            }

            int currOps=(a[i]-a[i-1])/2+1;
            minOps=Math.min(minOps,currOps);
        }

        out.println(minOps);
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