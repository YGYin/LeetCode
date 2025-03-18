package round4.leetcode.tree;

public class SortedArrayToBST_108 {
    /*
        将有序数组转换为二叉搜索树
        通过二分法来构造二叉树，每次使用 nums[mid] 来构造根节点，
        然后再划分左右区间范围来构造左子树和右子树
        与通过中序后序数组来构造二叉树不同的是，该题为有序数组，不需要记录元素的分布情况来切数组
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length < 1)
            return new TreeNode();
        // 左闭右开
        return buildTree(nums, 0, nums.length);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        // 左闭右开
        if (left <= right)
            return null;

        // 构造根节点
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        // 构造左右子树
        root.left = buildTree(nums, left, mid);
        root.right = buildTree(nums, mid + 1, right);

        return root;
    }
}
