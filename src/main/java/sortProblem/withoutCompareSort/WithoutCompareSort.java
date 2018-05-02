package sortProblem.withoutCompareSort;

/*
 *
 * */
public class WithoutCompareSort {

    public static int maxGap(int[] num) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = num.length;
        for (int i = 0; i < len; i++) {
            min = Math.min(num[i], min);  //找出数组中的最小值
            max = Math.max(num[i], max);   //找出数组中的最大值
        }
//        如果数组中只有一个数 那最大间隔就是0
        if (max == min)
            return 0;
//        定义len+1个桶， 那么必存在一个空桶，bucket 决定将数放入哪个桶中
//        桶中是否有数据
        boolean[] hasNum = new boolean[len + 1];
//        桶中存放的最小值
        int[] mins = new int[len + 1];
//        桶中存放的最大值
        int[] maxs = new int[len + 1];

        for (int i = 0; i < len; i++) {
            int bid = bucket(num[i], len, min, max);

            mins[bid] = hasNum[bid] ? Math.min(num[i], mins[bid]) : num[i];
            maxs[bid] = hasNum[bid] ? Math.max(num[i], maxs[bid]) : num[i];
            hasNum[bid] = true;
           /* if (!hasNum[bid]) {
                hasNum[bid] = true;
                mins[bid] = maxs[bid] = num[i];
            } else {
                mins[bid] = Math.min(num[i], mins[bid]);
                maxs[bid] = Math.max(num[i], maxs[bid]);
            }*/
        }

        int res = 0;
        int lastMax = maxs[0];
        for (int i = 0; i <= len; i++) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    public static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }

    public static void main(String[] args) {
        int[] num = {1, 3, 7};
        System.out.println(WithoutCompareSort.maxGap(num));
    }

}
