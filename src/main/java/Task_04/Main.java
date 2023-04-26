package Task_04;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 5, 8};
        int[] nums2 = {3, 4, 6, 9, 10};
        int[] nums3 = {3, 4, 6, 9};
//        int[] nums3 = null;
        System.out.println("answer = " + findMedianSortedArrays(nums1, nums2));
        System.out.println("answer = " + findMedianSortedArrays(nums1, nums3));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return -1;
        int[] newArray = new int[nums1.length + nums2.length];
        for (int i = 0; i < (nums1.length + nums2.length); i++) {
            if (i < nums1.length) newArray[i] = nums1[i];
            else newArray[i] = nums2[i - nums1.length];
        }
        Arrays.sort(newArray);
        System.out.println(Arrays.toString(newArray));
        if (newArray.length % 2 != 0) return newArray[newArray.length/2];
        else {
            return (newArray[newArray.length/2 - 1] + newArray[newArray.length/2])/2.0;
        }
    }
}

/*
4. Median of Two Sorted Arrays
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.


Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
 */