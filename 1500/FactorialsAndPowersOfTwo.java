import java.io.*;
import java.util.*;

public class FactorialsAndPowersOfTwo {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
//        int t=1;

        Solution solution=new Solution();

        List<Long> list = new ArrayList<>();
        long fact = 1;
        for (int i=1;i<=14;i++) {
            fact *= i;
            list.add(fact);
        }

        while (t-- > 0) {
            //take input
            long n = fr.nextLong();

            //make call to execute the logic
            solution.solve(n,list);

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
    public void solve(long n,List<Long> list) {
        int res = helper(0,n,list);
        sb.append(res);
    }

    private int helper(int pos,long n, List<Long> list) {
        if (pos == list.size()) {
            return getOneBitsCnt(n);
        }

        int pick = 64;
        if (list.get(pos) <= n)
            pick = 1 + helper(pos+1,n-list.get(pos),list);

        int notPick = helper(pos+1,n,list);
        return Math.min(pick,notPick);
    }

    private int getOneBitsCnt(long n) {
        int cnt = 0;
        for (int i=0;i<=41;i++)
            cnt += ((n>>i)&1);

        return cnt;
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