import java.io.*;
import java.util.*;

public class LunarNewYearAndAWander {
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
            int[][] edges = new int[m][2];
            for (int i=0;i<m;i++) {
                edges[i][0] = fr.nextInt();
                edges[i][1] = fr.nextInt();
            }

            //make call to execute the logic
            solution.solve(n,m,edges);

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
    public void solve(int n,int m,int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0;i<n+1;i++)
            adjList.add(new ArrayList<>());

        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);

        while (!treeSet.isEmpty()) {
            int first = treeSet.pollFirst();
            res.add(first);
            set.add(first);

            for (int ngbr: adjList.get(first)) {
                if (!set.contains(ngbr) && !treeSet.contains(ngbr)) {
                    treeSet.add(ngbr);
                }
            }
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int val: res)
            sj.add(String.valueOf(val));

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