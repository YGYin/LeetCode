package round1.hot100.tree;

import java.util.HashMap;
import java.util.Map;

public class BuildTree_105 {
    // k: 元素值   v: 中序数组元素下标
    Map<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 记录中序数组元素及其下标，方便后续切分中序数组
        for (int i = 0; i < inorder.length; i++)
            inMap.put(inorder[i], i);

        // 左闭右开
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    // 返回构建好的树的根节点，传入两个数组及其范围，左闭右开
    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        // 如果不满足左闭右开，则子树为空
        if (inStart >= inEnd || preStart >= preEnd)
            return null;

        // 先根据前序数组的首节点获取到根节点在中序数组的位置，构造根节点
        int rootIndex = inMap.get(preorder[preStart]);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        // 需要记录中序数组中左边节点数，方便对前序数组进行切割
        int lenOfLeft = rootIndex - inStart;
        // 构造根节点的左右子树
        // 左子树 = build(左前序，左中序)
        root.left = build(preorder, preStart + 1, preStart + 1 + lenOfLeft, inorder, inStart, rootIndex);
        // 右子树 = build(右前序，右中序)
        root.right = build(preorder, preStart + 1 + lenOfLeft, preEnd, inorder, rootIndex + 1, inEnd);

        return root;
    }
}
