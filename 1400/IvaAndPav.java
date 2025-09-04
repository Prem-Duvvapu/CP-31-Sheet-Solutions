import java.io.*;
import java.util.*;

public class IvaAndPav {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
//        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int[] a = new int[n+1];

            for (int i=1;i<n+1;i++)
                a[i] = fr.nextInt();

            int q = fr.nextInt();
            int[][] queries = new int[q][2];
            for (int i=0;i<q;i++) {
                queries[i][0] = fr.nextInt();
                queries[i][1] = fr.nextInt();
            }

            //make call to execute the logic
            solution.solve(n,a,q,queries);

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
    public void solve(int n,int[] a,int q,int[][] queries) {
        int[][] prefixBitCount = new int[n+1][30];

        for (int i=1;i<n+1;i++) {
            for (int j=0;j<30;j++)
                prefixBitCount[i][j] = ((a[i]>>j)&1) + prefixBitCount[i-1][j];
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int i=0;i<q;i++) {
            int res = -1;
            int l = queries[i][0];
            int k = queries[i][1];

            int low = l;
            int high = n;

            while (low <= high) {
                int mid = low + (high - low)/2;
                if (isPossible(l,mid,k,prefixBitCount,n)) {
                    res = mid;
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }

            sj.add(Integer.toString(res));
        }

        sb.append(sj);
    }

    private boolean isPossible(int l,int mid,int k, int[][] prefixBitCount, int n) {
        int sum = 0;

        for (int j=0;j<30;j++) {
            int diff = prefixBitCount[mid][j] - prefixBitCount[l-1][j];
            if (diff == (mid-l+1))
                sum += (1 << j);
        }

        return (sum >= k);
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