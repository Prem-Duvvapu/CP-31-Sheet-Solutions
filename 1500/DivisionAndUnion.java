import java.io.*;
import java.util.*;

public class DivisionAndUnion {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
//        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int[][] arr = new int[n][3];

            for (int i=0;i<n;i++) {
                arr[i][0] = fr.nextInt();
                arr[i][1] = fr.nextInt();
                arr[i][2] = i;
            }

            //make call to execute the logic
            solution.solve(n,arr);

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
    public void solve(int n,int[][] arr) {
        int[] res = new int[n];
        int[][] merged = merge(arr,res);

        if (merged.length == 1) {
            sb.append(-1);
            return;
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int val: res)
            sj.add(String.valueOf(val));

        sb.append(sj);
    }

    private int[][] merge(int[][] intervals,int[] res) {
        int n=intervals.length;
        List<int[]> merged=new ArrayList<>();

        Comparator<int[]> com=new Comparator<>() {
            public int compare(int[] x,int[] y) {
                if (x[0]!=y[0])
                    return Integer.compare(x[0],y[0]);

                return Integer.compare(x[1],y[1]);
            }
        };

        Arrays.sort(intervals, com);

        int start=intervals[0][0];
        int end=intervals[0][1];
        res[intervals[0][2]] = 1;

        for (int i=1;i<n;i++) {
            if (intervals[i][0]<=end) {
                end=Math.max(end,intervals[i][1]);
                res[intervals[i][2]] = res[intervals[i-1][2]];
            } else {
                merged.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
                if (res[intervals[i-1][2]] == 1)
                    res[intervals[i][2]] = 2;
                else
                    res[intervals[i][2]] = 1;
            }
        }
        merged.add(new int[]{start,end});

        return merged.toArray(new int[merged.size()][2]);
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