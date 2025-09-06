import java.io.*;
import java.util.*;

public class ScheduleManagement {
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
            int[] a = new int[m];

            for (int i=0;i<m;i++)
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
        int[] freq = new int[n+1];

        for (int val: a)
            freq[val]++;

        Arrays.sort(freq);
        reverse(freq);

        int low = 1;
        int high = 2*m;
        int res = high;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (isPossible(mid,freq,n,m)) {
                res = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        sb.append(res);
    }

    private boolean isPossible(int mid, int[] freq, int n, int m) {
        int pendingTaskCnt = 0;

        for (int i=0;i<n;i++) {
            if (freq[i] > mid) {
                pendingTaskCnt += (freq[i] - mid);
            } else if (freq[i] < mid && pendingTaskCnt > 0) {
                int diff = (mid - freq[i]);
                int q = diff/2;
                pendingTaskCnt = Math.max(pendingTaskCnt-q, 0);
            }
        }

        return (pendingTaskCnt == 0);
    }

    public void reverse(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;

            low++;
            high--;
        }
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