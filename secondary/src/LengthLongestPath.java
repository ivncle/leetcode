import java.util.HashMap;
import java.util.Map;

public class LengthLongestPath {
    public static void main(String[] args) {

    }
    class Solution {
        public int lengthLongestPath(String input) {
            Map<Integer, String> m = new HashMap<>();
            int n = input.length();
            String ans = "";
            int i = 0;
            while (i < n) {
                int level = 0;
                while (i < n && input.charAt(i) == '\t' && ++level >= 0) {
                    i++;
                }
                int j = i;
                boolean flag = false;
                while (j < n && input.charAt(j) != '\n') {
                    if (input.charAt(j++) == '.') {
                        flag = true;
                    }
                }
                String cur = input.substring(i, j);
                String prev = m.getOrDefault(level - 1, null);
                String path = prev == null ? cur : prev + "/" + cur;
                if (!flag) {
                    m.put(level, path);
                } else if (ans.length() == 0 || path.length() > ans.length()) {
                    ans = path;
                    i = j + 1;
                }
            }
            return ans == null ? 0 : ans.length();
        }
    }
}
