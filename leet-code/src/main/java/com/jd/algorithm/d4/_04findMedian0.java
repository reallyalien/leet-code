package com.jd.algorithm.d4;

import java.util.Arrays;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 *
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class _04findMedian0 {
    public static void main(String[] args) {
        int[] num1 = {1, 3, 5};
        int[] num2 = {2, 5, 8};
        double v = findMedianSortedArrays(num1, num2);
        System.out.println(v);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] newInt = new int[nums1.length + nums2.length];
        System.arraycopy(nums1,0,newInt,0,nums1.length);
        System.arraycopy(nums2,0,newInt,nums1.length,nums2.length);
        Arrays.sort(newInt);
        int len = newInt.length;
        double median=0;
        if (len % 2 == 0){
            median = (newInt[(len >> 1) - 1] + newInt[len >> 1]) / 2.0;
        }else {
            median=newInt[len >> 1];
        }
        return median;
    }
}
