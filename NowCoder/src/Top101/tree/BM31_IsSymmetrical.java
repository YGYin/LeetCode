package Top101.tree;

public class BM31_IsSymmetrical {
    /*
        终止条件：当进入子问题的两个节点都为空，说明都到了叶子节点，且是同步的，
                 因此结束本次子问题，返回true；
                 当进入子问题的两个节点只有一个为空，或是元素值不相等
                 说明这里的对称不匹配，同样结束本次子问题，返回false。
        返回值： 每一级将子问题是否匹配的结果往上传递。
        本级任务：每个子问题，需要按照上述思路
                 “根左右”走左边的时候“根右左”走右边
                 “根左右”走右边的时候“根右左”走左边
                 一起进入子问题，需要两边都是匹配才能对称。
     */
    boolean isSymmetrical(TreeNode pRoot) {
        return doubleRec(pRoot, pRoot);
    }

    boolean doubleRec(TreeNode t1, TreeNode t2) {
        // 两个都为空时树对称
        if (t1 == null && t2 == null)
            return true;
        // 只有一个为空或者节点值不同，则树不对称
        if (t1 == null || t2 == null || t1.val != t2.val)
            return false;
        // 每层对应的节点进入递归进行比较
        return doubleRec(t1.left, t2.right) && doubleRec(t1.right, t2.left);
    }
}
