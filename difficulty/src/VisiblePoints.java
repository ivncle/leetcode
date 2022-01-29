import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VisiblePoints {
    public static void main(String[] args) {

    }
    class Solution {

        public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
            int sameCnt = 0;
            int maxCnt = 0;
            List<Double> list = new ArrayList<>();
            int locationX = location.get(0);
            int locationY = location.get(1);
            for (int i = 0; i < points.size(); i++) {
                int x = points.get(i).get(0);
                int y = points.get(i).get(1);
                if (x == locationX && y == locationY) {
                    sameCnt++;
                    continue;
                }
                Double d = Math.atan2(y - locationY, x - locationX);
                list.add(d);
            }
            Collections.sort(list);
            int m = list.size();
            for (int i = 0; i < m; i++) {
                list.add(list.get(i) + 2 * Math.PI);
            }
            int right = 0;
            double t = angle * Math.PI / 180;
            for (int i = 0; i < m; i++) {
                double c = list.get(i) + t;
                while (right < list.size() && list.get(right) <= c) {
                    right++;
                }
                maxCnt = Math.max(maxCnt, right - i);
            }
            return sameCnt + maxCnt;
        }
    }
}
