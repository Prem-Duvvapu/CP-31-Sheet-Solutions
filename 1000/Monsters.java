import java.io.*;
import java.util.*;

public class Monsters {
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
            int[] a=new int[n];

            for (int i=0;i<n;i++)
                a[i]=fr.nextInt();

            //make call to execute the logic
            solution.solve(a,n,k);

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
    public void solve(int[] a,int n,int k) {
        List<Integer> res=new ArrayList<>();
        PriorityQueue<Integer> maxHeap;

        Comparator<Integer> com=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (a[o2]%k>a[o1]%k)
                    return 1;
                else if (a[o1]%k==a[o2]%k)
                    return (o1-o2);

                return -1;
            }
        };

        maxHeap=new PriorityQueue<>(com);

        for (int i=0;i<n;i++) {
            if (a[i] % k == 0)
                res.add(i+1);
            else
                maxHeap.add(i);
        }

        while (!maxHeap.isEmpty())
            res.add(maxHeap.poll()+1);

        StringJoiner sj=new StringJoiner(" ");
        for (int i: res)
            sj.add(Integer.toString(i));

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