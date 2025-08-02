import java.io.*;
import java.util.*;

public class GrassHopperOnALine {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int x=fr.nextInt();
            int k=fr.nextInt();

            //make call to execute the logic
            solution.solve(x,k,out);
        }

        out.close();
    }
}

class Solution {
    //write logic here and print the result
    public void solve(int x,int k,PrintWriter out) {
        StringBuilder res=new StringBuilder();

        if (x%k!=0) {
            res.append(1).append("\n");
            res.append(x);
        } else {
            res.append(2).append("\n");
            res.append(x-1).append(" ").append(1);
        }

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