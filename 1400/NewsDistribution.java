import java.io.*;
import java.util.*;

public class NewsDistribution {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

//        int t=fr.nextInt();
        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int m = fr.nextInt();
            int[][] arr = new int[m][];

            for (int i=0;i<m;i++) {
                arr[i] = new int[fr.nextInt()];

                for (int j=0;j<arr[i].length;j++)
                    arr[i][j] = fr.nextInt();
            }

            //make call to execute the logic
            solution.solve(n,m,arr);

            //new line after test case ans
            solution.sb.append("\n");
        }

        out.println(solution.sb);

        out.close();
    }
}

class DisjointSet {
    int[] parent;
    int[] size;

    DisjointSet(int n) {
        parent = new int[n+1];
        size = new int[n+1];

        for (int i=1;i<=n;i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int getUltParent(int node) {
        if (parent[node] == node)
            return node;

        return getUltParent(parent[node]);
    }

    public void unionBySize(int u,int v) {
        int ultParU = getUltParent(u);
        int ultParV = getUltParent(v);

        if (ultParU == ultParV)
            return;

        if (size[ultParU] >= size[ultParV]) {
            size[ultParU] += size[ultParV];
            parent[ultParV] = ultParU;
        } else {
            size[ultParV] += size[ultParU];
            parent[ultParU] = ultParV;
        }
    }

}


class Solution {
    public static final int INT_MOD=1_000_000_007;
    public static final long LONG_MOD=1_000_000_007L;

    public StringBuilder sb=new StringBuilder();

    //write logic here and print the result
    public void solve(int n,int m,int[][] arr) {
        DisjointSet ds = new DisjointSet(n+1);

        for (int i=0;i<m;i++) {
            for (int j=0;j<arr[i].length-1;j++) {
                ds.unionBySize(arr[i][j],arr[i][j+1]);
            }
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int i=1;i<=n;i++) {
            int ultPar = ds.getUltParent(i);
            sj.add(Integer.toString(ds.size[ultPar]));
        }

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