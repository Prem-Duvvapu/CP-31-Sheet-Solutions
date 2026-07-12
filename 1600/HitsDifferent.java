import java.io.*;
import java.util.*;

public class HitsDifferent {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
//        int t=1;

        Solution solution=new Solution();

        List<List<Long>> lists = new ArrayList<>();
        int maxVal = (int)1e6;
        long[] res = new long[maxVal+1];
        PreComputation(lists,res,maxVal);

//        System.out.println(lists);
//        System.out.println(Arrays.toString(res));

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();

            //make call to execute the logic
            solution.solve(res,n);

            //new line after test case ans
            solution.sb.append("\n");
        }

        out.println(solution.sb);

        out.close();
    }

    private static void PreComputation(List<List<Long>> lists,long[] res, int maxN) {
        int maxRows = maxRows(maxN)+1;
        for (int i=0;i<maxRows;i++) {
            lists.add(new ArrayList<>());
        }

        int currVal = 1;
        for (int i=0;i<maxRows;i++) {
            int x = i;
            int y = 0;

            while (x>=0 && currVal<=maxN) {
                long currRes = (long)currVal * currVal;
                if (x > 0) {
                    currRes += lists.get(x-1).get(y);
                }

                if (y > 0) {
                    currRes += lists.get(x).get(y-1);
                }

                if (x > 0 && y > 0) {
                    currRes -= lists.get(x-1).get(y-1);
                }

                res[currVal] = currRes;

                List<Long> currList = lists.get(x);
                currList.add(currRes);
                x--;
                y++;

                currVal++;
            }
        }
    }

    private static int maxRows(int n) {
        long lo = 1, hi = (long) 1e6, ans = 0;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long sum = mid * (mid + 1) / 2; // watch overflow if n is huge, use BigInteger if needed
            if (sum <= n) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return (int)ans;
    }
}

class Solution {
    public static final int INT_MOD=1_000_000_007;
    public static final long LONG_MOD=1_000_000_007L;

    public StringBuilder sb=new StringBuilder();

    //write logic here and print the result
    public void solve(long[] res,int n) {
        sb.append(res[n]);
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