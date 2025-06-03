import java.io.*;
import java.util.*;

public class ArrayMerging {
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
            int[] b=new int[n];

            for (int i=0;i<n;i++)
                a[i]=fr.nextInt();

            for (int i=0;i<n;i++)
                b[i]=fr.nextInt();

            //make call to execute the logic
            solution.solve(n,a,b);

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
    public void solve(int n,int[] a,int[] b) {
        int res=1;
        Map<Integer,Integer> map1=new HashMap<>();
        Map<Integer,Integer> map2=new HashMap<>();
        int prev=-1;
        int consecutive=0;

        for (int val: a) {
            if (val==prev)
                consecutive++;
            else  {
                if (consecutive>map1.getOrDefault(prev,0))
                    map1.put(prev,consecutive);
                consecutive=1;
                prev=val;
            }
        }

        if (consecutive>map1.getOrDefault(prev,0))
            map1.put(prev,consecutive);

        prev=-1;
        consecutive=0;

        for (int val: b) {
            if (val==prev)
                consecutive++;
            else  {
                if (consecutive>map2.getOrDefault(prev,0))
                    map2.put(prev,consecutive);
                consecutive=1;
                prev=val;
            }
        }

        if (consecutive>map2.getOrDefault(prev,0))
            map2.put(prev,consecutive);

        for (Map.Entry<Integer,Integer> m: map1.entrySet())
            res=Math.max(res,m.getValue()+map2.getOrDefault(m.getKey(),0));

        for (int val: map2.values())
            res=Math.max(res,val);

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