import java.io.*;
import java.util.*;

public class MEXorMixup {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();
//        solution.calcXor();

        while (t-- > 0) {
            //take input
            int a=fr.nextInt();
            int b=fr.nextInt();

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
    public int[] xorArr=new int[3*100000+1];

    //write logic here and print the result
    public void solve(int a,int b) {
        int xorVal=0;

        if ((a-1)%4==0)
            xorVal=a-1;
        else if ((a-1)%4==1)
            xorVal=1;
        else if ((a-1)%4==2)
            xorVal=a;
        else
            xorVal=0;

        int arrLen=a; //includes zero also

        if (xorVal!=b) {
            int requiredNum=xorVal^b;

            if (requiredNum!=a) {
                arrLen+=1;
            } else {
                arrLen+=2;
            }
        }

        sb.append(arrLen);
    }

    public void calcXor() {
        for (int i=1;i<xorArr.length;i++)
            xorArr[i]=(i^xorArr[i-1]);
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