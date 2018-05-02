package sortProblem.testorCreatArrary;

import java.util.Arrays;

/*
 * 对数器
 * 生成随机数
 * */
public class ArrayCreator {
    //自己的方法
    public static void sort(int[] arr, int lo, int hi) {
        if (lo >= hi)
            return;
        int lt = lo;
        int gt = hi;
        int i = lt + 1;
        int v = arr[lo];
        while (i <= gt) {
            if (arr[i] < v)
                exch(arr, i++, lt++);
            else if (arr[i] == v)
                i++;
            else if (arr[i] > v)
                exch(arr, i, gt--);
        }
        sort(arr, lo, lt - 1);
        sort(arr, gt + 1, hi);
    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    //一个绝对正确的方法
    public static void rightMethod(int[] arr) {
        Arrays.sort(arr);
    }

    //判断两个数组是否相同
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null))
            return false;
        if (arr1 == null && arr2 == null)
            return true;
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    //随机数组生成器
    public static int[] generateRandomArray(int size, int value) {
        //产生数组长度是[0,size]
        int[] arr = new int[(int) ((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            //产生数数组中的数的范围是-value ~ value  因为（int）向下取整
            arr[i] = (int) ((value + 1) * Math.random()) - (int) (value * Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr1) {
        int[] arr2 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
        return arr2;
    }

    public static void main(String[] args) {
        //testTime是测试次数
        int testTime = 500000;
        int size = 10;
        int value = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(size, value);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            sort(arr1, 0, arr1.length - 1);
            rightMethod(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
            }
        }

        System.out.println(succeed ? "success" : "fucking fucked!");
    }

}
