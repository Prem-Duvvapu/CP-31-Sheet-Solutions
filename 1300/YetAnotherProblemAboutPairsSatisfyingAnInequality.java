import java.io.*;
import java.util.*;

public class YetAnotherProblemAboutPairsSatisfyingAnInequality {
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
        long res = 0;
        List<Integer> list = new ArrayList<>();

        for (int i=0;i<n;i++)
            if (a[i] < (i+1))
                list.add(i+1);

        for (int i=1;i<n;i++) {
            if (a[i] < (i+1)) {
                int up = getUpperBound(list,a[i]-1);
                res += up;
            }
        }

        sb.append(res);
    }

    private int getUpperBound(List<Integer> list, int val) {
        int resIndex = list.size();
        int low = 0;
        int high = list.size()-1;

        while (low <= high) {
            int mid = low+(high-low)/2;

            if (list.get(mid) > val) {
                resIndex = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return resIndex;
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