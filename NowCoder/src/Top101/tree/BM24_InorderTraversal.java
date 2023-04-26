package Top101.tree;

import java.util.ArrayList;

public class BM24_InorderTraversal {
    public int[] inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(list, root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }

    private void inorder(ArrayList<Integer> list, TreeNode root) {
        if (root == null)
            return;
        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }
}
