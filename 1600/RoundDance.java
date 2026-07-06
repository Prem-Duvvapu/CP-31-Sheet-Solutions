import java.io.*;
import java.util.*;

public class RoundDance {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
//        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int[] a = new int[n];
            for (int i=0;i<n;i++) {
                a[i] = fr.nextInt()-1;
            }

            //make call to execute the logic
            solution.solve(n,a);

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
    public void solve(int n,int[] a) {
        int cycles = 0;
        int bamboos = 0;
        boolean[] visited = new boolean[n];
        int[] degree = new int[n];

        List<Set<Integer>> adjList = new ArrayList<>();
        for (int i=0;i<n;i++) {
            adjList.add(new HashSet<>());
        }

        for (int i=0;i<n;i++) {
            adjList.get(i).add(a[i]);
            adjList.get(a[i]).add(i);
        }

        for (int i=0;i<n;i++) {
            degree[i] = adjList.get(i).size();
        }

        for (int i=0;i<n;i++) {
            if (!visited[i]) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                visited[i] = true;

                Set<Integer> componentElements = new HashSet<>();

                while (!q.isEmpty()) {
                    int front = q.poll();
                    componentElements.add(front);

                    for (int ngbr: adjList.get(front)) {
                        if (!visited[ngbr]) {
                            q.add(ngbr);
                            visited[ngbr] = true;
                        }
                    }
                }


                boolean isBamboo = false;
                for (int ele: componentElements) {
                    if (degree[ele] == 1) {
                        isBamboo = true;
                        break;
                    }
                }

                if (isBamboo) {
                    bamboos++;
                } else {
                    cycles++;
                }
            }
        }

        int minCycles = cycles + Math.min(bamboos,1);
        int maxCycles = cycles + bamboos;

        sb.append(minCycles).append(" ").append(maxCycles);
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