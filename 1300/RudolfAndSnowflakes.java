import java.io.*;
import java.util.*;

public class RudolfAndSnowflakes {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        Solution solution=new Solution();

        boolean[] visited = new boolean[1_000_000 + 1];

        for (long k=2;k<1_000_000L;k++) {
            long start = 1 + k + k*k;
            if (start > 1_000_000L)
                break;

            long lastVal = k*k;

            for (long i=start;i<=1_000_000L;i+=lastVal) {
                visited[(int)i] = true;
                lastVal*=k;
            }
        }

        int t=fr.nextInt();
        // int t=1;

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();

            //make call to execute the logic
            solution.solve(n,visited);

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
    public void solve(int n, boolean[] visited) {
        if (visited[n])
            sb.append("YES");
        else
            sb.append("NO");
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