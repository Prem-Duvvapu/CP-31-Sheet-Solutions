import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ArrayGame {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
//        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int k = fr.nextInt();
            long[] a = new long[n];

            for (int i=0;i<n;i++)
                a[i] = fr.nextLong();

            //make call to execute the logic
            solution.solve(n,k,a);

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
    public void solve(int n,int k,long[] a) {
        if (k >= 3) {
            sb.append(0);
            return;
        }

        List<Long> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        Collections.sort(list);

        long res = list.get(0);
        long minDiff = Long.MAX_VALUE;
        for (int i=1;i<list.size();i++)
            minDiff = Math.min(minDiff, list.get(i) - list.get(i-1));

        res = Math.min(res, minDiff);

        // if k = 1
        if (k == 1) {
            sb.append(res);
            return;
        }

        // if k=2
        TreeSet<Long> set = new TreeSet<>(list);

        for (int i=0;i<n;i++) {
            for (int j=i+1;j<n;j++) {
                long diff = list.get(j) - list.get(i);

               if (set.ceiling(diff) != null)
                   res = Math.min(res, set.ceiling(diff) - diff);

                if (set.floor(diff) != null)
                    res = Math.min(res, diff - set.floor(diff) );
            }
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