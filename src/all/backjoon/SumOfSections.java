package all.backjoon;

import java.io.*;
import java.util.*;
 
public class SumOfSections {
    // �ڰ� ���� ��x
    static double baseLog(double x, double base) {
        return Math.log10(x) / Math.log10(base);
    }
    
    static long init(Long[] a, Long[] tree, int node, int start, int end) {
        if (start == end) {
            return tree[node] = a[start];
        } else {
            return tree[node] = init(a, tree, node * 2, start, (start + end) / 2)
                    + init(a, tree, node * 2 + 1, (start + end) / 2 + 1, end);
        }
    }
    
    static void update(Long[] tree, int node, int start, int end, int index, long diff) {
        if (index < start || index > end)
            return;
        tree[node] = tree[node] + diff;
        if (start != end) {
            update(tree, node * 2, start, (start + end) / 2, index, diff);
            update(tree, node * 2 + 1, (start + end) / 2 + 1, end, index, diff);
        }
    }
    
    static long sum(Long[] tree, int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        return sum(tree, node * 2, start, (start + end) / 2, left, right)
                + sum(tree, node * 2 + 1, (start + end) / 2 + 1, end, left, right);
    }
    
    public static void main(String[] args) throws IOException {
        // StringTokenizer �̿�
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        Long a[] = new Long[n];
        
        //System.out.println(a.length);
        
        int h = (int) (Math.ceil(baseLog((double) n, 2.0)));
        int tree_size = (1 << (h + 1));
        Long[] tree = new Long[tree_size];
        
        m += k;
        for (int i = 0; i < n; i++)
        {
            a[i] = Long.parseLong(br.readLine());
        }
        
        init(a, tree, 1, 0, n - 1);
        
        while (m-- > 0)
        {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st2.nextToken());
            if (t1 == 1)
            {
                int t2 = Integer.parseInt(st2.nextToken());
                Long t3 = Long.parseLong(st2.nextToken());
                t2 -= 1;
                long diff = t3 - a[t2];
                a[t2] = t3;
                update(tree, 1, 0, n - 1, t2, diff);
            } else if (t1 == 2)
            {
                int t2 = Integer.parseInt(st2.nextToken());
                int t3 = Integer.parseInt(st2.nextToken());
                System.out.println(sum(tree, 1, 0, n - 1, t2 - 1, t3 - 1));
            }
        }
    }
}



