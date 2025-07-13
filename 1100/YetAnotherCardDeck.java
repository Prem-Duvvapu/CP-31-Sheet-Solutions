import java.io.*;
import java.util.*;

public class YetAnotherCardDeck {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

//        int t=fr.nextInt();
        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int q = fr.nextInt();
            int[] a = new int[n];
            int[] queries = new int[q];

            for (int i=0;i<n;i++)
                a[i] = fr.nextInt();

            for (int i=0;i<q;i++)
                queries[i] = fr.nextInt();

            //make call to execute the logic
            solution.solve(n,q,a,queries);

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
    public void solve(int n,int q,int[] a,int[] queries) {
        int[] position = new int[50+1];
        Arrays.fill(position, Integer.MAX_VALUE);

        for (int i=0;i<n;i++)
            if (position[a[i]]==Integer.MAX_VALUE)
                position[a[i]] = i+1;

        StringJoiner sj = new StringJoiner(" ");
        for (int query: queries) {
            int cardPos = position[query];
            sj.add(Integer.toString(cardPos));
            position[query] = 0;
            for (int i=1;i<=50;i++)
                if (position[i]<cardPos)
                    position[i]++;
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