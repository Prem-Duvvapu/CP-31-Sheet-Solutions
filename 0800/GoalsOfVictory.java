import java.io.*;
import java.util.*;

public class GoalsOfVictory {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n=fr.nextInt();
            int[] a=new int[n-1];

            for (int i=0;i<a.length;i++)
                a[i]=fr.nextInt();

            //make call to execute the logic
            solution.solve(a,n,out);
        }

        out.close();
    }
}

class Solution {
    //write logic here and print the result
    public void solve(int[] a,int n,PrintWriter out) {
        int remainingGoals=0;

        for (int i=0;i<a.length;i++)
            remainingGoals+=a[i];

        out.println(remainingGoals*-1);
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