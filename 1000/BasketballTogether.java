import java.io.*;
import java.util.*;

public class BasketballTogether {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

//        int t=fr.nextInt();
         int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n=fr.nextInt();
            int d=fr.nextInt();
            int[] p=new int[n];

            for (int i=0;i<n;i++)
                p[i]=fr.nextInt();

            //make call to execute the logic
            solution.solve(n,d,p);

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
    public void solve(int n,int d,int[] p) {
        Arrays.sort(p);
        int cnt=0;
        int low=0;
        int high=n-1;

        while (low<=high) {
            int req=d/p[high]+1;

            if (req==1)
                low--;
            else if (low!=high)
                low=low+(req-2);
            else
                low=low+(req-1);

            if (low<high)
                cnt++;

            low++;
            high--;
        }

        sb.append(cnt);
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