


//https://leetcode-cn.com/problems/split-linked-list-in-parts/
public class SplitListToParts {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    class Solution {
        public ListNode[] splitListToParts(ListNode head, int k) {
            ListNode[] list = new ListNode[k + 2];
            int len = 0;
            ListNode p = head;
            while (p != null) {
                //System.out.println(p.val);
                len++;
                p = p.next;
            }
            int l = len / k, m = 0;
            if (len % k != 0) {
                m = len % k;
            }
            //System.out.println("l: " + l + "  m: " + m);
            p = head;
            for (int i = 0; i < k; i++) {
                if (p == null) {
                    continue;
                } else {
                    ListNode q = list[i];
                    for (int j = 0; j < l; j++) {
                        if (q == null) {
                            list[i] = q = new ListNode(p.val);
                        } else {
                            q.next = new ListNode(p.val);
                            q = q.next;
                        }
                        p = p.next;
                    }
                    if (m != 0) {
                        if (q == null) {
                            list[i] = q = new ListNode(p.val);
                        } else {
                            q.next = new ListNode(p.val);
                        }
                        //q = q.next;
                        p = p.next;
                        m--;
                    }
                }
            }
            return list;
        }
    }
    public static void main(String[] args) {
        Solution solution = new SplitListToParts().new Solution();
        ListNode head = null;
        ListNode p = null;
        for (int i = 1; i <= 3; i++) {
            if (p == null) {
                head = p = new SplitListToParts().new ListNode(i);
            } else {
                p.next = new SplitListToParts().new ListNode(i);
                p = p.next;
            }
        }
        System.out.println(solution.splitListToParts(head, 5));
    }
}
