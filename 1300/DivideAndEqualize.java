import java.io.*;
import java.util.*;

public class DivideAndEqualize {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take
            int n = fr.nextInt();
            int[] a = new int[n];

            for (int i=0;i<n;i++)
                a[i] = fr.nextInt();

            //make call to execute the logic
            solution.solve(n,a);

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
    public void solve(int n, int[] a) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int val: a) {
            primeFactors(val, map);
//            System.out.println(map);
        }

        for (int divisorFreq: map.values()) {
            if (divisorFreq%n != 0) {
                sb.append("NO");
                return;
            }
        }

        sb.append("YES");
    }

    public void primeFactors(int num, Map<Integer, Integer> map) {
        while (num%2 == 0) {
            map.put(2, map.getOrDefault(2,0)+1);
            num /= 2;
        }

        for (int i=3;(long)i*i<=num;i+=2) {
            while (num%i == 0) {
                map.put(i, map.getOrDefault(i,0)+1);
                num /= i;
            }
        }

        if (num > 2)
            map.put(num, map.getOrDefault(num,0)+1);
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