import java.io.*;
import java.util.*;

public class Virus {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int m = fr.nextInt();
            int[] a = new int[m];

            for (int i=0;i<m;i++)
                a[i] = fr.nextInt();

            //make call to execute the logic
            solution.solve(n,m,a);

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
    public void solve(int n,int m,int[] a) {
        Arrays.sort(a);
        int uninfected = 0;
        List<Integer> diff = new ArrayList<>();

        for (int i=0;i<m-1;i++) {
            diff.add(a[i+1]-a[i]-1);
        }

        diff.add(a[0]-1+n-a[m-1]);
        Collections.sort(diff);
        Collections.reverse(diff);

        int currDays  = 0;
        for (int i=0;i<diff.size();i++) {
            if (diff.get(i)<=2*currDays)
                break;

            int currUninfected = diff.get(i) - 2*currDays;
            if (currUninfected==1)
                uninfected+=1;
            else
                uninfected+=(currUninfected-1);

            currDays+=2;
        }

        sb.append(n-uninfected);
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