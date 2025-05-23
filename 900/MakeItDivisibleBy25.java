import java.io.*;
import java.util.*;

public class MakeItDivisibleBy25 {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            long n=fr.nextLong();

            //make call to execute the logic
            solution.solve(n);

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

    String[] ending={"00","25","50","75"};
    public static final int INF=Integer.MAX_VALUE;

    //write logic here and print the result
    public void solve(long n) {
        int res=INF;
        String s=Long.toString(n);
        for (String lastTwo: ending)
            res=Math.min(res,solve(s,lastTwo));
        sb.append(res);
    }

    public int solve(String s,String lastTwo) {
        int pos=s.length()-1;
        int currAns=0;

        while (pos>=0 && s.charAt(pos)!=lastTwo.charAt(1)) {
            pos--;
            currAns++;
        }

        if (pos<0)
            return INF;

        pos--;

        while (pos>=0 && s.charAt(pos)!=lastTwo.charAt(0)) {
            pos--;
            currAns++;
        }

        if (pos<0)
            return INF;

        return currAns;
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