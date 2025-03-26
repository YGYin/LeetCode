package round4.leetcode.trick;

public class MajorityElement_169 {
    /*
        boyer-moore 算法最简单理解方法：
            假设你在投票选人 如果你和候选人（利益）相同，你就会给他投一票（count + 1），
            如果不同，你就会踩他一下（count - 1）
            当候选人票数为 0（count = 0）时，就换一个候选人，
            但因为和你利益一样的人占比超过了一半，不论换多少次，最后留下来的都一定是个和你（利益）相同的人。
    */
    public int majorityElement(int[] nums) {
        int count = 0;
        int coordinate = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果票数为 0 了就更换候选人
            if (count == 0)
                coordinate = nums[i];
            // 如果当前这个数字和候选人相同（意见利益一致），++count
            if (nums[i] == coordinate)
                ++count;
            else
                --count;
        }
        return coordinate;
    }
}
