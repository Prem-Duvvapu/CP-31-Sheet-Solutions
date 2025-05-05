import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class OneAndTwo {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n=fr.nextInt();
            int[] a=new int[n];

            for (int i=0;i<n;i++)
                a[i]=fr.nextInt();

            //make call to execute the logic
            solution.solve(a,n);

            //new line after test case ans
            solution.res.append("\n");
        }

        out.println(solution.res);

        out.close();
    }
}

class Solution {
    public static final int MOD=1_000_000_007;
    public StringBuilder res=new StringBuilder();

    //write logic here and print the result
    public void solve(int[] a,int n) {
        int[] suffixTwoFreq=new int[n];
        int currTwoFreq=0;

        for (int i=n-1;i>=0;i--) {
            if (a[i]==2)
                currTwoFreq++;

            suffixTwoFreq[i]=currTwoFreq;
        }

        int prefixTwoFreq=0;
        for (int i=0;i<n-1;i++) {
            if (a[i]==2)
                prefixTwoFreq++;

            if (prefixTwoFreq==suffixTwoFreq[i+1]) {
                res.append(i+1);
                return;
            }
        }
        
        res.append(-1);
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