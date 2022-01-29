import java.util.PriorityQueue;

public class EatenApples {
    public static void main(String[] args) {
        System.out.println(new EatenApples().new Solution().eatenApples(new int[]{}, new int[]{}));
    }

    class Solution {
        public int eatenApples(int[] apples, int[] days) {
            int n = apples.length;
            int ans = 0;
            PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            int i;
            for (i = 0; i < n; i++) {
                while (!q.isEmpty() && q.peek()[0] <= i) {
                    q.poll();
                }
                int end = i + days[i];
                int count = apples[i];
                if(count > 0) {
                    q.offer(new int[]{end, count});
                }
                if(!q.isEmpty()) {
                    int[] a = q.peek();
                    a[1]--;
                    if(a[1] == 0) {
                        q.poll();
                    }
                    ans++;
                }
            }
            while (!q.isEmpty()) {
                while (!q.isEmpty() && q.peek()[0] <= i) {
                    q.poll();
                }
                if(q.isEmpty()) {
                    break;
                }
                int[] a = q.poll();
                ans += Math.min(a[0] - i, a[1]);
                i += Math.min(a[0] - i, a[1]);
            }
            return ans;
        }
    }

}
