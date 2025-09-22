import java.io.*;
import java.util.*;

public class SmiloAndMonsters {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
//        int t=1;

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
        Arrays.sort(a);
        long res = 0;
        int low = 0;
        int high = n-1;
        int x= 0;

        while (low < high) {
            if (x+ a[low] <= a[high]) {
                res += a[low];
                x += a[low];

                if (x == a[high]) {
                    res += 1;
                    x = 0;
                    high--;
                }
                low++;
            } else if (x+a[low] > a[high]) {
                int req = (a[high] - x);
                res += req;
                a[low] -= req;
                res++;
                high --;
                x= 0;
            }
        }

        if (low > high) {
            sb.append(res);
            return;
        }

        if (a[high] == x) {
            res += 1;
        } else if (a[high] > x) {
            if (x == 1) {
                res += (a[high]/2 + 1);
                res += a[high]%2;
            } else {
                a[high] -= x;
                res += 1;
                res += (a[high]/2 + 1);
                res += a[high]%2;
            }
        }

        sb.append(res);
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