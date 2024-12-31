package round3.hot100.tree;

public class Flatten_114 {
    /*
        二叉树展开为链表
        1. 先标记根节点的左子树，找其左子树的最右子节点为 move 节点
        2. 如果左子树的最右节点不为空，
            则将根节点的右子树连接到该节点的右侧，根节点的左子树变为右子树，根节点左子树置空
        3. 移动根节点指针，循环上述操作
     */
    public void flatten(TreeNode root) {
        // 当根节点不为空则循环
        while (root != null) {
            TreeNode move = root.left;
            // 找根节点左子树的最右节点
            while (move != null && move.right != null)
                move = move.right;

            // 因为有可能根节点左子树本身为空，需要对 move 判空
            if (move != null) {
                // 将根节点右子树接到 move 节点右侧，交换根节点左右子树，并置空左子树
                move.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            // 移动根节点指针
            root = root.right;
        }
    }
}
