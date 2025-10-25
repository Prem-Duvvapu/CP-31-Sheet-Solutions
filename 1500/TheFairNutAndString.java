import java.io.*;
import java.util.*;

public class TheFairNutAndString {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

//        int t=fr.nextInt();
        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            String s = fr.next();

            //make call to execute the logic
            solution.solve(s);

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
    public void solve(String s) {
        List<Integer> list = new ArrayList<>();

        int cnt = 0;
        for (char ch: s.toCharArray()) {
            if (ch == 'a') {
                cnt++;
            } else if (ch == 'b' && cnt > 0) {
                list.add(cnt);
                cnt = 0;
            }
        }

        if (cnt > 0)
            list.add(cnt);

        if (list.size() == 0) {
            sb.append(0);
        } else if (list.size() == 1) {
            sb.append(list.get(0));
        } else {
            long res = 1;
            for (int val: list)
                res = (res * (val+1))%LONG_MOD;
            sb.append(res - 1);
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