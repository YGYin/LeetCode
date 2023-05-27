package Top101.tree;

public class BM33_Mirror {
    /*
        自底向上对每两个相对位置的节点交换位置，这样往上各个子树也会被交换位置。
        step 1：先深度最左端的节点，遇到空树返回，处理最左端的两个子节点交换位置。
        step 2：然后进入右子树，继续按照先左后右再回中的方式访问。
        step 3：再返回到父问题，交换父问题两个子节点的值。
     */
    public TreeNode Mirror(TreeNode pRoot) {
        if (pRoot == null)
            return null;
        // 递归到最左端和最右端节点
        TreeNode left = Mirror(pRoot.left);
        TreeNode right = Mirror(pRoot.right);
        // 交换节点
        pRoot.left = right;
        pRoot.right = left;
        return pRoot;
    }
}
