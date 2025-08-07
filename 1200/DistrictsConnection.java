import java.io.*;
import java.util.*;

public class DistrictsConnection {
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

class Pair {
    int gangNum;
    Stack<Integer> districts;

    Pair(int gangNum) {
        this.gangNum = gangNum;
        districts = new Stack<>();
    }
}

class Solution {
    public static final int INT_MOD=1_000_000_007;
    public static final long LONG_MOD=1_000_000_007L;

    public StringBuilder sb=new StringBuilder();

    //write logic here and print the result
    public void solve(int n, int[] a) {
        int firstDistrict = 0;
        int secondDistrict = -1;

        for (int i=1;i<n;i++) {
            if (a[i] != a[firstDistrict]) {
                secondDistrict = i;
                break;
            }
        }

        if (secondDistrict == -1) {
            sb.append("NO");
            return;
        }

        StringJoiner sj = new StringJoiner("\n");

        for (int i=1;i<n;i++) {
            if (a[i] != a[firstDistrict])
                sj.add((firstDistrict+1)+" "+(i+1));
        }

        for (int i=1;i<n;i++) {
            if (a[i] == a[firstDistrict])
                sj.add((secondDistrict+1)+" "+(i+1));
        }

        sb.append("YES").append("\n");
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