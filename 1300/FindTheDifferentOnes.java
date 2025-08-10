import java.io.*;
import java.util.*;

public class FindTheDifferentOnes {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int[] a = new int[n];

            for (int i=0;i<n;i++)
                a[i] = fr.nextInt();

            int q = fr.nextInt();

            //make call to execute the logic
            solution.solve(n,a,q,fr);

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
    public void solve(int n,int[] a,int q,FastReader fr) {
        Stack<Integer> stack = new Stack<>();
        int[] beforeDiffIndex = new int[n];

        for (int i=n-1;i>=0;i--) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            while (!stack.isEmpty() && a[stack.peek()] != a[i]) {
                beforeDiffIndex[stack.pop()] = i;
            }

            stack.push(i);
        }

        while (!stack.isEmpty())
            beforeDiffIndex[stack.pop()] = -1;

        StringJoiner sj = new StringJoiner("\n");
        for (int j=0;j<q;j++) {
            int l = fr.nextInt();
            int r = fr.nextInt();

            if (l >= r || beforeDiffIndex[r-1] == -1 || beforeDiffIndex[r-1] < l-1) {
                sj.add("-1 -1");
            } else {
                sj.add((beforeDiffIndex[r-1]+1)+" "+r);
            }
        }

        sb.append(sj).append("\n");
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