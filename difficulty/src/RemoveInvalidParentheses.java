import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveInvalidParentheses {

    public static void main(String[] args) {
        System.out.println(new RemoveInvalidParentheses().new Solution().removeInvalidParentheses(
                "(a)())()"));
    }
    class Solution {
        List<String> ans = new ArrayList<>();
        //计算要移除的括号数
        List<String> removeInvalidParentheses(String s) {
            int lr = 0, rr = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    lr++;
                } else if (s.charAt(i) == ')'){
                    if (lr > 0) {
                        lr--;
                    } else {
                        rr++;
                    }
                }
            }
            dfs(0, lr, rr, s);
            return ans;
        }
        void dfs(int start, int lr, int rr, String s) {
            if (lr == 0 && rr ==0) {
               if (isValid(s)) {
                   ans.add(s);
               }
               return;
            }
            for (int i = start; i < s.length(); i++) {
                if (i > start && s.charAt(i) == s.charAt(i - 1)) {

                    continue;

                }
                if (s.charAt(i) == '(' && lr >0) {
                    dfs(i, lr - 1, rr, s.substring(0, i) + s.substring(i + 1));
                }
                if (s.charAt(i) == ')' && rr >0) {
                    dfs(i, lr, rr - 1, s.substring(0, i) + s.substring(i + 1));
                }
            }
        }
        boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (!stack.empty() && s.charAt(i) == ')' && stack.peek() == '(') {
                    stack.pop();
                    continue;
                }
                if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                    continue;
                }
                stack.push(s.charAt(i));
            }
            return stack.isEmpty();
        }
    }
}
