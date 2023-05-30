package Top101.tree;

public class BM36_IsBalanced_Solution {
    /*
        遍历每个节点，借助一个获取树深度的递归方法
        根据该节点的左右指数高度差判断是否平衡。
        然后递归地对左右子树进行判断
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null)
            return true;

        return ((Math.abs(depth(root.left) - depth(root.right)) <= 1)
                && IsBalanced_Solution(root.left)
                && IsBalanced_Solution(root.right));
    }

    private int depth(TreeNode root) {
        if (root == null)
            return 0;

        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    /*
        这种做法有很明显的问题，在判断上层结点的时候，
        会多次重复遍历下层结点，增加了不必要的开销。
        如果改为从下往上遍历，如果子树是平衡二叉树，则返回子树的高度；
        如果发现子树不是平衡二叉树，则直接停止遍历，这样至多只对每个结点访问一次
     */
    public boolean IsBalanced_Solution_2(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = getDepth(root.left);
        if (left == -1)
            return -1;
        int right = getDepth(root.right);
        if (right == -1)
            return -1;
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }
}
