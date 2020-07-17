package com.jd.algorithm.d3;

import java.util.HashMap;

public class _03findString1 {
    public static void main(String[] args) {
        int length = lengthOfLongestSubstring("pwwkew");
        System.out.println(length);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                //left指左侧有效数字的起始下标，如果有相同的元素，则获取之前已经出现的元素的下标+1，相当于删掉之前已经存在元素之前的所有元素。
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            //如果包含则更新其下标，用于计算有效长度。
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}
