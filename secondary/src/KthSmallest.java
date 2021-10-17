public class KthSmallest {//https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/submissions/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        int ans = 0;
        int k;

        void dfs(TreeNode root) {
            if (root.left == null && root.right == null) {
                k--;
                if (k == 0) {
                    ans = root.val;
                    return;
                }
                return;
            }
            if (root.left != null) {
                dfs(root.left);

            }
            k--;
            if (k == 0) {
                ans = root.val;
                return;
            }
            if (root.right != null) {
                dfs(root.right);
            }


        }

        public int kthSmallest(TreeNode root, int k) {
            this.k = k;
            dfs(root);
            return ans;
        }
    }
}
