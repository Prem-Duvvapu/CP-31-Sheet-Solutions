import java.io.*;
import java.util.*;

public class ArrayElimination {
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
    public void solve(int n,int[] a) {
        int[] bitFreq = new int[30];
        int zeroCnt = 0;
        List<Integer> list = new ArrayList<>();

        for (int i=0;i<30;i++) {
            for (int val: a) {
                if (val == 0)
                    zeroCnt++;

                bitFreq[i] += ((val >> i) & 1);
            }
        }

//        System.out.println(Arrays.toString(bitFreq));

        for (int val: bitFreq)
            if (val != 0)
                list.add(val);

        StringJoiner sj = new StringJoiner(" ");
        if (list.size() == 0) {
            for (int i=1;i<=n;i++)
                sj.add(Integer.toString(i));

            sb.append(sj);
            return;
        }

        int hcf = 0;
        if (list.size() == 1) {
            hcf = list.get(0);
        } else {
            hcf = getGCD(list.get(0), list.get(1));
            for (int i=2;i<list.size();i++)
                hcf = getGCD(hcf, list.get(i));
        }

        // multiples of hcf
        Set<Integer> set = new TreeSet<>();
        for (int i=1;(long)i*i<=(long)hcf;i++) {
            if (hcf % i == 0) {
                int factor1= i;
                int factor2 = hcf/i;

                set.add(factor1);
                set.add(factor2);
            }
        }

        for (int val: set)
            sj.add(Integer.toString(val));

        sb.append(sj);
    }

    private int getGCD(int a,int b) {
        if (b == 0)
            return a;

        return getGCD(b, a%b);
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