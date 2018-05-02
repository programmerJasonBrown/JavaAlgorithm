package sortProblem.sumProblem;

import java.util.List;

public class ThreeCloseSum {
    public int threeSumClosest(int[] numbers, int target) {
        threePartition(numbers, 0, numbers.length - 1);
        int numbersLength = numbers.length;
        int lo = 0;
        int sumMostClose = Integer.MAX_VALUE;
        while (lo < numbersLength - 2) {
            int mid = lo + 1;
            int hi = numbersLength - 1;
            while(mid<hi){
                int sum = numbers[lo] + numbers[mid] + numbers[hi];
                if(Math.abs(sumMostClose-target)>Math.abs(sum-target)){
                    sumMostClose = sum;
                }
                if (sum == target)
                    return sum;
                else if(sum>target){
                    hi--;
                    while(numbers[hi]==numbers[hi+1]&&hi>mid)
                        hi--;
                } else if(sum<target){
                    mid++;
                    while(numbers[mid]==numbers[mid-1]&&mid<hi)
                        mid++;
                }
            }
            lo++;
            while(numbers[lo]==numbers[lo-1]&&lo<numbersLength-1)
                lo++;
        }
        return sumMostClose;
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
        ThreeCloseSum closeSum = new ThreeCloseSum();
        int[] nums = {1,0,-1,-1,-1,-1,0,1,1,1,2};
        int sum = closeSum.threeSumClosest(nums,7);
        System.out.println(sum);
    }
}
