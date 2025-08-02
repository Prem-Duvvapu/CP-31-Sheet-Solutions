import java.io.*;
import java.util.*;

public class DoremysPaint3 {
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
            solution.solve(a,n,out);
        }

        out.close();
    }
}

class Solution {
    //write logic here and print the result
    public void solve(int[] a,int n,PrintWriter out) {
        Map<Integer,Integer> map=new HashMap<>();

        for (int i=0;i<n;i++) {
            map.put(a[i],map.getOrDefault(a[i],0)+1);
            if (map.size()>2) {
                out.println("NO");
                return;
            }
        }

        if (map.size()==1) {
            out.println("YES");
            return;
        }

        int[] freq=new int[2];
        int pos=0;

        for (int e: map.values())
            freq[pos++]=e;

        if (n%2==0) {
            if (freq[0]==freq[1])
                out.println("YES");
            else
                out.println("NO");
        } else {
            if (Math.abs(freq[0]-freq[1])==1)
                out.println("YES");
            else
                out.println("NO");
        }
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