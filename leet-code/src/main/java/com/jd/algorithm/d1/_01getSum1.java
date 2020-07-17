package com.jd.algorithm.d1;

import java.util.Arrays;

public class _01getSum1 {

    public static int[] twosum(int[] nums,int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j=1;j < nums.length-1 && j!=i;j++){
                int compare=target-nums[i];
                if (nums[j]==compare){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums={2,7,8,10};
        int target=18;
        System.out.println(Arrays.toString(twosum(nums, target)));
    }
}
