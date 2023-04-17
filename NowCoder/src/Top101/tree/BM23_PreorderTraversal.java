package Top101.tree;

import java.util.ArrayList;

public class BM23_PreorderTraversal {

    public int[] preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preOrder(list, root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);

        return res;
    }

    private void preOrder(ArrayList<Integer> list, TreeNode root) {
        if (root == null)
            return;
        // 先遍历根节点，再左子树到右子树
        list.add(root.val);
        preOrder(list, root.left);
        preOrder(list, root.right);
    }

}
