import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class BestRotation implements Cloneable{
    public static void main(String[] args) throws CloneNotSupportedException {

    }

    class Solution {
        public int bestRotation(int[] nums) {
            int n = nums.length;
            int[] dif = new int[n];
            for (int i = 0; i < n; i++) {
                int left = (i + 1) % n;
                int right = (i - nums[i] + n + 1) % n;
                dif[left]++;
                dif[right]--;
                if (left >= right) {
                    dif[0]++;
                }
            }
            int index = 0;
            int score = 0;
            int maxScore = 0;
            for (int i = 0; i < n; i++) {
                score += dif[i];
                if (score > maxScore) {
                    maxScore = score;
                    index = i;
                }
            }
            return index;
        }
    }
}
