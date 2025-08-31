import java.io.*;
import java.util.*;

public class AnnaAndTheValentinesDayGift {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
//        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int m = fr.nextInt();
            int[] a = new int[n];

            for (int i=0;i<n;i++)
                a[i] = fr.nextInt();

            //make call to execute the logic
            solution.solve(n,m,a);

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
    public void solve(int n,int m,int[] a) {
        int totalZeroCnt = 0;
        List<Integer> zeroCnt = new ArrayList<>();

        for (int val: a) {
            totalZeroCnt += Integer.toString(val).length();
            zeroCnt.add(getZeroCnt(val));
        }

        Collections.sort(zeroCnt);
        for (int i=n-1;i>=0;i-=2) {
            totalZeroCnt -= zeroCnt.get(i);
        }

        if (totalZeroCnt >= (m+1))
            sb.append("Sasha");
        else
            sb.append("Anna");
    }

    private Integer getZeroCnt(int val) {
        int cnt = 0;
        while (val%10 == 0) {
            cnt++;
            val/=10;
        }

        return cnt;
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