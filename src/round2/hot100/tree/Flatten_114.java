package round2.hot100.tree;

public class Flatten_114 {
    /*
        二叉树展开为链表
        两种方法
        1. 直接按先序遍历的顺序构造新树，节点全部位于右边
        2. 原地修改原来的树
            - 先找到 root 节点的左子树的最右侧，如果没有左子树就向右遍历
            - 找到最右侧后，将 root 的右子树接到该最右侧节点的右子树上
            - root 的左子树设置为右子树，左子树悬空
            - 只要 root 不为空就向右遍历
     */
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        // 当 root 不为空
        while (root != null) {
            // 先检查 root 有没有左子树
            // 没有左子树直接向右遍历
            if (root.left == null)
                root = root.right;
                // 有左子树
            else {
                // 找到该左子树的最右侧的节点
                TreeNode cur = root.left;
                while (cur.right != null)
                    cur = cur.right;
                // 找到最右侧后，将根节点的右子树接到最右侧节点的右子树上
                cur.right = root.right;
                // 左子树设置为右子树，左子树变为空
                root.right = root.left;
                root.left = null;
                // 向右遍历
                root = root.right;
            }
        }
    }
}
