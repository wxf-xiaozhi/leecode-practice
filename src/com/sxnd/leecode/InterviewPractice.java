package com.sxnd.leecode;

import java.util.*;

/**
 * (一句话描述该类的功能)
 *
 * @version v1.0
 * @Author: xiaozhi
 * @Date: 2024/1/23 16:56
 */
public class InterviewPractice {




    // 给定一个字符串，找出最长不包含重复字母的子串长度
// 给定一个字符串，找出最长不包含重复字母的子串长度


//    如abcc,子串为abc,长度为3


//    如abcc,子串为abc,长度为3,猿辅导面试

    /**
     * leecode 3
     * @param s
     * @return
     */
    public Integer getMinUniqSub(String s){
        int n = s.length();
        Set<Character> occ = new HashSet<Character>();
        int p2 = -1,ans = 0;;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (p2+1 < n && !occ.contains(s.charAt(p2+1))){
                // 不断地移动右指针
                occ.add(s.charAt(p2 + 1));
                ++p2;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, p2 - i + 1);

        }
        return ans;

    }

    /**
     * 206/翻转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
//        1>2>3>4>5
//        5>2>3>2>1
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
     * leecode 19题
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
//        head = [1,2,3,4,5], n = 2
//        [1,2,3,5]

        ListNode p1 = head;

        int L = 1;
        while (p1 != null){
            p1 = p1.next;
            L++;
        }

        ListNode cur = head;
        ListNode pre = null;
        int count = 1;
        while (cur != null){
            pre = cur;
            cur = cur.next;
            if(count == (L-n+1)){
                pre.next = cur;
            }
            count++;
        }
        return pre;
    }



    /**
     * 删除链表重复元素
     *
     * 此解法错误
     * @param pHead
     * @return
     */
    public static ListNode deleteDuplication1(ListNode pHead) {
        Set<Integer> mySet = new HashSet<>();
        ListNode dump = new ListNode(-1);
        dump.next = pHead;
        ListNode p = dump;
        while(p != null){
            int val = p.val;
            ListNode next  = p.next;
            if(next != null && val == next.val ){
                mySet.add(val);
            }
            p = next;
        };
        // 此处错误原因：只是将p1指针往后移了一位。并没有删除元素
        // 和deleteKthToLast1的错误原因有相似之处
        ListNode p1 = dump;
        while(p1 != null){
            while(p1 != null && mySet.contains(p1.val) ){
                p1 = p1.next.next;
            }
            p1 = p1.next;
        };
        return dump.next;
    }

    /**
     *  集度面试题
     *  给出一个无序单向链表，删除链表中的重复元素 input: 1->3->1->3->5 output: 1->3->5
     * @param head
     * @return
     */
    public static ListNode deleteDubElement(ListNode head){
        Set<Integer> mySet = new HashSet<>();
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            int val = cur.val;
            ListNode next = cur.next;
            if(mySet.contains(val) && next != null){
                pre.next = next;
            }else{
                pre = cur;
            }
            mySet.add(val);
            cur = next;
        }
        return head;
    }

    /**
     * leecode 83
     * @param head
     * @return
     */
    public static ListNode deleteDuplication(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

//    innodb RR
//    id(pk), uid(index), value
//1       10          a
//
//    tx1:
//    update table set uid=20 where id=1;
//
//    tx2:
//    delete from table where uid=10;


    /**
     * 高德面试 leecode 19
     * @param head
     * @param n
     * @return
     */
    public static ListNode deleteKthToLast(ListNode head, int n) {
        int sum = 0;
        ListNode cur = head;
        while(cur != null){
            sum++;
            cur = cur.next;
        }
        if(head == null ){
            return null;
        }
        if(sum == n ){
            return head.next;
        }

        int index = 0;
        ListNode node = head;
        ListNode pre = null;
        while(node != null){
            index++;
            pre = node;
            ListNode next = node.next;
            int seq = (sum-n);
            if(index == seq){
                next = next.next;
            }
            pre.next = next;
            node = next;
        }
        return head;
    }

    /**
     * leecode 19 的解法2
     *从 ListNode node = head;行开始分析，
     * node标识当前指针，
     * node.next属于指针里面的next指针
     *
     * node = next属于是指针往后移了一位
     * node.next = node.next.next 才是将node的next指针指向了下下个节点
     * @param head
     * @param n
     * @return
     */
    @Deprecated
    public static ListNode deleteKthToLast1(ListNode head, int n) {
        int sum = 0;
        ListNode countNode = head;
        while(countNode != null){
            sum++;
            countNode = countNode.next;
        }
        if(head == null ){
            return null;
        }
        if(sum == n ){
            return head.next;
        }
        int index = 0;
        ListNode node = head;
        while(node != null){
            index++;
            ListNode next = node.next;
            int seq = (sum-n);
            if(index == seq){
                next = next.next;
                node.next = next;
            }
            node = next;
        }
        return head;
    }

    /**
     * leecode 560
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >=0 ; j--) {
                sum+= nums[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }



    public static void main(String[] args) {
//        ListNode node = new ListNode(1);
//        ListNode head = node;
//        node.next = new ListNode(2).next= new ListNode(3);
//        System.out.println(head);

//        int[] arr ={1,2,3,2,4,4,5};
//        ListNode listNode = ListNode.buildListNodeByArray(arr);
//        System.out.println(deleteDuplication(listNode));

//        int[] arr ={1,2,3,4,5};
//        ListNode listNode = ListNode.buildListNodeByArray(arr);
//        ListNode listNode1 = deleteKthToLast1(listNode, 2);
//        System.out.println(listNode1);
//
//        int nums[] ={1,2,3};
//
//
//        System.out.println(subarraySum(nums,3));

        int[] myarr = {1,3,1,3,5};
        ListNode listNode = ListNode.buildListNodeByArray(myarr);
        ListNode listNode1 = deleteDubElement(listNode);
        System.out.println(listNode1);
    }



}
