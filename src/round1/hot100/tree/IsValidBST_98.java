package round1.hot100.tree;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST_98 {
    List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        // 验证二次搜索树
        // 利用二叉搜索树性质：中序遍历的时候为升序数组
        traversal(root);
        for (int i = 0; i < list.size() - 1; i++)
            if (list.get(i) >= list.get(i + 1))
                return false;

        return true;
    }

    private void traversal(TreeNode root) {
        if (root == null)
            return;

        traversal(root.left);
        list.add(root.val);
        traversal(root.right);
    }
}
