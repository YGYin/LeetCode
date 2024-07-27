package round2.tree;


public class SortedArrayToBST_108 {
    /*
        将有序数组转换为平衡二叉搜索树
        通过二分法来构造二叉树，每次使用 nums[mid] 来构造根节点，
        然后再划分左右区间范围来构造左子树和右子树
        与通过中序后序数组来构造二叉树不同的是，该题为有序数组，不需要记录元素的分布情况来切数组
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        // 因为数组长度最少为 1，未对数组特判
        return buildBST(nums, 0, nums.length);
    }

    // 1. 返回构造好的根节点，传入数组以及左右边界(左闭右开)
    private TreeNode buildBST(int[] nums, int left, int right) {
        // 不符合左闭右开时说明没有剩余元素，返回空
        if (left >= right)
            return null;
        // 用 nums[mid] 构造根节点
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        // 构造左右节点，左闭右开
        root.left = buildBST(nums, left, mid);
        root.right = buildBST(nums, mid + 1, right);
        // 返回构造好的根节点
        return root;
    }
}
