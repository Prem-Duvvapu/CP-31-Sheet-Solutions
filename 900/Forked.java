import java.io.*;
import java.util.*;

public class Forked {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int a=fr.nextInt();
            int b=fr.nextInt();
            int xK=fr.nextInt();
            int yK=fr.nextInt();
            int xQ=fr.nextInt();
            int yQ=fr.nextInt();

            //make call to execute the logic
            solution.solve(a,b,xK,yK,xQ,yQ);

            //new line after test case ans
            solution.sb.append("\n");
        }

        out.println(solution.sb);

        out.close();
    }
}

class Solution {
    public static final int MOD=1_000_000_007;
    public StringBuilder sb=new StringBuilder();

    //write logic here and print the result
    public void solve(int a,int b,int xK,int yK,int xQ,int yQ) {
        int cnt=0;
        Set<String> set=new HashSet<>();

        int[] x1Arr=new int[2];
        int[] y1Arr=new int[2];
        x1Arr[0]=a;
        x1Arr[1]=-1*a;
        y1Arr[0]=b;
        y1Arr[1]=-1*b;

        int[] x2Arr=new int[2];
        int[] y2Arr=new int[2];
        x2Arr[0]=b;
        x2Arr[1]=-1*b;
        y2Arr[0]=a;
        y2Arr[1]=-1*a;

        for (int i=0;i<2;i++) {
            for (int j=0;j<2;j++) {
                int xP=xK+x1Arr[i];
                int yP=yK+y1Arr[j];

                for (int u=0;u<2;u++) {
                    for (int v=0;v<2;v++) {
                        if (xP+x1Arr[u]==xQ && yP+y1Arr[v]==yQ)
                            set.add(xP+"-"+yP);
                    }
                }

                for (int u=0;u<2;u++) {
                    for (int v=0;v<2;v++) {
                        if (xP+x2Arr[u]==xQ && yP+y2Arr[v]==yQ)
                            set.add(xP+"-"+yP);
                    }
                }
            }
        }

        for (int i=0;i<2;i++) {
            for (int j=0;j<2;j++) {
                int xP=xK+x2Arr[i];
                int yP=yK+y2Arr[j];

                for (int u=0;u<2;u++) {
                    for (int v=0;v<2;v++) {
                        if (xP+x1Arr[u]==xQ && yP+y1Arr[v]==yQ)
                            set.add(xP+"-"+yP);
                    }
                }

                for (int u=0;u<2;u++) {
                    for (int v=0;v<2;v++) {
                        if (xP+x2Arr[u]==xQ && yP+y2Arr[v]==yQ)
                            set.add(xP+"-"+yP);
                    }
                }
            }
        }

        sb.append(set.size());
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