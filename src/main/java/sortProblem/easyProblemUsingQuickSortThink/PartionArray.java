package sortProblem.easyProblemUsingQuickSortThink;

/*
给出一个整数数组 nums 和一个整数 k。划分数组（即移动数组 nums 中的元素），使得：
所有小于k的元素移到左边
所有大于等于k的元素移到右边
返回数组划分的位置，即数组中第一个位置 i，满足 nums[i] 大于等于 k。
 */
public class PartionArray {
    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public int partitionArray(int[] nums, int k) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] < k) {
                i++;
            } else {
                exch(nums, i, j--);
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 1};
        PartionArray partionArray = new PartionArray();
        System.out.println(partionArray.partitionArray(nums, 2));
    }
}
