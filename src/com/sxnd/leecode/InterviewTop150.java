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

    /**
     * 6. Z 字形变换,此题比较难，我只能看懂，写是肯定写不出来的
     * 设 r = numRows;
     * Z字形的变换周期为 t=r+r-2,每个周期占用矩阵的 1+r-2= r-1列
     * 所以矩阵总的列数为 c = n/t*(r-1),
     *
     *
     * 为啥是(n + t - 1) / t * (r - 1); 而不是 n / t * (r - 1);
     * （n + t - 1）/ t 题目希望向上取整，因此，添加（t - 1）个元素，无论 n / t 的余数是多少，都能被舍去，并且可以向上取整
     *
     *  对于（n / t + 1）假设 n=10， t=5，那么需要开辟 3 列，而使用（n + t - 1）/ t = 2列，节省了开辟的列数
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
//        PAYPALISHIRING

//        P   A   H   N
//        A P L S I I G
//        Y   I   R

//        PAHNAPLSIIGYIR


        int n = s.length(), r = numRows;
        if (r == 1 || r >= n) {
            return s;
        }
        int t = r * 2 - 2;
        int c = (n + t - 1) / t * (r - 1);
        char[][] mat = new char[r][c];
        for (int i = 0, x = 0, y = 0; i < n; ++i) {
            mat[x][y] = s.charAt(i);
            if (i % t < r - 1) {
                ++x; // 向下移动
            } else {
                --x;
                ++y; // 向右上移动
            }
        }
        StringBuffer ans = new StringBuffer();
        for (char[] row : mat) {
            for (char ch : row) {
                if (ch != 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();




    }

    /**
     * 189. 轮转数组
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
//        输入: nums = [1,2,3,4,5,6,7], k = 3
//        输出: [5,6,7,1,2,3,4]
        // 自己写的超出时间限制
//        int n = nums.length;
//        LinkedList<Integer> list = new LinkedList<>();
//        for (int num : nums) {
//            list.add(num);
//        }
//        for (int i = 0; i < k; i++) {
//            Integer x = list.get(n-1);
//            list.remove(n-1);
//            list.addFirst(x);
//        }
//        for (int i = 0; i < list.size(); i++) {
//            nums[i] = list.get(0);
//        }
        // 官方解法
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);

//        此解法不对；
//        int n = nums.length;
//        int[] result = new int[n];
//        if(k<n){
//            for (int i = 0; i < n; i++) {
//                if(i < k){
//                    result[i] = nums[(n-k+i)];
//                }else {
//                    result[i] = nums[i-k];
//                }
//            }
//        }else{
//            int index = 0;
//            for (int i = n-1; i >=0 ; i--) {
//                result[index++] = nums[i];
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            nums[i] = result[i];
//        }
    }

    public static void main(String[] args) {
//        int[] a ={3,2,2,3};
//        removeElement(a,3);

//        int[] a ={1,1,2};
//        removeDuplicates(a);
//
//        int[] b = {0,0,1,1,1,1,2,3,3};
//        removeDuplicates2(b);

        int[] c = {1,2};
        rotate(c,2);
    }
}
