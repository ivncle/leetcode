public class IsSelfCrossing {
    public static void main(String[] args) {
        int[] distance = new int[10];
        System.out.println(new IsSelfCrossing().new Solution().isSelfCrossing(distance));
    }
    class Solution {
        public boolean isSelfCrossing(int[] distance) {
            for (int i = 3; i < distance.length; i++) {
                if (distance[i - 1] <= distance[i - 3] && distance[i] >= distance[i - 2]) {
                    return true;
                }
                if (i == 4 && distance[3] == distance[1] && distance[4] >= distance[2] - distance[0]) {
                    return true;
                }
                if (i >= 5 && distance[i - 1] >= distance[i - 3] - distance[i - 5] && distance[i - 1] <= distance[i - 3] &&
                 distance[i - 2] > distance[i - 4] && distance[i] >= distance[i - 2] - distance[i - 4]) {
                    return true;
                }
            }
            return false;
        }
    }
}
