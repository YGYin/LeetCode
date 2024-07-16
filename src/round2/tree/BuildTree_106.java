package round2.tree;

import java.util.HashMap;
import java.util.Map;

public class BuildTree_106 {
    /*
        从中序与后序遍历序列构造二叉树
        中序：左中右  后序：左右中
        1. 先通过后序数组的最后一个节点，构造根节点，得知根节点在中序数组的位置
        2. 根据根节点的位置在中序数组中切割得到左子树元素个数(左区间长度)
        3. 通过中序数组的左区间长度，划分后序数组的左右区间
        4. 分别递归构造左子树和右子树
     */

    // key: 中序数组元素值  val: 元素下标
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 因为输入的数组都由不同值组成的合法数组，且最少有一个元素
        // 只对后序数组特判
        if (postorder.length == 1)
            return new TreeNode(postorder[0]);
        // 因为需要通过后序数组的最后一个元素，来找到中序数组中的根节点
        // 需要记录中序数组的根节点和下标的关系
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        return build(inorder, 0, inorder.length, postorder,
                0, postorder.length);
    }

    // 1. 返回构造好的二叉树的根节点，传入中序后序数组，以及起始和末尾下标(左闭右开)
    private TreeNode build(int[] inorder, int inBegin, int inEnd,
                           int[] postorder, int postBegin, int postEnd) {
        // 结束条件: 不符合左闭右开时说明没有元素
        if (inBegin >= inEnd || postBegin >= postEnd)
            return null;

        // 先通过后序数组最后一个元素构造根节点
        TreeNode root = new TreeNode(postorder[postEnd - 1]);
        // 找到根节点在中序数组中的位置
        int rootIndex = map.get(root.val);
        // 从而划分中序数组，得到左子树元素个数(左区间长度)
        int lenOfLeft = rootIndex - inBegin;

        // 递归构造左右子树，左闭右开
        root.left = build(inorder, inBegin, rootIndex,
                postorder, postBegin, postBegin + lenOfLeft);
        root.right = build(inorder, rootIndex + 1, inEnd,
                postorder, postBegin + lenOfLeft, postEnd - 1);

        return root;
    }
}
