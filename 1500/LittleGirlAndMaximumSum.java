import java.io.*;
import java.util.*;

public class LittleGirlAndMaximumSum {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

//        int t=fr.nextInt();
        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int q = fr.nextInt();
            int[] a = new int[n];
            int[][] arr = new int[q][2];

            for (int i=0;i<n;i++)
                a[i] = fr.nextInt();

            for (int i=0;i<q;i++) {
                arr[i][0] = fr.nextInt();
                arr[i][1] = fr.nextInt();
            }

            //make call to execute the logic
            solution.solve(n,q,a,arr);

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
    public void solve(int n,int q,int[] a,int[][] arr) {
        long res = 0;
        int[] diffArr = new int[n];

        for (int[] temp: arr) {
            int l = temp[0];
            int r = temp[1];
            diffArr[l-1]+=1;
            if (r<n)
                diffArr[r]-=1;
        }

        for (int i=1;i<n;i++)
            diffArr[i]+=diffArr[i-1];

        Arrays.sort(a);
        Arrays.sort(diffArr);

        for (int i=0;i<n;i++)
            res += (diffArr[i] * a[i]);

        sb.append(res);
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