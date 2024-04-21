package round1.hot100.tree;

public class Flatten_114 {
    public void flatten(TreeNode root) {
        // 二叉树展开为链表
        // 主要思想：
        //    1. 先找到当前左子树的最右边节点，将当前右子树接到该节点的右边
        //    2. 将当前节点的左子树设置为当前节点的右子树
        //    3. 向右遍历，非空重复上述过程，当前节点为空时结束
        while (root != null) {
            // 看是否存在左子树，不存在时考虑下一个节点
            if (root.left == null)
                root = root.right;
            else {
                // 找到当前左子树的最右边节点
                TreeNode leftTemp = root.left;
                while (leftTemp.right != null)
                    leftTemp = leftTemp.right;

                // 当前右子树接到该节点
                leftTemp.right = root.right;
                // 将当前节点的左子树设置为当前节点的右子树，左边置空
                root.right = root.left;
                root.left = null;
                // 后移
                root = root.right;
            }
        }
    }
}
