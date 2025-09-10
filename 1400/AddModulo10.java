import java.io.*;
import java.util.*;

public class AddModulo10 {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
//        int t=1;

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
        int zeroFiveCnt = 0;
        int x = -1;
        int y = -1;
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,4,8));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3,6,7,9));

        for (int val: a) {
            if (val%10 == 0 || val%5 == 0)
                zeroFiveCnt++;
        }

        if (zeroFiveCnt == n) {
            int prev = a[0];
            if (prev%10 == 5)
                prev += 5;

            for (int i=1;i<n;i++) {
                if (a[i]%10 == 0) {
                    if (a[i] != prev) {
                        sb.append("NO");
                        return;
                    }
                } else {
                    if (a[i]+5 != prev) {
                        sb.append("NO");
                        return;
                    }
                }
            }
            sb.append("YES");
            return;
        } else if (zeroFiveCnt > 0) {
            sb.append("NO");
            return;
        }

        for (int val: a) {
            int q = val/10;
            int rem = val%10;
            if (set1.contains(rem)) {
                if (x == -1)
                    x = (q&1);
                else if (x != (q&1)) {
                    sb.append("NO");
                    return;
                }
            } else {
                if (y == -1)
                    y = (q&1);
                else if (y != (q&1)) {
                    sb.append("NO");
                    return;
                }
            }
        }

        if (x == -1 || y == -1) {
            sb.append("YES");
        } else if (x+y == 1) {
            sb.append("YES");
        } else {
            sb.append("NO");
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