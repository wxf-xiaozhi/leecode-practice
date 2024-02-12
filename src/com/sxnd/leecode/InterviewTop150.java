package com.sxnd.leecode;

import java.util.*;

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
    public static void merge(int[] A, int m, int[] B, int n) {
//        输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//        输出：[1,2,2,3,5,6]
        int[] merge = new int[m+n];
        int p1 = 0,p2 =0;
        int cur = 0;
        while (p1< m || p2 < n){
            if(p1 == m){
                cur = B[p2];
                p2++;
            }else if(p2 == m){
                cur = A[p1];
                p1++;
            }else if(A[p1] <= B[p2]){
                cur = A[p1];
                p1++;
            }else{
                cur = B[p2];
                p2++;
            }
            merge[p1+p2-1] = cur;

        }
        for (int i = 0; i < merge.length; i++) {
            A[i] = merge[i];
        }
    }

    /**
     *
     * 26. 删除有序数组中的重复项
     * @param nums
     * @return
     */
    public static  int removeDuplicates(int[] nums) {
//        Set<Integer> mySet = new LinkedHashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            mySet.add(nums[i]);
//        }
//        int[] a = new int[mySet.size()];
//        Iterator<Integer> iterator = mySet.iterator();
//        int index = 0;
//        while (iterator.hasNext()){
//            a[index] = iterator.next();
//            index++;
//        }
//        nums = a;
//        return nums.length;
        int p1 = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1] != nums[i]){
                nums[p1] = nums[i];
                p1++;
            }
        }
        return p1;
    }

    /**
     * 80. 删除有序数组中的重复项 II
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
//        输入：nums = [0,0,1,1,1,1,2,3,3]
//        输出：7, nums = [0,0,1,1,2,3,3]
        // 官方写法，因为数组是有序数组，且最多两个相同，因此监测方式nums[slow-2] != nums[fast]
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;

    }

    /**
     * 169. 多数元素
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
//        输入：nums = [3,2,3]
//        输出：3
        // 自己写法
//        int n = nums.length;
//        int x = n/2;
//        int result = nums[0];
//        Arrays.sort(nums);
//        int count = 1;
//        for (int i = 1; i < nums.length; i++) {
//            if(nums[i] == nums[i-1]){
//                count++;
//                if(count > x){
//                    result = nums[i];
//                    break;;
//                }
//            }else{
//                count =1;
//            }
//        }
//        return result;

        // 官方解法
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n/2];

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
//        int[] a ={3,2,2,3};
//        removeElement(a,3);

        int[] a ={1,1,2};
        removeDuplicates(a);

        int[] b = {0,0,1,1,1,1,2,3,3};
        removeDuplicates2(b);
    }
}
