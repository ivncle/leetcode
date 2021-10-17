import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    boolean[] flag = new boolean[10001];

    public SummaryRanges() {

    }

    public void addNum(int val) {
        flag[val] = true;
    }

    public int[][] getIntervals() {
        int start = -1, end = -1;
        List<int[]> lists = new ArrayList<>();
        for (int i = 0; i < 10001; i++) {
            if (flag[i]) {
                if (start == -1) {
                    start = end = i;
                } else {
                    end = i;
                }
            } else {
                if (start != -1) {
                    lists.add(new int[] {start,end});
                    start = end = -1;
                }
            }
        }
        if (start != -1) {
            lists.add(new int[] {start,end});
        }
        return lists.toArray(new int[lists.size()][2]);
    }

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1);
        summaryRanges.addNum(2);
        summaryRanges.addNum(3);
        summaryRanges.addNum(6);
        summaryRanges.addNum(7);
        System.out.println(summaryRanges.getIntervals());
    }
}
