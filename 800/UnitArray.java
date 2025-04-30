import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UnitArray {
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
        int posOneCnt=0;
        int negOneCnt=0;

        for (int val: a)
            if (val==1)
                posOneCnt++;
        
        negOneCnt=n-posOneCnt;

        if (posOneCnt>=negOneCnt && (negOneCnt&1)==0) {
            out.println(0);
            return;
        }

        int res=0;
        if (posOneCnt<negOneCnt) {
            int diff=(negOneCnt-posOneCnt);
            res=diff/2+diff%2;
            posOneCnt+=res;
            negOneCnt-=res;
        }

        if ((negOneCnt&1)==1) {
            res+=1;
            posOneCnt++;
            negOneCnt--;
        }

        out.println(res);
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