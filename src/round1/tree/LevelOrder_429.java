package round1.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder_429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        // 辅助队列
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 获得每层元素数量，新建 rowList 储存每层元素数值
            int qSize = queue.size();
            List<Integer> rowList = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                Node curNode = queue.poll();
                rowList.add(curNode.val);
                // 获取当前节点的子节点列表，判空
                List<Node> children = curNode.children;
                if (children == null || children.isEmpty())
                    continue;
                // 子节点列表不为空，遍历列表将子节点加入到队列中
                for (int index = 0; index < children.size(); index++)
                    queue.offer(children.get(index));
            }
            res.add(rowList);
        }
        return res;
    }
}
