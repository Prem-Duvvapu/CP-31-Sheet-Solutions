import java.io.*;
import java.util.*;

public class DataStructuresFan {
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
            for (int i=0;i<n;i++)
                a[i] = fr.nextInt();
            String s = fr.next();
            int q = fr.nextInt();

            //make call to execute the logic
            solution.solve(n,a,s,q,fr);

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
    public void solve(int n,int[] a,String s,int q,FastReader fr) {
        int[] prefix = new int[n+1];
        prefix[0] = a[0];
        for (int i=1;i<n;i++)
            prefix[i] = prefix[i-1]^a[i];

        int xor0 = 0;
        int xor1 = 0;

        for (int i=0;i<n;i++) {
            if (s.charAt(i) == '0')
                xor0 ^= a[i];
            else
                xor1 ^= a[i];
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int i=0;i<q;i++) {
            int tp = fr.nextInt();
            if (tp == 1) {
                int l = fr.nextInt();
                int r = fr.nextInt();
                l--;
                r--;
                int xorLR = prefix[r];
                if (l>0)
                    xorLR ^= prefix[l-1];
                xor0 ^= xorLR;
                xor1 ^= xorLR;
            } else {
                int g = fr.nextInt();
                if (g == 0)
                    sj.add(String.valueOf(xor0));
                else
                    sj.add(String.valueOf(xor1));
            }
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