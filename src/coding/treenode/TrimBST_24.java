package coding.treenode;

public class TrimBST_24 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return traversal(root, low, high);
    }

    private TreeNode traversal(TreeNode root, int low, int high) {
        if (root == null)
            return null;

        // 终止条件从边界出发考虑
        // 1. 当前节点值小于左边界
        //    - 其左子树一定也小于左边界，所以不用处理
        //    - 右子树可能存在处于范围内的节点，但不一定都符合，
        //      所以要返回已经被修剪的右子树，不能直接 return root.right
        if (root.val < low)
            return traversal(root.right, low, high);
        // 2. 当前节点值大于右边界时同理，返回修剪好的左子树
        if (root.val > high)
            return traversal(root.left, low, high);

        // 返回给上一层后的处理逻辑，分别把修剪好的左子树和右子树返回给父节点
        root.left = traversal(root.left, low, high);
        root.right = traversal(root.right, low, high);
        return root;
    }
}
