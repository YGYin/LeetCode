package round4.leetcode.tree;

public class Flatten_114 {
    /*
        二叉树展开为链表
        1. 先标记根节点的左子树，找其左子树的最右子节点为 move 节点
        2. 如果左子树的最右节点不为空，
            则将根节点的右子树连接到该节点的右侧，根节点的左子树变为右子树，根节点左子树置空
        3. 移动根节点指针，循环上述操作
     */
    public void flatten(TreeNode root) {
        // 根节点不为空则循环
        while (root != null) {
            // 找左子树的最右节点为 move 节点
            TreeNode move = root.left;
            while (move != null && move.right != null)
                move = move.right;

            // 将根节点的右子树接到 move.right，根节点的左子树作为根节点的右子树，左子树置空
            if (move != null) {
                move.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            // 移动根节点指针，循环操作
            root = root.right;
        }
    }
}
