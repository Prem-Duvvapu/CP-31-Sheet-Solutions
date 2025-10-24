import java.io.*;
import java.util.*;

public class NestedSegments {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

//        int t=fr.nextInt();
        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            List<Tuple> list = new ArrayList<>();

            for (int i=0;i<n;i++) {
                int l = fr.nextInt();
                int r = fr.nextInt();
                Tuple tuple = new Tuple(l,r,i);
                list.add(tuple);
            }

            //make call to execute the logic
            solution.solve(n,list);

            //new line after test case ans
            solution.sb.append("\n");
        }

        out.println(solution.sb);

        out.close();
    }
}

class Tuple {
    int first;
    int second;
    int pos;

    public Tuple(int first, int second, int pos) {
        this.first = first;
        this.second = second;
        this.pos = pos;
    }
}

class Solution {
    public static final int INT_MOD=1_000_000_007;
    public static final long LONG_MOD=1_000_000_007L;

    public StringBuilder sb=new StringBuilder();

    //write logic here and print the result
    public void solve(int n,List<Tuple> list) {
        Comparator<Tuple> com = new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                if (o1.first < o2.first) {
                    return -1;
                } else if (o1.first > o2.first) {
                    return 1;
                } else {
                    return Integer.compare(o2.second, o1.second);
                }
            }
        };

        Collections.sort(list, com);

        int maxR = list.get(0).second;
        for (int i=1;i<n;i++) {
            if (list.get(i).second <= maxR) {
                sb.append(list.get(i).pos+1).append(" ");
                for (int j=0;j<i;j++) {
                    if (list.get(j).second == maxR) {
                        sb.append(list.get(j).pos+1);
                        return;
                    }
                }
            }

            maxR = Math.max(maxR, list.get(i).second);
        }

        sb.append("-1 -1");
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