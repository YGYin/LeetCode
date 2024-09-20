package round2.hot100.tree;

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
        map = new HashMap<>();
        // 用 map 储存中序数组元素出现位置，方便使用前序元素来切分中序数组
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        // 左闭又开
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    // 返回构造好的根节点
    private TreeNode build(int[] preorder, int preBegin, int preEnd,
                           int[] inorder, int inBegin, int inEnd) {
        // 不符合左闭又开时说明没有元素，返回空
        if (preBegin >= preEnd || inBegin >= inEnd)
            return null;

        // 构造根节点
        int rootVal = preorder[preBegin];
        TreeNode root = new TreeNode(rootVal);

        // 获取根节点在中序数组的位置，计算得到 lenOfLeft
        int inMidIndex = map.get(rootVal);
        int lenOfLeft = inMidIndex - inBegin;

        // 构造左子树和右子树，左闭右开
        root.left = build(preorder, preBegin + 1, preBegin + 1 + lenOfLeft,
                inorder, inBegin, inMidIndex);
        root.right = build(preorder, preBegin + 1 + lenOfLeft, preEnd,
                inorder, inMidIndex + 1, inEnd);
        return root;
    }
}
