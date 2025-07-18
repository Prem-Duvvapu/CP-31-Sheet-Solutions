import java.io.*;
import java.util.*;

public class JoJosIncredibleAdventures {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            String s=fr.next();

            //make call to execute the logic
            solution.solve(s);

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
    public void solve(String s) {
        int n=s.length();
        s = s+s;
        int maxConsecutiveOnes = 0;
        int currConsecutiveOnes = 0;

        for (char ch: s.toCharArray()) {
            if (ch=='1') {
                currConsecutiveOnes++;
                maxConsecutiveOnes = Math.max(maxConsecutiveOnes, currConsecutiveOnes);
            } else {
                currConsecutiveOnes = 0;
            }
        }

        if (maxConsecutiveOnes<=1) {
            sb.append(maxConsecutiveOnes);
            return;
        } else if (maxConsecutiveOnes==2*n) {
            sb.append((long)n*n);
            return;
        }

        long res = maxConsecutiveOnes;
        for (long i=1;i<(long)n;i++) {
            res= Math.max(res, (maxConsecutiveOnes-i)*(i+1));
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