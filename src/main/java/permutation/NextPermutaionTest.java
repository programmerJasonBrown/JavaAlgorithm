package permutation;

public class NextPermutaionTest {

    /*
    给定一个若干整数的排列，给出按正数大小进行字典序从小到大排序后的下一个排列。
    如果没有下一个排列，则输出字典序最小的序列。
    左边是原始排列，右边是对应的下一个排列。
    1,2,3 → 1,3,2
    3,2,1 → 1,2,3
    1,1,5 → 1,5,1

    解答思路例子
    8, 5, 3, 7, 6, 5, 4, 1   -> 8, 5, 4, 1, 3, 5, 6, 7
    第一步从右往前走，找到第一个不是升序的数，这里是3
    在从3往右数找到最后一个比3大的数，将该数和3互换
    将该数后面的数从左到右升序排列。
    特殊情况： 一个数的时候直接返回， 从左到右是全降序的时候，返回它的逆序列。
*/
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            System.out.println(nums[0]);
            return;
        }
        int needSwapOrder = 0;
        int needSwapTargetOrder = 0;
        int i = 0;
        for (i = n - 1; i > 0; i--) {
            if (nums[i] <= nums[i - 1]) {  //找到前一个数比后一个数小的
                continue;
            } else {
                needSwapOrder = i - 1;
                //找到要交换的序号
                for (int j = i; j < n; j++) {
                    if (nums[j] <= nums[needSwapOrder]) {
                        needSwapTargetOrder = j - 1;
                        break;
                    }
                    if (j == n - 1) {
                        needSwapTargetOrder = j;
                    }
                }
                System.out.println("needSwapOrder = nums["+ needSwapOrder +"] = "+nums[needSwapOrder]);
                //交换
                System.out.println("needSwapTargetOrder = nums["+ needSwapTargetOrder +"] = "+nums[needSwapTargetOrder]);
                int temp = nums[needSwapTargetOrder];
                nums[needSwapTargetOrder] = nums[needSwapOrder];
                nums[needSwapOrder] = temp;
                break;
            }
        }
        for (int x : nums) {
            System.out.print(x);
        }
        System.out.println("\n=======");
        //排序
        for (int j = i, k = n - 1; j < k; j++, k--) {
            int temp = nums[j];
            nums[j] = nums[k];
            nums[k] = temp;
        }
        for (int x : nums) {
            System.out.print(x);
        }
    }

    public static void main(String[] args) {
        int[] nums = {6,7,5,3,5,6,2,9,1,2,7,0,9};
        NextPermutaionTest.nextPermutation(nums);
    }
}
