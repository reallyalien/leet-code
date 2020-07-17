package com.jd.algorithm.d16;

import java.util.Arrays;

/**
 * 给定一个包括n个整数的数组nums和一个目标值 target。找出nums中的三个整数，使得它们的和与arget最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * Math
 */
public class _16Sum {
    public static void main(String[] args) {
        int[] nums={-1,2,1,-4};
        System.out.println(threeSumClosest(nums,1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        //对所需要的数组进行排序
        Arrays.sort(nums);
        int result=0;//需要返回的结果
        int c=Integer.MAX_VALUE;//这是target与目标结果的差，最大
        int L=0;
        int R=0;
        for (int i = 0; i < nums.length; i++) {
            L=i+1;
            R=nums.length-1;
            while (L < R){
                int sum=nums[i]+nums[L]+nums[R];
                int difference=Math.abs(target-sum);
                while (L < R && nums[L] == nums[L+1]) L++;
                while (L < R && nums[R] == nums[R-1]) R--;
                c = Math.min(difference, c);
                result=sum;//将和保存到result中返回
                //下一次循环的开始条件
                L++;
                R--;
            }
        }
        return result;
    }
}
