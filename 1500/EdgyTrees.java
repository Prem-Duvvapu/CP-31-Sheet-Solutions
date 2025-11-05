import java.io.*;
import java.util.*;

public class EdgyTrees {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

//        int t=fr.nextInt();
        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int k = fr.nextInt();
            int[][] edges = new int[n-1][3];
            for (int i=0;i<edges.length;i++) {
                edges[i][0] = fr.nextInt();
                edges[i][1] = fr.nextInt();
                edges[i][2] = fr.nextInt();
            }

            //make call to execute the logic
            solution.solve(n,k,edges);

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

        return parent[node] = getUltParent(parent[node]);
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
    public void solve(int n,int k,int[][] edges) {
        long notGood = 0;
        DisjointSet ds = new DisjointSet(n);
        int blackCnt = 0;

        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            int color = edge[2];

            if (color == 0)
                ds.unionBySize(u,v);
        }

        for (int i=1;i<=n;i++) {
            if (ds.parent[i] == i) {
                if (ds.size[i] == 1) {
                    blackCnt++;
                    continue;
                }

                long product = 1;
                for (int j=0;j<k;j++)
                    product = (product * ds.size[i])%LONG_MOD;
                notGood = (notGood + product)%LONG_MOD;
            }
        }

        notGood = (notGood + blackCnt)%LONG_MOD;
        long total = 1;
        for (int j=0;j<k;j++)
            total = (total * n)%LONG_MOD;
        long good = (total - notGood + LONG_MOD)%LONG_MOD;

        sb.append(good);
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