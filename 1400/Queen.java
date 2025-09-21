import java.io.*;
import java.util.*;

public class Queen {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

//        int t=fr.nextInt();
        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int[] c = new int[n+1];
            int root = -1;
            List<List<Integer>> adjList = new ArrayList<>();
            for (int i=0;i<=n;i++)
                adjList.add(new ArrayList<>());

            for (int i=1;i<=n;i++) {
                int parent = fr.nextInt();
                c[i] = fr.nextInt();

                if (parent == -1)
                    root = i;
                else
                    adjList.get(parent).add(i);
            }

            //make call to execute the logic
            solution.solve(n,c,root,adjList);

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
    public void solve(int n,int[] c,int root,List<List<Integer>> adjList) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {
            int qlen = q.size();

            while (qlen-- > 0) {
                int curr = q.poll();

                int cnt = 0;
                for (int child: adjList.get(curr)) {
                    if (c[child] == 1)
                        cnt++;
                    q.add(child);
                }

                if (c[curr] == 1 && cnt == adjList.get(curr).size()) {
                    res.add(curr);
                }
            }
        }

        if (res.isEmpty()) {
            sb.append(-1);
            return;
        }

        Collections.sort(res);
        StringJoiner sj = new StringJoiner(" ");
        for (int val: res)
            sj.add(Integer.toString(val));

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