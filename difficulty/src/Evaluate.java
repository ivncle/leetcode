import java.util.*;

import static java.lang.Integer.parseInt;

public class Evaluate {
    public static void main(String[] args) {

    }

    class Solution {
        Map<String, Deque<Integer>> scope = new HashMap<>();
        int start = 0;

        public int evaluate(String expression) {
            return innerEvaluate(expression);
        }

        public int innerEvaluate(String expression) {
            //非表达式,可能是整数或者变量
            if (expression.charAt(start) != '(') {
                if (Character.isLowerCase(expression.charAt(start))) {
                    String var = parseVar(expression);
                    return scope.get(var).peek();
                } else {
                    return parseInt(expression);
                }
            }
            int ret;
            start++;
            if (expression.charAt(start) == 'l') {
                start += 4;
                List<String> vars = new ArrayList<>();
                while (true) {
                    if (!Character.isLowerCase(expression.charAt(start))) {
                        ret = innerEvaluate(expression);
                        break;
                    }
                    String var = parseVar(expression);
                    if (expression.charAt(start) == ')') {
                        ret = scope.get(var).peek();
                        break;
                    }
                    vars.add(var);
                    //移除空格
                    start++;
                    int e = innerEvaluate(expression);
                    scope.putIfAbsent(var, new ArrayDeque<Integer>());
                    scope.get(var).push(e);
                    //移除空格
                    start++;
                }
                for (String var : vars) {
                    scope.get(var).pop();
                }
            } else if (expression.charAt(start) == 'a') {//add
                start += 4;
                int e1 = innerEvaluate(expression);
                start++;
                int e2 = innerEvaluate(expression);
                ret = e1 + e2;
            } else {//mult
                start += 5;
                int e1 = innerEvaluate(expression);
                start++;
                int e2 = innerEvaluate(expression);
                ret = e1 * e2;
            }
            start++;//移除右边括号
            return ret;
        }
        public int parseInt(String expression) {
            int n = expression.length();
            int ret = 0, sign = 1;
            if (expression.charAt(start) == '-') {
                sign = -1;
                start++;
            }
            while (start < n && Character.isDigit(expression.charAt(start))) {
                ret = ret * 10 + expression.charAt(start) - '0';
                start++;
            }
            return sign * ret;
        }

        public String parseVar(String expression) {
            int n = expression.length();
            StringBuffer ret = new StringBuffer();
            while (start < n && expression.charAt(start) != ' ' && expression.charAt(start) != ')') {
                ret.append(expression.charAt(start));
                start++;
            }
            return ret.toString();
        }

    }
}