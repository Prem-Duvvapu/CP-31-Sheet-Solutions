import java.io.*;
import java.util.*;

public class CoverInWater {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n=fr.nextInt();
            String s=fr.next();

            //make call to execute the logic
            solution.solve(s,n,out);
        }

        out.close();
    }
}

class Solution {
    //write logic here and print the result
    public void solve(String s,int n,PrintWriter out) {
        char[] a=s.toCharArray();
        int maxConsecutiveEmpytCnt=0;
        int totalEmptyCnt=0;
        int currConsecutiveEmptyCnt=0;

        for (int i=0;i<n;i++) {
            if (a[i]=='.') {
                currConsecutiveEmptyCnt++;
            } else {
                maxConsecutiveEmpytCnt=Math.max( maxConsecutiveEmpytCnt,currConsecutiveEmptyCnt);
                totalEmptyCnt+=currConsecutiveEmptyCnt;
                currConsecutiveEmptyCnt=0;
            }
        }

        maxConsecutiveEmpytCnt=Math.max( maxConsecutiveEmpytCnt,currConsecutiveEmptyCnt);
        totalEmptyCnt+=currConsecutiveEmptyCnt;

        if (maxConsecutiveEmpytCnt>=3)
            out.println(2);
        else
            out.println(totalEmptyCnt);
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