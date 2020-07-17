package com.jd.algorithm.d1;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
public class _01getSum0 {
    public static int[] twosum(int[] nums,int target){
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int compare=target-nums[i];
            if (map.containsKey(compare)){
                return new int[]{map.get(compare),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("没有找到相应的数据");
    }

    public static void main(String[] args) {
        int[] nums={2,7,8,10};
        int target=18;
        System.out.println(Arrays.toString(twosum(nums, target)));
    }
}
