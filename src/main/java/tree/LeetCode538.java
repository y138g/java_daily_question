package main.java.tree;

public class LeetCode538 {

    int sum = 0;

    /**
     * 把二叉搜索树转换为累加树 实现方法1：累加 leetcode 538
     *
     * @param root 二叉搜索树
     * @return 累加树
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return root;
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
