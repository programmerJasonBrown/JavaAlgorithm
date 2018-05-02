package test4;

/*
Classic binary search problem.

Looking at subarray with index [start,end]. We can find out that if the first member is less than the last member, there's no rotation in the array. So we could directly return the first element in this subarray.

If the first element is larger than the last one, then we compute the element in the middle, and compare it with the first element. If value of the element in the middle is larger than the first element, we know the rotation is at the second half of this array. Else, it is in the first half in the array.

Welcome to put your comments and suggestions.
* */
public class Test4 {
    public int myMethodFindMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start < end) {
            if (nums[start] < nums[end])
                return nums[start];
            mid = (start + end) / 2;
            if (nums[mid] >= nums[start])
                start = mid + 1;
            else
                end = mid;
        }
        return nums[start];
    }


    /*
    * Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.*/
    public int myMethodFindMinWithDuplicates(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start < end) {
            while (nums[start] == nums[end] && start != end)
                end--;
            if (nums[start] < nums[end])
                return nums[start];
            mid = (start + end) / 2;
            if (nums[mid] >= nums[start])
                start = mid + 1;
            else
                end = mid;
        }
        return nums[start];
    }
}
