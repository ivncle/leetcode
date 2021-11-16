import java.util.HashSet;
import java.util.Set;

public class IsRectangleCover {
    public static void main(String[] args) {
        System.out.println(new IsRectangleCover().new Solution().isRectangleCover(new int[][]{{1,1,3,3}, {3,1,4,2}, {3,2,4,4}, {1,3,2,4},
                {2,3,3,4}}));
    }
    class Solution {
        public boolean isRectangleCover(int[][] rectangles) {
            Set<String> s = new HashSet<>();
            int n = rectangles.length;
            int left = Integer.MAX_VALUE;
            int right = Integer.MIN_VALUE;
            int top = Integer.MIN_VALUE;
            int bottom = Integer.MAX_VALUE;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int[] t = rectangles[i];
                left = Math.min(left, t[0]);
                bottom = Math.min(bottom, t[1]);
                right = Math.max(right, t[2]);
                top = Math.max(top, t[3]);
                sum += caculateArea(t[0], t[1], t[2], t[3]);
                String[] str= new String[4];
                str[0] = merge(t[0], t[1]);
                str[1] = merge(t[0], t[3]);
                str[2] = merge(t[2], t[1]);
                str[3] = merge(t[2], t[3]);
                for (int j = 0; j < 4; j++) {
                    if (s.contains(str[j])) {
                        s.remove(str[j]);
                    } else {
                        s.add(str[j]);
                    }
                }
            }
            if (s.size() == 4 && s.contains(merge(left, bottom))
                    && s.contains(merge(left, top))
                    && s.contains(merge(right, bottom))
                    && s.contains(merge(right, top)) && sum == caculateArea(left, bottom, right, top)) {
                return true;
            }
            return false;
        }
        String merge(int a, int b) {
            return  a + "" + b;
        }
        int caculateArea(int left, int bottom, int right, int top) {
            return (right - left) * (top - bottom);
        }

    }
}
