public class Tree2str {
    public static void main(String[] args) {

    }

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
        StringBuffer ans = new StringBuffer();

        void dfs(TreeNode root) {
            ans.append(Integer.valueOf(root.val).toString());
            if (root.left != null && root.right != null) {
                ans.append('(');
                dfs(root.left);
                ans.append(')');
                ans.append('(');
                dfs(root.right);
                ans.append(')');
            } else if (root.left != null && root.right == null) {
                ans.append('(');
                dfs(root.left);
                ans.append(')');
            } else if (root.left == null && root.right != null) {
                ans.append('(');
                ans.append(')');
                ans.append('(');
                dfs(root.right);
                ans.append(')');
            }
        }

        public String tree2str(TreeNode root) {
            dfs(root);
            return ans.toString();
        }
    }

}
