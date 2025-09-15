import java.io.*;
import java.util.*;

public class BerlandRegional {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
//        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int[] u = new int[n];
            int[] s = new int[n];

            for (int i=0;i<n;i++)
                u[i] = fr.nextInt();

            for (int i=0;i<n;i++)
                s[i] = fr.nextInt();

            //make call to execute the logic
            solution.solve(n,u,s);

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
    public void solve(int n,int[] u,int[] s) {
        Map<Integer,List<Integer>> map = new HashMap<>();

        for (int i=0;i<n;i++) {
            map.putIfAbsent(u[i],new ArrayList<>());
            map.get(u[i]).add(s[i]);
        }

        List<long[][]> list = new ArrayList<>();
        for (Map.Entry<Integer,List<Integer>> m: map.entrySet()) {
            long[][] arr = new long[2][m.getValue().size()];
            List<Integer> currList = m.getValue();
            Collections.sort(currList);
            Collections.reverse(currList);

            for (int i=0;i<currList.size();i++) {
                arr[0][i] = currList.get(i);
                if (i == 0)
                    arr[1][i] = arr[0][i];
                else
                    arr[1][i] = arr[0][i] + arr[1][i-1];
            }

            list.add(arr);
        }

        Collections.sort(list,(x,y) -> Integer.compare(x[0].length,y[0].length));
        int pos = 0;
        long[] res = new long[n];

        for (int k=1;k<=n;k++) {
            while (pos < list.size() && list.get(pos)[0].length < k)
                pos++;

            long currSum = 0;
            for (int j=pos;j<list.size();j++) {
                int rem = list.get(j)[0].length % k;
                currSum += list.get(j)[1][list.get(j)[0].length - 1 - rem];
            }

            res[k-1] = currSum;
        }

        StringJoiner sj = new StringJoiner(" ");
        for (long val: res)
            sj.add(Long.toString(val));

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