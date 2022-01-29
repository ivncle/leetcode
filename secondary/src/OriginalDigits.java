import java.util.HashMap;
import java.util.Map;

public class OriginalDigits {
    public static void main(String[] args) {
        System.out.println(new OriginalDigits().new Solution().originalDigits("owoztneoer"));
    }

    class Solution {
        public String originalDigits(String s) {
            Map<Character, Integer> m = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                m.put(c, m.getOrDefault(c, 0) + 1);
            }
            int[] count = new int[10];
            count[0] = m.getOrDefault('z', 0);
            count[2] = m.getOrDefault('w', 0);
            count[4] = m.getOrDefault('u', 0);
            count[6] = m.getOrDefault('x', 0);
            count[8] = m.getOrDefault('g', 0);

            count[3] = m.getOrDefault('h', 0) - count[8];
            count[5] = m.getOrDefault('f', 0) - count[4];
            count[7] = m.getOrDefault('s', 0) - count[6];

            count[1] = m.getOrDefault('o', 0) - count[0] - count[2] - count[4];
            count[9] = m.getOrDefault('i', 0) - count[5] - count[6] - count[8];
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < count[i]; j++) {
                    ans.append(i + "");
                }
            }
            return ans.toString();
        }
    }
}
