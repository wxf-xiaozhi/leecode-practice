package com.sxnd.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GW00305020
 * @ClassName LeeCodeTop100
 * @description: 练习leecode的top100的题目
 * @date 2024年01月24日
 * @version: 1.0
 */
public class LeeCodeTop100 {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;

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
}
