package com.jd.algorithm.d2;

import java.util.LinkedList;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class _02addSum0 {
    public static void main(String[] args) {
        LinkedList<Integer> list1=new LinkedList<Integer>();
        list1.push(3);
        list1.push(4);
        list1.push(2);

        LinkedList<Integer> list2=new LinkedList<Integer>();
        list2.push(4);
        list2.push(6);
        list2.push(5);
        list2.push(5);
        LinkedList<Integer> list = addTwoNumbers(list1, list2);
        System.out.println(list);

    }

    public static LinkedList<Integer> addTwoNumbers(LinkedList<Integer> list1,LinkedList<Integer> list2){
        int sum=0;
        int sum1 = sum(list1);
        int sum2 = sum(list2);
        sum=sum1+sum2;
        LinkedList<Integer> newList = new LinkedList<Integer>();
        String value = String.valueOf(sum);
        char[] chars = value.toCharArray();
        for (char c : chars) {
            newList.push(Integer.parseInt(String.valueOf(c)));
        }
        return newList;
    }
    public static int sum(LinkedList<Integer> list){
        int size = list.size();
        int sum=0;
        for (int i = 0; i < size; i++) {
            double v = list.pop() * Math.pow(10, i);
            sum+=v;
        }
        return sum;
    }

}
