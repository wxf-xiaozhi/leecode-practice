package com.sxnd.leecode;

import java.util.*;

/**
 * @author GW00305020
 * @ClassName LeeCodeTop100
 * @description: 练习leecode的HotTop100的题目
 * @date 2024年01月24日
 * @version: 1.0
 */
public class LeeCodeHotTop100 {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;

        }
        public ListNode(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            ListNode cur = this;
            StringBuilder sb = new StringBuilder("ListNode:");
            int count = 0;
            while (cur != null){
                String prefix = count == 0 ?"":"-";
                sb.append(prefix+cur.val);
                cur = cur.next;
                count++;
            }
            return sb.toString();
        }
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;

        }
    }
    public TreeNode invertTree(TreeNode root) {
        invertSubTree(root);
        return root;
    }

    /**
     * leecode 266
     * @param subNode
     */
    public void invertSubTree(TreeNode subNode){
        if(subNode == null){
            return;
        }
        TreeNode left = subNode.left;
        TreeNode right = subNode.right;
        subNode.left = right;
        subNode.right = left;
        invertTree(left);
        invertTree(right);
    }

    /**
     * leecode 94
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        midOrder(root,result);
        return result;
    }

    public void midOrder(TreeNode subNode, List<Integer> result){
        if(subNode == null){
            return;
        }
        if(subNode.left != null){
            midOrder(subNode.left,result);
        }
        result.add(subNode.val);
        if(subNode.right != null){
            midOrder(subNode.right,result);
        }
    }

    /**
     * leecode 206
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * leecode 11
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
//      [1,8,6,2,5,4,8,3,7]
//      46

        int maxArea = 0;
        int L = 0;
        int R = height.length-1;
        while (L < R){
            int area = Math.min(height[L],height[R]) * (R-L);
            maxArea = Math.max(area,maxArea);
            if(height[L] <= height[R]){
                L++;
            }else{
                R++;
            }
        }
        return maxArea;


    }

    /**
     * leecode 64
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][columns - 1];

    }

    /**
     * leecode 20
     * @param s
     * @return
     */
    public boolean isValid(String s) {
//        输入：s = "()[]{}"
//        输出：true

        int length = s.length();
        if(length % 2 ==0){
            return false;
        }


        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Character ch = chars[i];
            if(!map.containsKey(ch)){
                stack.push(ch);
            }else{
                if (stack.isEmpty() || stack.peek() != map.get(ch)) {
                    return false;
                }
                stack.pop();
            }
        }
        return true;


    }

    /**
     * 根据数据构造链表
     * @param arr
     * @return
     */
    public static ListNode buildListNodeByArray(int[] arr){
        ListNode cur = new ListNode(0);
        ListNode head = cur;
        for (int i = 0; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i]);
            cur.next = temp;
            cur = temp;
        }
        return head.next;
    }


    /**
     * leecode 21
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        输入：l1 = [1,2,4], l2 = [1,3,4]
//        输出：[1,1,2,3,4,4]

        /**
         * 以下是自己写的合并算法
         */
//        if(list1 == null ){
//            return list2;
//        }
//        if(list2 == null){
//            return list1;
//        }
//        ListNode result = list1;
//        recursion(list1,list2);
//        return result;

        /**
         * 官方给出的递归算法
         */
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }


    }

    /**
     * 合并两个链表的递归方法,仅仅将链表合并并未排序
     * @param list1
     * @param list2
     */
    public static void recursion(ListNode list1, ListNode list2){
        if(list1 == null ){
            return;
        }
        if(list2 == null){
            return;
        }
        ListNode next1 = list1.next;
        list1.next = list2;
        recursion(list2,next1);
    }

    public static void main(String[] args) {
        int[] arr1 =  {1,2,4};
        int[] arr2 =  {1,3,4};
        ListNode listNode1 = buildListNodeByArray(arr1);
        ListNode listNode2 = buildListNodeByArray(arr2);
        ListNode mergeTwoLists = mergeTwoLists(listNode1, listNode2);
        System.out.println(mergeTwoLists);
    }


}
