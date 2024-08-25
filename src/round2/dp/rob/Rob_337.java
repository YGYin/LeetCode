package round2.dp.rob;

import round2.tree.TreeNode;

public class Rob_337 {
    /*
        打家劫舍 III
        变成二叉树，可以定义一个大小为 2 的数组来标记状态，
            对于当前节点: 0 不偷 1 偷
        1. 求一个偷或者不偷所得到的最大金钱 res[0] res[1]
            dp 实际就为一个长度为 2 的数组
        2. 递推公式:
            偷当前节点的最大金额:
                当前节点金额 + 左孩子选择不偷的最大金额 + 右孩子选择不偷的最大金额
                robVal = root.val + left[0] + right[0];
            不偷当前节点的最大金额:
                左孩子选择偷或不偷的最大金额 + 右孩子选择偷或不偷的最大金额
                unRobVal = max(left[0], left[1]) + max(right[0], right[1]);
            max(偷当前节点的最大金额, 不偷当前节点的最大金额)
     */
    public int rob(TreeNode root) {
        // 返回的也为一个数组
        // res[0] 不偷当前 root 节点，res[1] 偷当前节点
        int[] res = robbing(root);
        return Math.max(res[0], res[1]);
    }

    // 传入当前节点，返回表示当前点状态的长度为 2 的状态数组
    private int[] robbing(TreeNode root) {
        // 终止条件：遇到空节点则偷不偷都为 0
        if (root == null)
            return new int[]{0, 0};
        // 因为要得到返回值来做计算，使用后序遍历，左右中
        // 获得左右所能偷到的最大金额
        int[] leftVal = robbing(root.left);
        int[] rightVal = robbing(root.right);
        // 中，类似于构造根节点的值
        // 不偷当前节点: 左子节点的最大值加上右子节点的最大值
        int unRobRoot = Math.max(leftVal[0], leftVal[1]) + Math.max(rightVal[0], rightVal[1]);
        // 偷当前节点: 当前节点值，加上不偷左子节点和不偷右子节点
        int robRoot = root.val + leftVal[0] + rightVal[0];

        return new int[]{unRobRoot, robRoot};
    }
}
