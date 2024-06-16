package job.top101.tree;

public class BM32_MergeTrees {
    /*
        合并二叉树
        固定返回 t1
        当一个节点为空直接返回另外一个节点
     */
    // 1. 需要同时处理两棵树，传入两棵树的根节点，返回新树
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // 2. 结束条件：当其中一棵树的节点为空则返回另外一棵树的节点
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        // 3. 此题遍历顺序皆可，合并两个节点的值
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        // 最终返回构造好的 t1
        return t1;
    }
}
