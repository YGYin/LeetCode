package round2.hot100.others;

public class MajorityElement_169 {
    /*
        boyer-moore算法最简单理解方法：
            假设你在投票选人 如果你和候选人（利益）相同，你就会给他投一票（count + 1），
            如果不同，你就会踩他一下（count - 1）
            当候选人票数为 0（count = 0）时，就换一个候选人，
            但因为和你利益一样的人占比超过了一半，不论换多少次，最后留下来的都一定是个和你（利益）相同的人。
    */
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果票数为 0 则换候选人
            if (count == 0)
                candidate = nums[i];
            // 看当前这个数字是否为 candidate
            if (nums[i] == candidate)
                ++count;
            else
                --count;
        }
        return candidate;
    }
}
