import java.io.*;
import java.util.*;

public class DoubleEndedStrings {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            String a=fr.next();
            String b=fr.next();

            //make call to execute the logic
            solution.solve(a,b);

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
    public void solve(String a,String b) {
        int maxCommonSubStringLen=0;

        for (int i=a.length()-1;i>=0;i--)
            for (int j=b.length()-1;j>=0;j--)
                maxCommonSubStringLen=Math.max(maxCommonSubStringLen,LongestCommonSubString(i,j,a,b));

        int res=a.length()+b.length()-2*maxCommonSubStringLen;
        sb.append(res);
    }

    public int LongestCommonSubString(int i,int j,String a,String b) {
        if (i<0 || j<0)
            return 0;

        if (a.charAt(i)==b.charAt(j))
            return 1+LongestCommonSubString(i-1,j-1,a,b);

        return 0;
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