package coding.treenode;

public class DeleteNode_23 {
    /*
        因为本题为遇到目标节点的时候就开始返回，所以处理逻辑主要写在终止条件内
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        // 1. 没找到删除的节点
        if (root == null)
            return null;
        // 找到删除的节点后
        if (root.val == key) {
            // 2. 左右都为空已包含在内
            // 3. 左孩子为空，右孩子不为空，将其右子树返回给父节点
            if (root.left == null)
                return root.right;
                // 4. 左孩子不为空，右孩子为空，将其左子树返回给节点
            else if (root.right == null)
                return root.left;
                // 5. 左右都不为空，将其左子树放到其右子树的最左侧节点的左孩子的位置
                //    因为要找一个稍大于被删除节点的节点，位置就在其右子树的最左侧节点
                //    处理完其左子树后，固定返回其右子树给父节点
            else {
                // 先新建节点，指向删除节点的右子树，然后遍历到其最左边
                TreeNode cur = root.right;
                while (cur.left != null)
                    cur = cur.left;
                // 将删除节点的左子树移到当前节点的左子树上
                cur.left = root.left;
                // 再直接将删除节点的右子树返回给父节点
                return root.right;
            }
        }
        // 按照搜索二叉树性质搜索遍历是否有节点等于 key
        if (key < root.val)
            root.left = deleteNode(root.left, key);
        if (key > root.val)
            root.right = deleteNode(root.right, key);
        return root;
    }
}
