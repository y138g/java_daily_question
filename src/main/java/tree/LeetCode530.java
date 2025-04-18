package main.java.tree;

public class LeetCode530 {

    TreeNode pre;
    int result = Integer.MAX_VALUE;

    /**
     * 二叉搜索树的最小绝对差 实现方法1:递归 leetcode 530
     *
     * @param root 二叉树
     * @return 最小绝对差
     */
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        traversal(root);
        return result;
    }

    /**
     * 递归遍历二叉树（中序）
     *
     * @param root 二叉树
     */
    private void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        if (pre != null) result = Math.min(result, root.val - pre.val);
        pre = root;
        traversal(root.right);
    }
}
