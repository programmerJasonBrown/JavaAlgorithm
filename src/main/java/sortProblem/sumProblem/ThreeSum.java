package sortProblem.sumProblem;

import java.util.ArrayList;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] numbers) {
        threePartition(numbers, 0, numbers.length - 1);//快速排序
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> listsThree = new ArrayList<List<Integer>>();
        for (int x : numbers) {
            list.add(x);
        }
        int lo = 0;
        int hi;
        while (lo < numbers.length - 2) {
            int compliment1 = -numbers[lo];
            hi = lo + 1;
            list.set(lo, null);
            while (hi < numbers.length - 1) {
                int compliment2 = compliment1 - numbers[hi];
                if (list.contains(compliment2) && list.lastIndexOf(compliment2) > hi) {
                    List<Integer> listThree = new ArrayList<Integer>();
                    listThree.add(numbers[lo]);
                    listThree.add(numbers[hi]);
                    listThree.add(compliment2);
                    listsThree.add(listThree);
                }

                hi++;
                while (numbers[hi] == numbers[hi - 1] && hi < numbers.length - 1) {
                    hi++;
                }

            }
            lo++;
            while (numbers[lo] == numbers[lo - 1] && lo < numbers.length - 2) {
                lo++;
            }
        }
        return listsThree;

    }


    public List<List<Integer>> threeSumMethod2(int[] numbers) {
        threePartition(numbers, 0, numbers.length - 1);//快速排序
        List<List<Integer>> listsThree = new ArrayList<List<Integer>>();
        int lo = 0;
        while (lo < numbers.length - 2) {
            int mid = lo + 1;
            int hi = numbers.length - 1;
            while (mid < hi) {
                int sum = numbers[lo] + numbers[mid] + numbers[hi];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(numbers[lo]);
                    list.add(numbers[mid]);
                    list.add(numbers[hi]);
                    listsThree.add(list);
                    mid++;
                    while (numbers[mid] == numbers[mid - 1] && mid < hi)
                        mid++;
                }
                if (sum > 0) {
                    hi--;
                    while (numbers[hi] == numbers[hi + 1] && hi > mid)
                        hi--;
                }
                if (sum < 0) {
                    mid++;
                    while (numbers[mid] == numbers[mid - 1] && mid < hi)
                        mid++;
                }

            }
            lo++;
            while (numbers[lo] == numbers[lo - 1] && lo < numbers.length - 1)
                lo++;
        }
        return listsThree;

    }


    public void threePartition(int[] numbers, int lo, int hi) {
        if (lo >= hi)
            return;
        int v = numbers[lo];
        int lt = lo;
        int i = lo + 1;
        int gt = hi;
        while (i <= gt) {
            if (numbers[i] < v) {
                exch(numbers, i, lt++);
            } else if (numbers[i] == v) {
                i++;
            } else {
                exch(numbers, i, gt--);
            }
        }
        threePartition(numbers, lo, lt - 1);
        threePartition(numbers, gt + 1, hi);
    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-1,1,0};
        List<List<Integer>> lists = threeSum.threeSumMethod2(nums);
        System.out.println(lists);
    }
}
