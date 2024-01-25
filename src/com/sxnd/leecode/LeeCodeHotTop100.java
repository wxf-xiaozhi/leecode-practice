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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        输入：l1 = [1,2,4], l2 = [1,3,4]
//        输出：[1,1,2,3,4,4]
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode result = cur1;
        min(cur1,cur1.next,list2);
        return result;


    }
    public void min(ListNode head ,ListNode list1, ListNode list2){
        if(list1 == null){
            return;
        }
        if(list2 == null){
            return;
        }
        ListNode next1 = list1.next;
        ListNode next2 = list2.next;
        head.next = list2;
        min(head.next,next2,next1);

    }

    public static void main(String[] args) {
        int[] arr =  {1,2,4};
        ListNode listNode = buildListNodeByArray(arr);
        System.out.println(listNode);
    }


}
