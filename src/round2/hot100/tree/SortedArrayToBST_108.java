package round2.hot100.tree;

public class SortedArrayToBST_108 {
    /*
        将有序数组转换为二叉搜索树
        通过二分法来构造二叉树，每次使用 nums[mid] 来构造根节点，
        然后再划分左右区间范围来构造左子树和右子树
        与通过中序后序数组来构造二叉树不同的是，该题为有序数组，不需要记录元素的分布情况来切数组
     */

    public TreeNode sortedArrayToBST(int[] nums) {
        // 左闭又开
        return buildBST(nums, 0, nums.length);
    }

    // 返回构造好的树的根节点，传入左区间和右区间
    private TreeNode buildBST(int[] nums, int left, int right) {
        // 如果不满足左闭右开，说明没有元素，返回空
        if (left >= right)
            return null;

        // 根据 nums[mid] 来构造根节点
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, left, mid);
        root.right = buildBST(nums, mid + 1, right);
        return root;
    }
}
