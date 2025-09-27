import java.io.*;
import java.util.*;

public class K_CompleteWord {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
//        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int k = fr.nextInt();
            String s = fr.next();

            //make call to execute the logic
            solution.solve(n,k,s);

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
    public void solve(int n,int k,String s) {
        long res = 0;
        int q = n/k;
        int l = 0;
        int r = k-1-l;

        while (l <= r) {
            int[] freq = new int[26];

            // check each word
            for (int j=0;j<q;j++) {
                int start = j*k;
                char ch1 = s.charAt(start+l);
                char ch2 = s.charAt(start+r);
                freq[ch1-'a']++;
                freq[ch2-'a']++;
            }

            int total =  q*2;
            int maxFreq = Arrays.stream(freq).max().getAsInt();
            if (l==r) {
                total /= 2;
                maxFreq /= 2;
            }

            res += (total - maxFreq);

            l++;
            r--;
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