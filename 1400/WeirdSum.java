import java.io.*;
import java.util.*;

public class WeirdSum {
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
            int[][] c = new int[n][m];

            for (int i=0;i<n;i++)
                for (int j=0;j<m;j++)
                    c[i][j] = fr.nextInt();

            //make call to execute the logic
            solution.solve(n,m,c);

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
    public void solve(int n,int m,int[][] c) {
        long res = 0;
        Map<Integer, List<Integer>> xMap = new HashMap<>();
        Map<Integer, List<Integer>> yMap = new HashMap<>();

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                xMap.putIfAbsent(c[i][j],new ArrayList<>());
                xMap.get(c[i][j]).add(i);
                yMap.putIfAbsent(c[i][j],new ArrayList<>());
                yMap.get(c[i][j]).add(j);
            }
        }

        for (List<Integer> list: xMap.values()) {
            Collections.sort(list);
            Collections.reverse(list);
            int k = list.size();
            long freq = (k-1);
            for (Integer integer : list) {
                res += (freq * integer);
                freq -= 2;
            }
        }

        for (List<Integer> list: yMap.values()) {
            Collections.sort(list);
            Collections.reverse(list);
            int k = list.size();
            long freq = (k-1);
            for (Integer integer : list) {
                res += (freq * integer);
                freq -= 2;
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