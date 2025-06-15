import java.io.*;
import java.util.*;

public class DivanAndANewProject {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n=fr.nextInt();
            int[] a=new int[n+1];

            for (int i=1;i<a.length;i++)
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
        int[] res=new int[n+1];
        PriorityQueue<Integer> indexMaxHeap=new PriorityQueue<>((x,y) -> Integer.compare(a[y],a[x]));

        for (int i=1;i<a.length;i++)
            indexMaxHeap.add(i);

        int right=1;
        int left=-1;
        boolean isRight=true;
        long totalTime=0;

        while (!indexMaxHeap.isEmpty()) {
            int currIndex=indexMaxHeap.poll();

            if (isRight) {
                totalTime+=(2*right*(long)a[currIndex]);
                res[currIndex]=right;
                right++;
            } else {
                totalTime+=(2*Math.abs(left)*(long)a[currIndex]);
                res[currIndex]=left;
                left--;
            }

            isRight=!isRight;
        }

        StringJoiner sj=new StringJoiner(" ");
        for (int val: res)
            sj.add(Integer.toString(val));

        sb.append(totalTime).append("\n");
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