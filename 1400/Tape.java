import java.io.*;
import java.util.*;

public class Tape {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

//        int t=fr.nextInt();
        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int m = fr.nextInt();
            int k = fr.nextInt();
            int[] b = new int[n];

            for (int i=0;i<n;i++)
                b[i] = fr.nextInt();

            //make call to execute the logic
            solution.solve(n,m,k,b);

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
    public void solve(int n,int m,int k,int[] b) {
        Arrays.sort(b);
        int res = n;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i=0;i<n-1;i++)
            pq.add(b[i+1] - b[i] - 1);

        int req = n-k;
        while (req > 0) {
            res += pq.poll();
            req--;
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