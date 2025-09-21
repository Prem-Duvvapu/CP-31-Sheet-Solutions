import java.io.*;
import java.util.*;

public class LostNumbers {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

//        int t=fr.nextInt();
        int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            List<Integer> list = new ArrayList<>();
            String[] arr = {"? 1 2", "? 2 3", "? 4 5","? 5 6"};

            for (int i=0;i<4;i++) {
                out.println(arr[i]);
                out.flush();
                list.add(fr.nextInt());
            }

            //make call to execute the logic
            solution.solve(list);

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
    public void solve(List<Integer> list) {
        int[] arr = {4,8,15,16,23,42};
        int[] res = new int[arr.length];
        Map<Integer,List<Integer>> map = new HashMap<>();

        for (int i=0;i<arr.length;i++) {
            for (int j=i+1;j<arr.length;j++) {
                map.put(arr[i]*arr[j],new ArrayList<>(Arrays.asList(arr[i],arr[j])));
            }
        }

        // 0,1,2 positions
        int p1 = list.get(0);
        int p2 = list.get(1);
        List<Integer> l1 = map.get(p1);
        List<Integer> l2 = map.get(p2);
        if (l2.contains(l1.get(0))) {
            res[1] = l1.get(0);
            res[0] = l1.get(1);

            if (!l2.get(0).equals(l1.get(0)))
                res[2] = l2.get(0);
            else
                res[2] = l2.get(1);
        } else {
            res[1] = l1.get(1);
            res[0] = l1.get(0);

            if (!l2.get(0).equals(l1.get(1)))
                res[2] = l2.get(0);
            else
                res[2] = l2.get(1);
        }

        // 3,4,5 positions
        p1 = list.get(2);
        p2 = list.get(3);
        l1 = map.get(p1);
        l2 = map.get(p2);
        if (l2.contains(l1.get(0))) {
            res[4] = l1.get(0);
            res[3] = l1.get(1);

            if (!l2.get(0).equals(l1.get(0)))
                res[5] = l2.get(0);
            else
                res[5] = l2.get(1);
        } else {
            res[4] = l1.get(1);
            res[3] = l1.get(0);

            if (!l2.get(0).equals(l1.get(1)))
                res[5] = l2.get(0);
            else
                res[5] = l2.get(1);
        }

        StringJoiner sj = new StringJoiner(" ");
        sj.add("!");
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