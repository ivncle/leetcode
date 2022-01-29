import java.util.*;

public class MinJumps {
    public static void main(String[] args) {
        System.out.println(new MinJumps().new Solution().minJumps(new int[]{}));
    }
    class Solution {
        public int minJumps(int[] arr) {
            Map<Integer, List<Integer>> m = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                m.putIfAbsent(arr[i], new ArrayList<>());
                m.get(arr[i]).add(i);
            }
            Set<Integer> set = new HashSet<>();
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{0, 0});
            set.add(0);
            while (!q.isEmpty()) {
                int[] t = q.poll();
                if (t[0] == arr.length - 1) {
                    return t[1];
                }
                if (m.containsKey(arr[t[0]])) {
                    for (int i : m.get(arr[t[0]])) {
                        if (set.add(i)) {
                            q.offer(new int[]{i, t[1] + 1});
                        }
                    }
                    m.remove(arr[t[0]]);
                }
                if (t[0] + 1 < arr.length && set.add(t[0] + 1)) {
                    q.offer(new int[]{t[0] + 1, t[1] + 1});
                }
                if (t[0] - 1 >= 0 && set.add(t[0] - 1)) {
                    q.offer(new int[]{t[0] - 1, t[1] + 1});
                }
            }
            return 0;
        }
    }
}
