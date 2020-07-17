package com.jd.algorithm.d15;

import java.util.*;

/*
求三个数的和为0，
 */
public class _15getSum {
    public static void main(String[] args) {
        Integer[] nums = {-1, 0, 1, -2, 2};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(Integer[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length < 3) return Collections.emptyList();
        //先对数组排序
        Arrays.sort(nums);//数组左边是实力最差的，右边是实力最强的。   [-2,-2,2,0,1,4]
        for (int i = 0; i < nums.length; i++) {//C位人选
            if (nums[i] > 0) break;//第一个数大于0，直接结束循环,
            if (i > 0 && nums[i] == nums[i - 1]) continue;//数字重复会导致结果重复，直接跳过
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    results.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++; // 去重
                    while (L < R && nums[R] == nums[R - 1]) R--; // 去重
                    //本次条件满足，查找下一个满足条件的组合
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return results;
    }
}
