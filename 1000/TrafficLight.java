import java.io.*;
import java.util.*;

public class TrafficLight {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n=fr.nextInt();
            char c=fr.next().charAt(0);
            String s=fr.nextLine();

            //make call to execute the logic
            solution.solve(n,c,s);

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
    public void solve(int n,char c,String s) {
        int res=0;
        Stack<Integer> stack=new Stack<>();

        for (int i=0;i<n;i++) {
            char ch=s.charAt(i);
            if (ch==c)
                stack.push(i);

            if (ch=='g') {
                while (!stack.isEmpty()) {
                    res=Math.max(res,i-stack.pop());
                }
            }
        }

        if (stack.isEmpty()) {
            sb.append(res);
            return;
        }

        for (int i=0;i<n;i++) {
            char ch=s.charAt(i);

            if (ch=='g') {
                while (!stack.isEmpty()) {
                    res=Math.max(res,n+i-stack.pop());
                }
                break;
            }
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