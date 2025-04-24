import java.io.*;
import java.util.*;

public class SequenceGame {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n=fr.nextInt();
            int[] b=new int[n];

            for (int i=0;i<n;i++)
                b[i]=fr.nextInt();

            //make call to execute the logic
            solution.solve(b,n,out);
        }

        out.close();
    }
}

class Solution {
    //write logic here and print the result
    public void solve(int[] b,int n,PrintWriter out) {
        StringBuilder a=new StringBuilder();
        StringBuilder res=new StringBuilder();
        int cnt=n;
        a.append(b[0]).append(" ");

        for (int i=1;i<n;i++) {
            if (b[i]<b[i-1]) {
                a.append(1).append(" ");
                cnt++;
            }
            
            a.append(b[i]).append(" ");
        }

        res.append(cnt).append("\n").append(a);
        out.println(res);
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