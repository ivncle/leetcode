import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(new SimplifyPath().new Solution().simplifyPath("./"));
    }

    class Solution {
        public String simplifyPath(String path) {
            StringBuilder ans = new StringBuilder();
            String[] arr = path.split("/");
            Deque<String> stack = new ArrayDeque<>();
            for (String s : arr) {
                if ("..".equals(s)) {
                    if (!stack.isEmpty()) {
                        stack.pollLast();
                    }
                } else if(s.length() > 0 && !".".equals(s)) {
                    stack.offerLast(s);
                }
            }
            if (stack.isEmpty()) {
                ans.append('/');
            } else {
                while (!stack.isEmpty()) {
                    ans.append('/');
                    ans.append(stack.pollFirst());
                }
            }

            return ans.toString();
        }
    }
}
