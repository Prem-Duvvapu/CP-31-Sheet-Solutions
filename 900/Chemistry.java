import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Chemistry {
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
            String s=fr.nextLine();

            //make call to execute the logic
            solution.solve(s,k,n);

            //new line after test case ans
            solution.sb.append("\n");
        }

        out.println(solution.sb);

        out.close();
    }
}

class Solution {
    public static final int MOD=1_000_000_007;
    public StringBuilder sb=new StringBuilder();

    //write logic here and print the result
    public void solve(String s,int k,int n) {
        int[] freq=new int[26];
        for (char ch: s.toCharArray())
            freq[ch-'a']++;

        int oddFreqCnt=0;

        for (int i=0;i<26;i++)
            if ((freq[i]&1)==1)
                oddFreqCnt++;

        if (k>=(oddFreqCnt-1))
            sb.append("Yes");
        else
            sb.append("No");
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