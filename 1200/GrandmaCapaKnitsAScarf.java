import java.io.*;
import java.util.*;

public class GrandmaCapaKnitsAScarf {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            String s = fr.next();

            //make call to execute the logic
            solution.solve(n,s);

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
    public void solve(int n, String s) {
        int res = Integer.MAX_VALUE;
        int i = 0;
        int j = n-1;

        while (i<j) {
            if (s.charAt(i) != s.charAt(j))
                break;

            i++;
            j--;
        }

        if (i==j) {
            sb.append(0);
            return;
        }

        //remove s.charAt(i)
        int p1 = i;
        int p2 = j;
        char ch = s.charAt(i);
        int cnt  = 0;


        while (p1 < p2) {
            if (s.charAt(p1) != s.charAt(p2)) {
                if (s.charAt(p1) == ch) {
                    p1++;
                    cnt++;
                } else if (s.charAt(p2) == ch) {
                    p2--;
                    cnt++;
                } else
                    break;
            } else {
                p1++;
                p2--;
            }
        }

        if (p1 >= p2) {
            res = Math.min(res, cnt);
        }


        //remove s.charAt(j)
        p1 = i;
        p2 = j;
        ch = s.charAt(j);
        cnt  = 0;


        while (p1 < p2) {
            if (s.charAt(p1) != s.charAt(p2)) {
                if (s.charAt(p1) == ch) {
                    p1++;
                    cnt++;
                } else if (s.charAt(p2) == ch) {
                    p2--;
                    cnt++;
                } else
                    break;
            } else {
                p1++;
                p2--;
            }
        }

        if (p1 >= p2) {
            res = Math.min(res, cnt);
        }

        if (res == Integer.MAX_VALUE)
            sb.append(-1);
        else
            sb.append(res);
    }

    private boolean isPalindrome(StringBuilder curr) {
        int m = curr.length();

        int i = 0;
        int j = m-1;

        while (i<j) {
            if (curr.charAt(i) != curr.charAt(j))
                return  false;

            i++;
            j--;
        }

        return  true;
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