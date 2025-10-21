import java.io.*;
import java.util.*;

public class ThirteenthLabourOfHeracles {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
//        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int[] wt = new int[n];
            for (int i=0;i<n;i++)
                wt[i] = fr.nextInt();
            int[] degree = new int[n];
            for (int i=0;i<n-1;i++) {
                int u = fr.nextInt();
                int v = fr.nextInt();
                u-=1;
                v-=1;
                degree[u]++;
                degree[v]++;
            }

            //make call to execute the logic
            solution.solve(n,wt,degree);

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
    public void solve(int n,int[] wt,int[] degree) {
        StringJoiner sj = new StringJoiner(" ");
        long sum = 0;
        for (int val: wt)
            sum += val;

        sj.add(String.valueOf(sum));
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> Integer.compare(wt[y], wt[x]));

        for (int i=0;i<n;i++)
            if (degree[i] >= 2)
                pq.add(i);

        for (int k=2;k<n;k++) {
            int top = pq.peek();
            sum += wt[top];
            degree[top]--;
            if (degree[top] == 1)
                pq.poll();
            sj.add(String.valueOf(sum));
        }

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