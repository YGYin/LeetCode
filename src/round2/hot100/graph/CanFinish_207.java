package round2.hot100.graph;

import java.util.*;

public class CanFinish_207 {
    /*
        课程表
        numCourses 必须选修的课程数，prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则必须先学习课程 bi
        根据依赖关系将其转换为有向无环图，观察其出入度，利用 bfs，看是否最后入度全都为 0（课程数减为 0）
        1. 让入度为 0 的课程全部进入队列，这些课没有需要学习的前置课程
        2. 元素逐个出列，代表该课程被选，出队列时需减小该元素相关后续课的入读
        3. 看是否有入度为 0 的课程，有的话就入队列，直到没有入度为 0 的元素

        需要记录：
        1. 需要记录一门课的后序课，key: 当前课的序号  val: List<Integer>: 其后续课的序号
        2. 每门课的入度，inDegree[] 下标为课的序号
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 记录后续课
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree = new int[numCourses];
        // 遍历前置课数组来记录每门课的入度以及其后续课程的依赖关系
        for (int i = 0; i < prerequisites.length; i++) {
            // 出现在 pre[i][0] 这代表其有先修课，入度 ++
            inDegree[prerequisites[i][0]]++;
            List<Integer> list = map.getOrDefault(prerequisites[i][1], new ArrayList<>());
            list.add(prerequisites[i][0]);
            map.put(prerequisites[i][1], list);
        }

        // 接着将 入度为 0 的课程加入到队列
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++)
            if (inDegree[i] == 0)
                queue.offer(i);

        // 将队列元素逐个出列，代表该课程被选，出队列时需减小该元素相关后续课的入读
        while (!queue.isEmpty()) {
            // 修读了该课程，课程数需要减少
            int curCourse = queue.poll();
            --numCourses;
            // 通过 map 去获取其后续课，然后减少他们后续课的入度
            List<Integer> nextCourses = map.getOrDefault(curCourse, new ArrayList<>());
            for (int i = 0; i < nextCourses.size(); i++) {
                int nextCourse = nextCourses.get(i);
                // 扣减入度，如果入度为 0 则加入到队列中
                if (--inDegree[nextCourse] == 0)
                    queue.offer(nextCourse);
            }
        }

        // 最后判断还需要修的必修课是否为 0
        return numCourses == 0;
    }
}
