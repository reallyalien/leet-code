package com.jd.algorithm.d14;

/*
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。
 */
public class _14 {
    public static void main(String[] args) {
        String[] strs={"ab","acc","aba"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String ans = strs[0];
        String min=ans;//初始化一下
        for(int i =1;i<strs.length;i++) {
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            //一个数循环结束，先保留一下最长的公共前缀
            String result = ans.substring(0, j);
            //需要获取最短的字符串才能找出符合条件的公共前缀
            min= result.length() > min.length() ? min : result;
        }
        return min;
    }
}
