import java.io.*;
import java.util.*;

public class ShoeShuffling {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n=fr.nextInt();
            int[] s=new int[n];

            for (int i=0;i<n;i++)
                s[i]=fr.nextInt();

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
    public void solve(int n,int[] s) {
        List<Integer> list=new ArrayList<>();
        int prev=-1;
        int cnt=0;

        for (int val: s) {
            if (val==prev) {
                cnt++;
            } else {
                list.add(cnt);
                prev=val;
                cnt=1;
            }
        }
        list.add(cnt);

        StringJoiner sj=new StringJoiner(" ");
        int currIndex=1;

        for (int val: list) {
            if (val==0)
                continue;

            if (val==1) {
                sb.append(-1);
                return;
            }

            int temp=currIndex+1;
            for (int i=temp;i<currIndex+val;i++)
                sj.add(Integer.toString(i));
            sj.add(Integer.toString(currIndex));

            currIndex+=val;
        }

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