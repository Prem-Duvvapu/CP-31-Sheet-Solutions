import java.io.*;
import java.util.*;

public class MakeItAlternating {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            String s = fr.next();

            //make call to execute the logic
            solution.solve(s);

            //new line after test case ans
            solution.sb.append("\n");
        }

        out.println(solution.sb);

        out.close();
    }
}

class Solution {
    public static final int INT_MOD=1_000_000_007;
    public static final long LONG_MOD=998244353;

    public StringBuilder sb=new StringBuilder();

    //write logic here and print the result
    public void solve(String s) {
        int n = s.length();
        List<Integer> list = new ArrayList<>();
        int cnt = 1;

        for (int i=1;i<n;i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                cnt++;
            } else {
                list.add(cnt);
                cnt = 1;
            }
        }
        list.add(cnt);

        int k = list.size();
        long res = 1;
        for (int val: list)
            res = (res * val)%LONG_MOD;

        res = (res * getFactorial(n - k))%LONG_MOD;

        sb.append(n-k).append(" ").append(res);
    }

    public long getFactorial(int n) {
        long product = 1;
        for (int i=2;i<=n;i++)
            product = (product*i)%LONG_MOD;

        return product;
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