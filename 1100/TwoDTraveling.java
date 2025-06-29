import java.io.*;
import java.util.*;

public class TwoDTraveling {
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
            int a=fr.nextInt();
            int b=fr.nextInt();
            Coordinate[] coordinates=new Coordinate[n];

            for (int i=0;i<n;i++) {
                long x=fr.nextInt();
                long y=fr.nextInt();
                coordinates[i]=new Coordinate(x,y);
            }

            //make call to execute the logic
            solution.solve(n,k,a,b,coordinates);

            //new line after test case ans
            solution.sb.append("\n");
        }

        out.println(solution.sb);

        out.close();
    }
}

class Coordinate {
    long x;
    long y;

    Coordinate(long x,long y) {
        this.x=x;
        this.y=y;
    }
}

class Solution {
    public static final int INT_MOD=1_000_000_007;
    public static final long LONG_MOD=1_000_000_007L;

    public StringBuilder sb=new StringBuilder();

    //write logic here and print the result
    public void solve(int n,int k,int a,int b,Coordinate[] coordinates) {
        long minDist=Math.abs(coordinates[a-1].x - coordinates[b-1].x)+Math.abs(coordinates[a-1].y - coordinates[b-1].y);

        long aToMajor=Long.MAX_VALUE/2;
        long majorTob=Long.MAX_VALUE/2;

        for (int i=0;i<k;i++) {
            long currFromA=0;
            long currToB=0;

            if (a>=k)
                currFromA=Math.abs(coordinates[a-1].x - coordinates[i].x)+Math.abs(coordinates[a-1].y - coordinates[i].y);
            aToMajor=Math.min(aToMajor,currFromA);


            if (b>=k)
                currToB=Math.abs(coordinates[b-1].x - coordinates[i].x)+Math.abs(coordinates[b-1].y - coordinates[i].y);
            majorTob=Math.min(majorTob,currToB);
        }

        minDist=Math.min(minDist, aToMajor+majorTob);
        sb.append(minDist);
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