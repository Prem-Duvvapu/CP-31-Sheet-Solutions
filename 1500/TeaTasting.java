import java.io.*;
import java.util.*;

public class TeaTasting {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
//        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i=0;i<n;i++)
                a[i] = fr.nextInt();

            for (int i=0;i<n;i++)
                b[i] = fr.nextInt();

            //make call to execute the logic
            solution.solve(n,a,b);

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
    public void solve(int n,int[] a,int[] b) {
        long[] res = new long[n];
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        long currCut = 0;
        long prevCut = 0;

        for (int i=0;i<n;i++) {
            minHeap.add(a[i]+prevCut);
            currCut += b[i];

            while (!minHeap.isEmpty() && minHeap.peek() <= currCut) {
                res[i] += minHeap.poll() - prevCut;
            }

            res[i] += (minHeap.size()*(long)b[i]);
            prevCut = currCut;
        }

        StringJoiner sj = new StringJoiner(" ");
        for (long val: res)
            sj.add(String.valueOf(val));

        sb.append(sj);
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