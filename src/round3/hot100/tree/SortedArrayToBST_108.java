package round3.hot100.tree;

public class SortedArrayToBST_108 {
    /*
        将有序数组转换为二叉搜索树
        通过二分法构造二叉树，因为数组已经排序，不需要额外使用 map 记录数组元素及下标
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        // 左闭右开
        return buildBST(nums, 0, nums.length);
    }

    // 传入数组，左闭右开，返回构造的根节点
    private TreeNode buildBST(int[] nums, int left, int right) {
        // 不满足左闭右开时说明没办法再划分，返回空
        if (left >= right)
            return null;

        // 构造根节点
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        // 分别接住左右子节点，区间左闭右开
        root.left = buildBST(nums, left, mid);
        root.right = buildBST(nums, mid + 1, right);

        // 返回根节点
        return root;
    }
}
