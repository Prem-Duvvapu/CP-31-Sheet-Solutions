import java.io.*;
import java.util.*;

public class DivisiblePairs {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n = fr.nextInt();
            int x = fr.nextInt();
            int y = fr.nextInt();
            int[] a = new int[n];

            for (int i=0;i<n;i++)
                a[i] = fr.nextInt();

            //make call to execute the logic
            solution.solve(n,x,y,a);

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
    public void solve(int n,int x,int y,int[] a) {
        long res = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int rem = a[i] % y;
            map.putIfAbsent(rem, new ArrayList<>());
            map.get(rem).add(i);
        }

//        System.out.println(map);

        for (List<Integer> list : map.values()) {
            Map<Integer, List<Integer>> xMap = new TreeMap<>();
            for (int index: list) {
                int rem = a[index]%x;
                xMap.putIfAbsent(rem, new ArrayList<>());
                xMap.get(rem).add(index);
            }
//            System.out.println(xMap);

            long cnt = 0;
            for (Map.Entry<Integer, List<Integer>> m: xMap.entrySet()) {
                if (m.getKey() > x/2)
                    break;
                else if (m.getKey()==0 || (x%2==0 && m.getKey()==x/2)) {
                    cnt += getSumOfN(m.getValue().size()-1);
                } else {
                    long temp = 0;
                    if (xMap.containsKey(x - m.getKey()))
                        temp = xMap.get(x - m.getKey()).size();

                    cnt += (m.getValue().size() * temp);
                }
            }

            res+=cnt;
        }

        sb.append(res);
    }

    private long getSumOfN(int n) {
        return ((long)n*(n+1))/2;
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