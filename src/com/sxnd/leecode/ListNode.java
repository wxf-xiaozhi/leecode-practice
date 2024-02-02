package com.sxnd.leecode;

/**
 * (一句话描述该类的功能)
 *
 * @version v1.0
 * @Author: xiaozhi
 * @Date: 2024/1/26 15:52
 */
public class ListNode {

    int val;
    ListNode next;

    public ListNode(int val,ListNode next){
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

//    @Override
//    public boolean equals(ListNode obj) {
//        return (this.val == obj.val && this.next == obj.next);
//    }

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
}
