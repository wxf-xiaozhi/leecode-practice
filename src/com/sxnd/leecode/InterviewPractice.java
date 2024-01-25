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



    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val =val;
        }
    }


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
     * leecode19题
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

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode head = node;
        node.next = new ListNode(2).next= new ListNode(3);
        System.out.println(head);
    }

}
