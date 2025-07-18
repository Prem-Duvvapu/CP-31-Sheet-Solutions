import java.io.*;
import java.util.*;

public class Scuza {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int q = fr.nextInt();
            int[] a = new int[n];
            int[] k = new int[q];

            for (int i=0;i<n;i++)
                a[i] = fr.nextInt();

            for (int i=0;i<q;i++)
                k[i] = fr.nextInt();

            //make call to execute the logic
            solution.solve(n,q,a,k);

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
    public void solve(int n,int q,int[] a,int[] k) {
        long[] prefixSum = new long[n];
        int[][] arr = new int[n][3];

        prefixSum[0] = a[0];
        arr[0][0] = a[0];
        arr[0][1] = 0;

        for (int i=1;i<n;i++) {
            prefixSum[i] = a[i] + prefixSum[i - 1];

            arr[i][0] = a[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr,(x,y) -> Integer.compare(x[0],y[0]));
        arr[n-1][2]=arr[n-1][1];
        for (int i=n-2;i>=0;i--)
            arr[i][2]=Math.min(arr[i][1],arr[i+1][2]);

//        for (int[] temp: arr)
//            System.out.println(Arrays.toString(temp));

        StringJoiner sj = new StringJoiner(" ");
        for (int query: k) {
            long currRes = helper(query,arr,prefixSum,n);
            sj.add(Long.toString(currRes));
        }

        sb.append(sj);
    }

    private long helper(int query, int[][] arr, long[] prefixSum, int n) {
        int index = upperBound(query,arr,n);
        return (index == -1) ? 0 : prefixSum[index];
    }

    private int upperBound(int query, int[][] arr,int n) {
        int res = n;
        int low = 0;
        int high = n-1;

        while (low<=high) {
            int mid = low+(high-low)/2;

            if (query>=arr[mid][0])
                low = mid+1;
            else {
                res = mid;
                high = mid-1;
            }
        }

        if (res == 0 || res == n)
            return res-1;

        return arr[res][2]-1;
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