package round2.tree;

import java.util.HashMap;
import java.util.Map;

public class BuildTree_105 {
    /*
        从前序与中序遍历序列构造二叉树
        中序: 左中右  前序：中左右
        1. 根据前序数组的首个元素来构造根节点，确定根节点在中序数组的位置
        2. 根据根节点在中序数组的位置，得到中序数组中的左区间长度
        3. 通过该左区间长度来切分前序数组的左子树区间和右子树区间
        4. 递归分别构造左子树和右子树
     */
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 判断前序数组长度，只有一个则返回
        if (preorder.length == 1)
            return new TreeNode(preorder[0]);
        // 为方便通过根节点的值来划分中序数组，需要记录中序数组元素和下标的关系
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode build(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        // 不符合左闭右开时说明没有元素，返回空树
        if (preBegin >= preEnd || inBegin >= inEnd)
            return null;

        // 通过前序数组的首个元素构造根节点
        TreeNode root = new TreeNode(preorder[preBegin]);
        // 找到中序数组中根节点的下标
        int rootIndex = map.get(root.val);
        // 得到中序数组的左子树区间长度
        int lenOfLeft = rootIndex - inBegin;

        // 递归构造左右子树，左闭右开
        root.left = build(preorder, preBegin + 1, preBegin + 1 + lenOfLeft,
                inorder, inBegin, rootIndex);
        root.right = build(preorder, preBegin + 1 + lenOfLeft, preEnd,
                inorder, rootIndex + 1, inEnd);

        return root;
    }
}
