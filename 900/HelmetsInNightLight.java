import java.io.*;
import java.util.*;

public class HelmetsInNightLight {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n=fr.nextInt();
            int p=fr.nextInt();
            int[] a=new int[n];
            int[] b=new int[n];

            for (int i=0;i<n;i++)
                a[i]=fr.nextInt();

            for (int i=0;i<n;i++)
                b[i]=fr.nextInt();

            //make call to execute the logic
            solution.solve(a,b,n,p);

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
    public void solve(int[] a,int[] b,int n,int p) {
        int[][] arr=new int[n][2];
        long minCost=p;
        int residentsRemaining=n-1;

        for (int i=0;i<n;i++) {
            arr[i][0]=a[i];
            arr[i][1]=b[i];
        }

        Arrays.sort(arr, (x,y) -> Integer.compare(x[1],y[1]));

        int pos=0;
        while (pos<n && residentsRemaining>0) {
            int sharedResidentsCnt=Math.min(residentsRemaining,arr[pos][0]);
            int tempMinCost=Math.min(arr[pos][1],p);
            minCost+=((long)sharedResidentsCnt*tempMinCost);

            residentsRemaining-=sharedResidentsCnt;
            pos++;
        }

        sb.append(minCost);
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