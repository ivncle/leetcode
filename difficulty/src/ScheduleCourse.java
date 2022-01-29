import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ScheduleCourse {
    public static void main(String[] args) {
        System.out.println(new ScheduleCourse().new Solution().scheduleCourse(new int[][]{}));
    }
    class Solution {
        public int scheduleCourse(int[][] courses) {
            Arrays.sort(courses, (a, b) -> a[1] - b[1]);
            PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
            int total = 0;
            for (var v : courses) {
                int t = v[0], d = v[1];
                if (total + t <= d) {
                    q.offer(t);
                    total += t;
                } else if (!q.isEmpty() && q.peek() > t) {

                    total -= q.poll() - t;
                    q.offer(t);
                }
            }
            return q.size();
        }
    }
}
