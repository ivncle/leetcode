public class IsAdditiveNumber {
    public static void main(String[] args) {
        System.out.println(new IsAdditiveNumber().new Solution().isAdditiveNumber(
                "199100199"));
    }

    class Solution {
        public boolean isAdditiveNumber(String num) {
            int n = num.length();
            for (int twoStart = 1; twoStart < n - 1; twoStart++) {
                if (num.charAt(0) == '0' && twoStart != 1) {
                    break;
                }
                for (int twoEnd = twoStart; twoEnd < n - 1; twoEnd++) {
                    if (num.charAt(twoStart) == '0' && num.charAt(twoStart) != num.charAt(twoEnd)) {
                        break;
                    }
                    //System.out.println("twoStart:" + twoStart + "   " + "twoEnd:" + twoEnd);
                    if (check(twoStart, twoEnd, num)) {
                        return true;
                    }
                }
            }
            return false;
        }

        boolean check(int twoStart, int twoEnd, String num) {
            int n = num.length();
            int firstStart = 0, firstEnd = twoStart - 1;
            while (twoEnd < n) {
                String three = add(num, twoStart, twoEnd, firstStart, firstEnd);
                //System.out.println("three:" + three);
                int threeStart = twoEnd + 1;
                int threeEnd = threeStart + three.length() - 1;
                if (threeEnd >= n || !num.substring(threeStart, threeEnd + 1).equals(three)) {
                    return false;
                }
                if (threeEnd == n - 1) {
                    return true;
                }
                firstStart = twoStart;
                firstEnd = twoEnd;
                twoStart = threeStart;
                twoEnd = threeEnd;
            }
            return false;
        }

        String add(String num, int twoStart, int twoEnd, int firstStart, int firstEnd) {
            StringBuffer three = new StringBuffer();
            String first = num.substring(firstStart, firstEnd + 1), two = num.substring(twoStart, twoEnd + 1);
            //System.out.println("first :" + first + "   " + "two:" + two);
            int carry = 0;
            int firstIndex = first.length() - 1, twoIndex = two.length() - 1;
            while (firstIndex >= 0 && twoIndex >= 0) {
                int t = first.charAt(firstIndex) - '0' + two.charAt(twoIndex) - '0' + carry;
                //System.out.println(t);
                if (t >= 10) {
                    carry = t / 10;
                    t %= 10;
                } else {
                    carry = 0;
                }
                three.append((char)(t + '0'));
                //System.out.println(three);
                firstIndex--;
                twoIndex--;
            }

            while (firstIndex >= 0) {
                int t = first.charAt(firstIndex) - '0' + carry;
                if (t >= 10) {
                    carry = t / 10;
                    t %= 10;
                } else {
                    carry = 0;
                }
                three.append((char)(t + '0'));
                firstIndex--;
            }
            while (twoIndex >= 0) {
                int t = two.charAt(twoIndex) - '0' + carry;
                if (t >= 10) {
                    carry = t / 10;
                    t %= 10;
                } else {
                    carry = 0;
                }
                three.append((char)(t + '0'));
                twoIndex--;
            }
            if (carry > 0) {
                three.append((char)(carry + '0'));
            }
            three.reverse();
            //System.out.println(three.toString());
            return three.toString();
        }
    }
}
