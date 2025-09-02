import java.io.*;
import java.util.*;

public class JumpingThroughSegments {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
//        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int[][] ranges = new int[n][2];

            for (int i=0;i<n;i++) {
                ranges[i][0] = fr.nextInt();
                ranges[i][1] = fr.nextInt();
            }

            //make call to execute the logic
            solution.solve(n,ranges);

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
    public void solve(int n,int[][] ranges) {
        int low = 0;
        int high = (int)1e9;
        int res = high;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (isPossible(mid,ranges,n)) {
                res = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        sb.append(res);
    }

    private boolean isPossible(int mid, int[][] ranges, int n) {
        int currLeft = 0;
        int currRight = 0;

        for (int i=0;i<n;i++) {
            currLeft = Math.max(currLeft - mid, ranges[i][0]);
            currRight = Math.min(currRight + mid, ranges[i][1]);

            if (currLeft > currRight)
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