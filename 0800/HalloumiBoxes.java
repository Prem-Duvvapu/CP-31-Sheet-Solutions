import java.io.*;
import java.util.*;

public class HalloumiBoxes {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            int n=fr.nextInt();
            int k=fr.nextInt();
            int[] a=new int[n];

            for (int i=0;i<n;i++)
                a[i]=fr.nextInt();

            solution.solve(a,k,n,out);
        }

        out.close();
    }
}

class Solution {
    public void solve(int[] a,int k,int n,PrintWriter out) {
        StringBuilder res=new StringBuilder();
        if (k==1) {
            for (int i=1;i<n;i++) {
                if (a[i]<a[i-1]) {
                    res.append("NO");
                    out.println(res);
                    return;
                }
            }
        }
        
        res.append("YES");
        out.println(res);
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