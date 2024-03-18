package round1.tree;

import java.util.HashMap;
import java.util.Map;

public class BuildTree_106 {
    // 需要 map 记录中序数组元素位置
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        // 注意左闭右开
        return build(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    // 确定返回值为构造完的树的根节点，参数为中序和后序数组，切割区间
    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        // 中序数组开始无法确定中节点
        // 后序数组最后一个元素一定是开始的中间节点
        // 通过确定了中序数组的中间节点，划分出了中序数组的左右区间
        // 划分后序数组的左右区间，再通过后序数组的左右区间来得到中序数组中的中节点

        // 终止条件：1. 不满足左闭右开，说明子树没有元素，返回空树
        if (inStart >= inEnd || postStart >= postEnd)
            return null;

        // 2. 后序数组中最后一个元素为中间节点元素，构造根节点
        int midPtVal = postorder[postEnd - 1];
        TreeNode root = new TreeNode(midPtVal);
        // 3. 切割中序数组，通过 Map 找到中序找切割点
        //     同时记录保存左中序子树个数，便于切割后序数组
        int cutIdx = map.get(root.val);
        int lenOfLeft = cutIdx - inStart;
        // 4. 切割后序数组
        // 切割点：用中序数组的切割好的左区间大小来切后序
        // 5. 递归处理左右区间构建二叉树
        // root.left = traversal(左中序，左后序)
        root.left = build(inorder, inStart, cutIdx, postorder, postStart, postStart + lenOfLeft);
        // root.right = traversal(右中序，右后序)
        // 左闭右开，且最后一个元素为中节点，不属于后序的右区间
        root.right = build(inorder, cutIdx + 1, inEnd, postorder, postStart + lenOfLeft, postEnd - 1);
        // 二叉树构建完成，返回
        return root;
    }
}
