public class FindComplement {
    public static void main(String[] args) {
        System.out.println(new FindComplement().new Solution().findComplement(5));
    }
    class Solution {
        public int findComplement(int num) {
            String t = Integer.toBinaryString(num);
            String result = "";
            //System.out.println(t);
            for (int i = 0; i < t.length(); i++) {
                if (t.charAt(i) == '0') {
                    result += '1';
                } else {
                    result += '0';
                }
            }
            //System.out.println(result);
            return Integer.parseInt(result,2);
        }
    }
}
