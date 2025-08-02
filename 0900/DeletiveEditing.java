import java.io.*;
import java.util.*;

public class DeletiveEditing {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            String s=fr.next();
            String t1=fr.next();

            //make call to execute the logic
            solution.solve(s,t1);

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
    public void solve(String s,String t) {
        List<Integer>[] list=new ArrayList[26];

        for (int i=0;i<26;i++)
            list[i]=new ArrayList<>();

        for (int i=0;i<s.length();i++) {
            int index=s.charAt(i)-'A';
            list[index].add(i);
        }

        int[] tFreq=new int[26];
        for (char ch: t.toCharArray())
            tFreq[ch-'A']++;

//        System.out.println(Arrays.toString(list));
//        System.out.println(Arrays.toString(tFreq));

        int prevIndex=t.charAt(0)-'A';
        int prevFreqListSize=list[prevIndex].size();
        if (prevFreqListSize < tFreq[prevIndex]) {
            sb.append("No");
            return;
        }

        int prevFreqListPos=list[prevIndex].get(prevFreqListSize-tFreq[prevIndex]);
        tFreq[prevIndex]--;

        for (int i=1;i<t.length();i++) {
            int currIndex=t.charAt(i)-'A';
            int currFreqListSize=list[currIndex].size();

            if (currFreqListSize < tFreq[currIndex]) {
                sb.append("No");
                return;
            }

            int currFreqListPos=list[currIndex].get(currFreqListSize-tFreq[currIndex]);

            if (currFreqListPos<=prevFreqListPos) {
                sb.append("No");
                return;
            }

            prevFreqListPos=currFreqListPos;
            tFreq[currIndex]--;
        }

        sb.append("Yes");
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