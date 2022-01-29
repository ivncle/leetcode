import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {
    public static void main(String[] args) {
        System.out.println(new KthSmallestPrimeFraction().new Solution().kthSmallestPrimeFraction(new int[]{1, 2}, 2));
    }

    class Solution {
        public int[] kthSmallestPrimeFraction(int[] arr, int k) {
            //a / b > c / d
            List<int[]> list = new ArrayList<>();

            for (int i = 0; i < arr.length; i++) {
                for (int j = i; j < arr.length; j++) {
                    list.add(new int[]{arr[i], arr[j]});
                }
            }
            Collections.sort(list, (x, y) -> x[0] * y[1] - x[1] * y[0]);
            //return list.get(k - 1);
            //优先队列
            PriorityQueue<int[]> q = new PriorityQueue<>((x, y) -> arr[x[0]] * arr[y[1]] - arr[x[1]] * arr[y[0]]);
            for (int i = 1; i < arr.length; i++) {
                q.offer(new int[]{0, i});
            }

            for (int i = 1; i < k; i++) {
                int[] f = q.poll();
                int x = f[0], y = f[1];
                if (x + 1 < y) {
                    q.offer(new int[]{x + 1, y});
                }
            }

            return new int[]{arr[q.peek()[0]], arr[q.peek()[1]]};

        }
    }
}
