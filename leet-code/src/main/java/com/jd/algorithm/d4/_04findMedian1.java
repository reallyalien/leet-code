package com.jd.algorithm.d4;

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
 *
 * 要求时间复杂度度）O(log(m+n))
 */
public class _04findMedian1 {
    public static void main(String[] args) {
        int[] num1 = {1, 3, 5};
        int[] num2 = {2, 5, 8,10,20,34};       //4
        double v = findMedianSortedArrays(num1, num2);
        System.out.println(v);
    }

    /**
     * 递归法求2个数组的中值，其实是求最k大小的值
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;  //4
        int m = nums2.length;  //10
        //分别指所要找的数，如果和为奇数，则left==right,在2个数组当中找第left和right的数,和为奇数的话，求2次。
        //left和right指第几个数，不是下标
        int left=(n+m+1)/2;
        int right=(n+m+2)/2;
        return (getKth(nums1,0,n-1,nums2,0,m-1,left)+getKth(nums1,0,n-1,nums2,0,m-1,right))*0.5;
    }
    //此方法默认len1 < len2,start指当前指向数组元素的指针，通过移动指针的方法去模拟删除数组当中的元素。
    private static int getKth(int[] num1,int start1,int end1,int[] num2,int start2,int end2,int k){
        int len1 = end1 - start1 + 1;//num1数组的长度
        int len2 = end2 - start2 + 1;//num2数组的长度
        //默认len1的长度<len2
        if (len1 > len2) return getKth(num2,start2,end2,num1,start1,end1,k);
        //因此len1先为0的几率大,当第一个数组被删除掉时，直接在第二个数组当中寻找第k个数，下标为k-1
        if (len1 == 0) return num2[ start2+(k-1) ];
        //如果当前k为1，即寻找当前2个数组第一个数，即下标为0的数，比较大小，小的就是我们要寻找的数。
        //这就是递归结束条件
        if (k == 1) return Math.min(num1[start1],num2[start2]);

        //寻找每个数组的第k个数，需要判断k/2于当前剩余数组的长度去比较，如果k/2大于len，默认指针指向该数组的末尾
        //所以我们判断一下，k/2于当前剩余数组的长度去比较大小，计算当前需要比较的数组的下标，
        //例如当前k=7.我们要寻找第7小的数，也就是k/2=3，去寻找每个数组中的第3个数，下标为2的数，start+Math.min(len,k/2)-1的数，
        //比较大小，小的数，肯定不是我们要找的数。
        int i=start1+Math.min(len1,k/2)-1;
        int j=start2+Math.min(len2,k/2)-1;
        //如果数组1的当前数>数组2的当前数，则删除数组2前k/2个数，即移动start指针，这里使用j直接指向下一个数也可以，指向k/2，然后当前k=k-k/2
        if (num1[i] > num2[j]){
//            return getKth(num1,start1,end1,num2,j+1,end2,k-(j-start2+1));
            return getKth(num1,start1,end1,num2,j+1,end2,k-(k/2));
        }else {
//            return getKth(num1,i+1,end1,num2,start2,end2,k-(i-start1+1));
            return getKth(num1,i+1,end1,num2,start2,end2,k-(k/2));
        }
    }
}
