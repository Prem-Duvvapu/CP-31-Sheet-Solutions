import java.io.*;
import java.util.*;

public class WowFactor {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

//        int t=fr.nextInt();
        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            String s = fr.next();

            //make call to execute the logic
            solution.solve(s);

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
    public void solve(String s) {
        int n = s.length();
        int start = 0;
        int end = n-1;

        while (start < n && s.charAt(start)=='o')
            start++;

        while (end >= 0 && s.charAt(end)=='o')
            end--;

        if (start > end) {
            sb.append(0);
            return;
        }

        List<Integer> wCntList = new ArrayList<>();
        List<Integer> oCntList = new ArrayList<>();

        int vCnt = 0;
        int oCnt = 0;
        for (int i=start;i<=end;i++) {
            if (s.charAt(i)=='v') {
                if (i==end || s.charAt(i+1)=='o') {
                    oCntList.add(oCnt);
                    oCnt = 0;
                }

                vCnt++;
            } else {
                if (i==end || s.charAt(i+1)=='v') {
                    wCntList.add(vCnt - 1);
                    vCnt = 0;
                }
                oCnt++;
            }
        }

        if (vCnt == n) {
            sb.append(0);
            return;
        }

        wCntList.add(vCnt-1);
        oCntList.remove(0);

        int m = wCntList.size();
        long[] prefix = new long[m];
        long[] suffix = new long[m];

        prefix[0] = wCntList.get(0);
        suffix[m-1] = wCntList.get(m-1);

        for (int i=1;i<m;i++)
            prefix[i] = prefix[i-1]+wCntList.get(i);

        for (int i=m-2;i>=0;i--)
            suffix[i] = suffix[i+1]+wCntList.get(i);

//        System.out.println(wCntList);
//        System.out.println(oCntList);
//        System.out.println(Arrays.toString(suffix));
//        System.out.println(Arrays.toString(prefix));

        long res = 0;
        for (int i=0;i<m-1;i++) {
            res += (prefix[i]*oCntList.get(i)*suffix[i+1]);
        }

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