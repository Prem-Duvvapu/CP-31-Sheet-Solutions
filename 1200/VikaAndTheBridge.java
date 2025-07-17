import java.io.*;
import java.util.*;

public class VikaAndTheBridge {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int k = fr.nextInt();
            int[] c = new int[n];

            for (int i=0;i<n;i++)
                c[i] = fr.nextInt();

            //make call to execute the logic
            solution.solve(n,k,c);

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
    public void solve(int n,int k,int[] c) {
        int res = n;
        int[] lastStep = new int[k+1];
        PriorityQueue<Integer>[] maxSteps = new PriorityQueue[k+1];

        Arrays.fill(lastStep,-1);
        for (int i=1;i<=k;i++)
            maxSteps[i] = new PriorityQueue<>();

        for (int i=0;i<n;i++) {
            int color = c[i];
            int diff = i - lastStep[color] -1;
            maxSteps[color].add(diff);

            if (maxSteps[color].size()>2)
                maxSteps[color].poll();

            lastStep[color] = i;
        }

        for (int i=1;i<=k;i++) {
            int diff = n - lastStep[i] - 1;
            maxSteps[i].add(diff);

            if (maxSteps[i].size()>2)
                maxSteps[i].poll();

            int secondMax = Integer.MAX_VALUE;
            int firstMax;

            if (maxSteps[i].size()==1) {
                firstMax = maxSteps[i].poll();
            } else {
                secondMax = maxSteps[i].poll();
                firstMax = maxSteps[i].poll();
            }

            firstMax /= 2;
            int currRes = Math.max(firstMax, secondMax);
            res = Math.min(res, currRes);
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