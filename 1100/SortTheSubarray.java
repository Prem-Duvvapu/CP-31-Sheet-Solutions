import java.io.*;
import java.util.*;

public class SortTheSubarray {
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
            int[] a_ = new int[n];

            for (int i=0;i<n;i++)
                a[i] = fr.nextInt();

            for (int i=0;i<n;i++)
                a_[i] = fr.nextInt();

            //make call to execute the logic
            solution.solve(n,a,a_);

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
    public void solve(int n,int[] a,int[] a_) {
        int l=-1;
        int r=-1;

        for (int i=0;i<n;i++) {
            if (a[i]!=a_[i]) {
                if (l==-1) {
                    l = i;
                    r = i;
                } else {
                    r = i;
                }
            }
        }

        int i=l-1;
        while (i>=0) {
            if (a[i]<=a_[i+1]) {
                i--;
            } else {
                break;
            }
        }

        int j=r+1;
        while (j<n) {
            if (a[j]>=a_[j-1]) {
                j++;
            } else {
                break;
            }
        }

        l=i+1;
        r=j-1;

        sb.append(l+1).append(" ").append(r+1);
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