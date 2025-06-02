import java.io.*;
import java.util.*;

public class OlyaAndGameWithArrays {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n=fr.nextInt();
            int[][] a=new int[n][];

            for (int i=0;i<n;i++) {
                int m=fr.nextInt();
                a[i]=new int[m];

                for (int j=0;j<m;j++)
                    a[i][j]=fr.nextInt();
            }

            //make call to execute the logic
            solution.solve(a,n);

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
    public void solve(int[][] a,int n) {
        long res=0;
        int smallestFirstVal=Integer.MAX_VALUE;
        int smallestSecondVal=Integer.MAX_VALUE;

        for (int i=0;i<n;i++) {
            int[] curr=getFirstAndSecondSmallestValues(a[i]);

            res+=curr[1];

            smallestFirstVal=Math.min(smallestFirstVal,curr[0]);
            smallestSecondVal=Math.min(smallestSecondVal,curr[1]);
        }

        res-=smallestSecondVal;
        res+=smallestFirstVal;

        sb.append(res);
    }

    public int[] getFirstAndSecondSmallestValues(int[] arr) {
        int len=arr.length;
        int firstSmallestVal=Integer.MAX_VALUE;
        int secondSmallestVal=Integer.MAX_VALUE;

        for (int val: arr) {
            if (val<firstSmallestVal) {
                secondSmallestVal=firstSmallestVal;
                firstSmallestVal=val;
            } else if (val<secondSmallestVal) {
                secondSmallestVal=val;
            }
        }

        return new int[]{firstSmallestVal,secondSmallestVal};
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