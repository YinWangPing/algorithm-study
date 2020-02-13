/**
 * @description:给定一个二维数组，其每一行从左到右递增排序，
 * 从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 * @author: WangPingYin
 * @time: 2020/2/13 11:17
 */

public class JZOF_004 {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 8, 9, 10},
                {2, 4, 9, 12, 13},
                {4, 7, 10, 13, 17},
                {6, 8, 11, 15, 20}
        };
        int[] numbers = {-1, 1, 15, 7};
        for (int number : numbers) {
            System.out.println(""+number+"是否存在"+find0(nums, number));
            System.out.println(""+number+"是否存在"+find1(nums, number));
        }
    }
    /**
     *暴力解法遍历
     */
    public static boolean find0(int[][] matrix, int number){
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                if (matrix[i][j] == number) {
                    return true;
                }
        return false;
    }
    /**
     *从右上角或左下角开始，以右上角为例，左侧都比其小，该列下方都比其大
     * 因而判断key与该元素大小关系，若key大则往下方查找，否则往左侧查找
     */
    public static boolean find1(int[][] nums, int key) {
        int col = nums[0].length - 1, row = 0;
        while (col >= 0 && row < nums.length) {
            if (key > nums[row][col]) {
                row++;
            } else if (key < nums[row][col]) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }
}
