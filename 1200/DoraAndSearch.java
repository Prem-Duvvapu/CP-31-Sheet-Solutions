import java.io.*;
import java.util.*;

public class DoraAndSearch {
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
    public void solve(int n,int[] a) {
        if (n<4) {
            sb.append(-1);
            return;
        }

        int low = 0;
        int high = n-1;
        int minVal = 1;
        int maxVal = n;

        while (low<high && minVal<maxVal) {
            if (a[low]!=minVal && a[low]!=maxVal && a[high]!=minVal && a[high]!=maxVal) {
                sb.append(low+1).append(" ").append(high+1);
                return;
            }

            if (a[low] == minVal) {
                minVal++;
                low++;
            } else if (a[low] == maxVal) {
                maxVal--;
                low++;
            }  else if (a[high] == minVal) {
                minVal++;
                high--;
            } else {
                maxVal--;
                high--;
            }
        }

        sb.append(-1);
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