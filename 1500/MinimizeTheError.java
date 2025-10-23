import java.io.*;
import java.util.*;

public class MinimizeTheError {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

//        int t=fr.nextInt();
        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int k1 = fr.nextInt();
            int k2 = fr.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i=0;i<n;i++)
                a[i] = fr.nextInt();

            for (int i=0;i<n;i++)
                b[i] = fr.nextInt();

            //make call to execute the logic
            solution.solve(n,k1,k2,a,b);

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
    public void solve(int n,int k1,int k2,int[] a,int[] b) {
        int k = k1 + k2;
        int totalDiff = 0;
        for (int i=0;i<n;i++)
            totalDiff += Math.abs(a[i] - b[i]);

        if (k == totalDiff) {
            sb.append(0);
            return;
        } else if (k > totalDiff) {
            k -= totalDiff;
            if (k%2 == 0)
                sb.append(0);
            else
                sb.append(1);
            return;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x,y) -> Integer.compare(y,x));
        for (int i=0;i<n;i++)
            maxHeap.add(Math.abs(a[i] - b[i]));

        while (k > 0) {
            int top = maxHeap.poll();
            top -= 1;
            k--;

            if (top != 0)
                maxHeap.add(top);
        }

        long res = 0;
        while (!maxHeap.isEmpty()) {
            int top = maxHeap.poll();
            res += ((long)top * top);
        }

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