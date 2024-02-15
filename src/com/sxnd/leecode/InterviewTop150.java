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

    /**
     * 125. 验证回文串
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        // 解法一
//        StringBuffer sgood = new StringBuffer();
//        int length = s.length();
//        for (int i = 0; i < length; i++) {
//            char ch = s.charAt(i);
//            // 过滤字符或数字
//            if (Character.isLetterOrDigit(ch)) {
//                sgood.append(Character.toLowerCase(ch));
//            }
//        }
//        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
//        return sgood.toString().equals(sgood_rev.toString());

        // 双指针
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

    /**
     * 55. 跳跃游戏
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
//        输入：nums = [2,3,1,1,4]
//        输出：true
//        解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标


        // 官方题解，贪心算法
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;

        // 自己写的，使用的递归法，但是错误的,没有考虑到j > val,应该回到上次循环，目前直接返回false情况,这种思路不对
//        int n = nums.length;
//        if(nums.length == 0 || nums[0] >= (n-1)){
//            return true;
//        }
//        return myDeep(0,nums);

    }
    public static Boolean myDeep(int curPos,int[] nums){
        int val = nums[curPos];
        for (int j = 1; j <= val; j++) {
            int step = curPos + j;
            if (step >= nums.length - 1) {
                return true;
            } else {
                // max = Math.max(max, step);
                return myDeep(step, nums);
            }
        }
        return false;

    }

    /**
     * 14. 最长公共前缀
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        // 此解法错误
//        if(strs.length ==1){
//            return strs[0];
//        }
//        String base = strs[0];
//        int min = 0;
//        for (int i = 1; i < strs.length; i++) {
//            String s = strs[i];
//            min = Math.min(base.length(),s.length());
//            base = base.substring(0,min);
//            for (int j = 0; j < min; j++) {
//                if(base.charAt(j) != s.charAt(j)){
//                    base = s.substring(0,j);
//                    return base;
//                }
//            }
//
//        }
//        return base.substring(0,min);

        // 官方题解
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    public static void main(String[] args) {
//        int[] a ={3,2,2,3};
//        removeElement(a,3);

//        int[] a ={1,1,2};
//        removeDuplicates(a);
//
//        int[] b = {0,0,1,1,1,1,2,3,3};
//        removeDuplicates2(b);

//        int[] c = {1,2};
//        rotate(c,2);

//        int[] a = {2,5,0,0};
//        boolean b = canJump(a);
//        System.out.println(b);

        String[] a = {"flower","flow","flight"};
        String[] b = {"aaa","aa","aaa"};
        String s = longestCommonPrefix(b);
        System.out.println(s);


    }
}
