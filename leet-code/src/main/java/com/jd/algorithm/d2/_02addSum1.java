package com.jd.algorithm.d2;

import java.util.Collections;
import java.util.LinkedList;

/**
 * 从链表起始位置开始，获取链表的同位置元素进行相加，并同时处理进位情况，
 * 需考虑两个链表的长度不一致的情况
 */
public class _02addSum1 {
    public static void main(String[] args) {

        LinkedList<Integer> list1=new LinkedList<Integer>();
        list1.push(3);
        list1.push(4);
        list1.push(2);
        list1.push(2);
        list1.push(2);

        LinkedList<Integer> list2=new LinkedList<Integer>();
        list2.push(4);
        list2.push(6);
        list2.push(5);
        list2.push(5);
        LinkedList<Integer> numbers = addTwoNumbers(list1, list2);
        System.out.println(numbers);
    }

    public static LinkedList<Integer> addTwoNumbers(LinkedList<Integer> list1, LinkedList<Integer> list2){
        LinkedList<Integer> newList=new LinkedList<Integer>();
        int carry=0;
        //判断哪个链表长度小
        int min = Math.min(list1.size(), list2.size());
        int bitSum=0;
        for (int i = 0; i < min; i++) {
            Integer i1 = list1.get(i);
            Integer i2 = list2.get(i);
            bitSum=i1+i2+carry;
            if (bitSum > 9){
                carry=1;
                int i3 = bitSum % 10;
                newList.add(i3);
            }else {
                newList.add(bitSum);
            }
            //最后一轮循环，长度小的已经计算完毕
            if (i==list1.size()-1){
                while (++i < list2.size()){
                    newList.add(list2.get(i));
                }
            }else if (i==list2.size()-1){
                while (++i<list1.size()){
                    newList.add(list1.get(i));
                }
            }
        }
        return newList;
    }
}
