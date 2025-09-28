import java.io.*;
import java.util.*;

public class TwoTVs {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

//        int t=fr.nextInt();
        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int[][] arr = new int[n][2];

            for (int i=0;i<n;i++) {
                arr[i][0] = fr.nextInt();
                arr[i][1] = fr.nextInt();
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
        Comparator<int[]> com = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                    return Integer.compare(o1[0], o2[0]);

                return Integer.compare(o1[1],o2[1]);
            }
        };

        Arrays.sort(arr, com);
        int end1 = -1;
        int end2 = -1;

        for (int i=0;i<n;i++) {
            int start = arr[i][0];
            int end = arr[i][1];

            if (start > end1) {
                end1 = end;
            } else if (start > end2) {
                end2 = end;
            } else {
                sb.append("NO");
                return;
            }
        }

        sb.append("YES");
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