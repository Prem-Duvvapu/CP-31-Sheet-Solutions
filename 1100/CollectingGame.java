import java.io.*;
import java.util.*;

public class CollectingGame {
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
            solution.solve(n,a);

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
    public void solve(int n,int[] a) {
        int[] res=new int[n];
        long[][] arr=new long[n][3];

        for (int i=0;i<n;i++) {
            arr[i][0]=a[i];
            arr[i][1]=i;
        }

        Arrays.sort(arr, (x,y) -> Long.compare(x[0],y[0]));
        arr[0][2]=arr[0][0];

        for (int i=1;i<n;i++)
            arr[i][2]=(arr[i-1][2]+arr[i][0]);

//        for (int i=0;i<n;i++)
//            System.out.println(arr[i][0]+" - "+arr[i][1]+" - "+arr[i][2]);

        int i=0;
        int j=0;
        long currSum=0;

        while (i<n) {
            j=Math.max(j-1,i);
            if (j<n)
                currSum=arr[j][2];

            while (j<n && arr[j][0]<=currSum) {
                currSum=arr[j][2];
                j++;
            }

//            System.out.println(i+" "+j+" "+currSum);
            res[(int)arr[i][1]]=j-1;
            i++;
        }

        StringJoiner sj=new StringJoiner(" ");
        for (int val: res)
            sj.add(Integer.toString(val));

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