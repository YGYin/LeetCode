package round4.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class BuildTree_105 {
    /*
        从前序与中序遍历序列构造二叉树
        需要用 map 记录下中序数组的元素和对应出现下标，方便切分
        1. 先获取前序数组中的首元素构造根节点
        2. 获取到 map 中中序数组根节点位置，切分中序数组，进而得到 lenOfLeft
        3. 再用中节点位置和 lenOfLeft 来切分前序数组
        4. 分别向左右递归切分两个数组构造子树
     */
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 记录中序数组的元素和对应出现下标，方便切分
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        // 左闭又开
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {
        // 不符合左闭右开则返回
        if (preStart >= preEnd || inStart >= inEnd)
            return null;

        // 使用前序数组构造根节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        // 用该根节点的值通过 map 找到其在中序数组的位置，用于计算 lenOfLeft 切分中序数组
        int inMidIndex = map.get(root.val);
        int lenOfLeft = inMidIndex - inStart;
        // 左闭右开
        root.left = build(preorder, preStart + 1, preStart + 1 + lenOfLeft,
                inorder, inStart, inMidIndex);
        root.right = build(preorder, preStart + 1 + lenOfLeft, preEnd,
                inorder, inMidIndex + 1, inEnd);

        return root;
    }
}
