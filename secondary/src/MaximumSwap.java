public class MaximumSwap {
    public static void main(String[] args) {

    }
    class Solution {
        public int maximumSwap(int num) {
            char[] charArray = String.valueOf(num).toCharArray();
            int max = num;
            for (int i = 0; i < charArray.length; i++) {
                for (int j = i + 1; j < charArray.length; j++) {
                    swap(charArray, i, j);
                    max = Math.max(max, Integer.parseInt(new String(charArray)));
                    swap(charArray, j, i);
                }
            }
            return max;
        }
        void swap(char[] chars, int i, int j) {
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
        }

    }
}
