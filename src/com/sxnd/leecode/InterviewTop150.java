package com.sxnd.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试经典150题
 *
 * @version v1.0
 * @Author: xiaozhi
 * @Date: 2024/2/8 14:59
 */
public class InterviewTop150 {
    /**
     * 88. 合并两个有序数组
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int[] A, int m, int[] B, int n) {
//        输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//        输出：[1,2,2,3,5,6]

    }

    /**
     * 27. 移除元素
     * @param nums
     * @param val
     * @return
     */
    public static  int removeElement(int[] nums, int val) {
//        输入：nums = [3,2,2,3], val = 3
//        输出：2, nums = [2,2]

//        List<Integer> ans  = new ArrayList<>();
//        for (int j = 0; j < nums.length; j++) {
//            if(nums[j] != val){
//                ans.add(nums[j]);
//            }
//        }
//        return ans.size();

        int p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[p1] = nums[i];
                p1++;
            }
        }
        return p1;
    }

    public static void main(String[] args) {
        int[] a ={3,2,2,3};
        removeElement(a,3);
    }
}
