public class Rotate_189 {
    /*
        1. To reverse Array nums;
        2. To reverse K elements at the left, [0, k-1];
        3. To reverse remain elements;
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    void reverse(int[] nums, int begin, int end) {
        int temp;
        while (begin < end) {
            temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            ++begin;
            --end;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1};
        Rotate_189 rotateTest = new Rotate_189();
        rotateTest.rotate(arr, 2);
    }
}
