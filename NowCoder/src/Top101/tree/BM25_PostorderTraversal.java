package Top101.tree;

import java.util.ArrayList;

public class BM25_PostorderTraversal {
    public int[] postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        postOrder(list, root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }

    private void postOrder(ArrayList<Integer> list, TreeNode root) {
        if (root == null)
            return;
        postOrder(list, root.left);
        postOrder(list, root.right);
        list.add(root.val);
    }
}
