package Top101.BinSearch_Sort;

public class BM18_Find {
    public boolean Find(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0)
            return false;
        int rows = array.length - 1;
        int cols = array[0].length - 1;
        // 从右上角开始，目标值更大下移指针，目标值更小左移指针
        for (int row = 0, col = cols; row <= rows && col >= 0; ) {
            if (target > array[row][col])
                ++row;
            else if (target < array[row][col])
                --col;
            else
                return true;
        }
        return false;
    }

}
