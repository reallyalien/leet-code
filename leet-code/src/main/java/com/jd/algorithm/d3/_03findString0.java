package com.jd.algorithm.d3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例 1:
 * 输入: "abcavbhbcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 *  示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class _03findString0 {

    public static void main(String[] args) {
        int length = lengthOfLongestSubstring("pwwkew");
        System.out.println(length);
    }
    /*
    滑动窗口解决
     */
    public static int lengthOfLongestSubstring(String str) {
        int len=0,max=0;
        char[] chars = str.toCharArray();
        LinkedList<Character> list = new LinkedList<Character>();
        for (int i = 0; i < chars.length; i++) {
            //如果当前list集合中已经存在此数，则记录当前list长度，删除前方一样的元素。
            len=list.size();
            int indexOf = list.indexOf(chars[i]);
            if (indexOf > -1){
                for (int j = 0; j <= indexOf; j++) {
                    //删除元素之后list的长度发生改变，会出现越界清空,因此直接删除第一个
                    list.remove(0);
                }
            }
            list.add(chars[i]);
            //判断len与max的大小
            if (len > max){
                max=len;
            }
        }
        return max;
    }
}
