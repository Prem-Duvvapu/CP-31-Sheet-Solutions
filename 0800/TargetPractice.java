import java.io.*;
import java.util.*;

public class TargetPractice {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            char[][] grid=new char[10][10];

            for (int i=0;i<10;i++)
                grid[i]=fr.nextLine().toCharArray();

            //make call to execute the logic
            solution.solve(grid,10,out);
        }

        out.close();
    }
}

class Solution {
    //write logic here and print the result
    public void solve(char[][] grid,int n,PrintWriter out) {
        int res=0;

        for (int i=0;i<n;i++)
            for (int j=0;j<n;j++)
                if (grid[i][j]=='X')
                    res+=helper(i,j,n);

        out.println(res);
    }

    public int helper(int r,int c,int n) {
        int topRow=0;
        int bottomRow=n-1;
        int leftCol=0;
        int rightCol=n-1;

        for (int i=0;i<5;i++) {
            if ((r==topRow || r==bottomRow) || (c==leftCol || c==rightCol))
                return i+1;

            topRow++;
            bottomRow--;
            leftCol++;
            rightCol--;
        }

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