import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ForbiddenInteger {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n=fr.nextInt();
            int k=fr.nextInt();
            int x=fr.nextInt();

            //make call to execute the logic
            solution.solve(n,k,x,out);
        }

        out.close();
    }
}

class Solution {
    //write logic here and print the result
    public void solve(int n,int k,int x,PrintWriter out) {
        StringBuilder res=new StringBuilder();
        if (x!=1) {
            res.append("YES").append("\n").append(n).append("\n");
            for (int i=0;i<n;i++)
                res.append(1).append(" ");
        } else if (k==1) {
            res.append("NO");
        } else if (n%2==0) {
            res.append("YES").append("\n").append(n/2).append("\n");
            for (int i=0;i<n/2;i++)
                res.append(2).append(" ");
        } else {
            if (k==2) { 
                res.append("NO");
            } else {
                res.append("YES").append("\n").append(n/2).append("\n");
                for (int i=0;i<n/2-1;i++)
                    res.append(2).append(" ");
                res.append(3);
            }
        }
        
        out.println(res);
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