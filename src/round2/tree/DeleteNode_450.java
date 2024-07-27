package round2.tree;

public class DeleteNode_450 {
    /*
        删除二叉搜索树中的节点
        需要分情况讨论，删除一个节点可以分为 5 种情况
        1. 没有找到等于目标值的节点，返回空
        找到了符合目标值的节点：
        2. 该节点为叶子节点，直接删除返回空
        3. 该节点有左子节点，没有右子节点，返回左子节点替换当前节点为根节点
        4. 该节点有右子节点，没有左子节点，返回右子节点替换当前节点为根节点
        5. 该节点有左右子节点，将该节点的左子节点，接到右子节点的最左子节点上，返回右子节点接替成为根节点
     */
    // 返回新的接替当前节点的根节点，传入当前根节点和目标值
    public TreeNode deleteNode(TreeNode root, int key) {
        // 如果没有找到符合目标值的节点
        if (root == null)
            return root;
        if (root.val == key) {
            // 2 为叶子节点的情况会被 3 和 4 所覆盖
            // 3. 4. 只有单一子节点，返回单边子节点接替成为新的根节点
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
                // 5. 如果有左右子节点，将该节点的左子节点，接到右子节点的最左子节点上
            else {
                // 遍历到右子节点的最左子节点的
                TreeNode cur = root.right;
                while (cur.left != null)
                    cur = cur.left;

                cur.left = root.left;
                // 将当前节点替换成右子节点
                root = root.right;
                return root;
            }
        }
        // 根节点分别接住新的左右子节点(利用二叉树性质寻找遍历)
        if (key < root.val)
            root.left = deleteNode(root.left, key);
        if (key > root.val)
            root.right = deleteNode(root.right, key);

        return root;
    }
}
