import java.io.*;
import java.util.*;

public class MakeAP {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int a=fr.nextInt();
            int b=fr.nextInt();
            int c=fr.nextInt();

            //make call to execute the logic
            solution.solve(a,b,c);

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
    public void solve(int a,int b,int c) {
        //a*m
        int diff=c-b;
        if ((b-diff)>0 && (b-diff)%a==0) {
            sb.append("Yes");
            return;
        }

        //b*m
        if (((a+c)&1)==0 && ((a+c)/2)%b==0) {
            sb.append("Yes");
            return;
        }

        //c*m
        diff=b-a;
        if ((b+diff)>0 && (b+diff)%c==0) {
            sb.append("Yes");
            return;
        }

        sb.append("No");
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