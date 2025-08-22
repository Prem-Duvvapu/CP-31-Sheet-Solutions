import java.io.*;
import java.util.*;

public class DeepDownBelow {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int[][] arr = new int[n][];

            for (int i=0;i<n;i++) {
                int k = fr.nextInt();
                arr[i] = new int[k];

                for (int j=0;j<k;j++) {
                    arr[i][j] = fr.nextInt();
                }
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
        int[][] minPowerReq = new int[n][2];
        int res = 0;

        for (int i=0;i<n;i++) {
            int k = arr[i].length;
            minPowerReq[i][0] = i;
            minPowerReq[i][1] = arr[i][0]+1;
            int currPower = arr[i][0] + 1;

            for (int j=0;j<k;j++) {
                int minReq = arr[i][j] + 1;
                int diff = minReq - currPower;

                if (diff > 0) {
                    minPowerReq[i][1] += diff;
                    currPower = minReq;
                }

                currPower += 1;
            }
        }

        Arrays.sort(minPowerReq, (x,y) -> Integer.compare(x[1],y[1]));

        res = minPowerReq[0][1];
        int currPower = minPowerReq[0][1] + arr[minPowerReq[0][0]].length;

        for (int i=1;i<n;i++) {
            int diff = minPowerReq[i][1] - currPower;

            if (diff > 0) {
                res += diff;
                currPower = minPowerReq[i][1];
            }

            currPower += arr[minPowerReq[i][0]].length;
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