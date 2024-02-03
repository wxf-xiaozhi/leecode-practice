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


    /**
     * leecode 266
     *
     * @param root
     */
    public TreeNode invertTree(TreeNode root) {
        invertSubTree(root);
        return root;
    }


    public void invertSubTree(TreeNode subNode) {
        if (subNode == null) {
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
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        midOrder(root, result);
        return result;
    }

    public void midOrder(TreeNode subNode, List<Integer> result) {
        if (subNode == null) {
            return;
        }
        if (subNode.left != null) {
            midOrder(subNode.left, result);
        }
        result.add(subNode.val);
        if (subNode.right != null) {
            midOrder(subNode.right, result);
        }
    }

    /**
     * leecode 206 翻转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * leecode 11
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
//      [1,8,6,2,5,4,8,3,7]
//      46

        int maxArea = 0;
        int L = 0;
        int R = height.length - 1;
        while (L < R) {
            int area = Math.min(height[L], height[R]) * (R - L);
            maxArea = Math.max(area, maxArea);
            if (height[L] <= height[R]) {
                L++;
            } else {
                R++;
            }
        }
        return maxArea;


    }

    /**
     * leecode 64
     *
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
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
//        输入：s = "()[]{}"
//        输出：true

        int length = s.length();
        if (length % 2 == 0) {
            return false;
        }


        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Character ch = chars[i];
            if (!map.containsKey(ch)) {
                stack.push(ch);
            } else {
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


    /**
     * leecode 21
     *
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
     *
     * @param list1
     * @param list2
     */
    public static void recursion(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return;
        }
        if (list2 == null) {
            return;
        }
        ListNode next1 = list1.next;
        list1.next = list2;
        recursion(list2, next1);
    }

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    /**
     * leecode 146
     *
     * @param
     */
    class LRUCache {
        private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
        private int size;
        private int capacity;
        private DLinkedNode head, tail;


        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            // 使用伪头部和伪尾部节点
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;

        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            // 如果 key 存在，先通过哈希表定位，再移到头部
            moveToHead(node);
            return node.value;

        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                // 如果 key 不存在，创建一个新的节点
                DLinkedNode newNode = new DLinkedNode(key, value);
                // 添加进哈希表
                cache.put(key, newNode);
                // 添加至双向链表的头部
                addToHead(newNode);
                ++size;
                if (size > capacity) {
                    // 如果超出容量，删除双向链表的尾部节点
                    DLinkedNode tail = removeTail();
                    // 删除哈希表中对应的项
                    cache.remove(tail.key);
                    --size;
                }
            } else {
                // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
                node.value = value;
                moveToHead(node);
            }

        }

        private void addToHead(DLinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        private DLinkedNode removeTail() {
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }

    }

    /**
     * leecode 25
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
//        输入：head = [1,2,3,4,5], k = 2
//        输出：[2,1,4,3,5]
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }

        return hair.next;

    }

    public static void subListNode(ListNode node, int k, List<ListNode> list) {
        int count = 1;
        list.add(node);
        while (node != null) {
            node = node.next;
            count++;
            if (count == k) {
                ListNode next = node;
                subListNode(next.next, k, list);
                if (node != null) {
                    node.next = null;

                }
                return;

            }

        }
    }

    public static ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }

    /**
     * leecode 24 两两交换链表中的节点 递归
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
//        输入：head = [1,2,3,4]
//        输出：[2,1,4,3]
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    /**
     * leecode 560
     *
     * @param nums
     * @param k    注意要连续，所以先确定最后一个数，倒着遍历，判断和是不是等于k,可能更方便
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * leecode 102
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
//        输入：root = [3,9,20,null,null,15,7]
//        输出：[[3],[9,20],[15,7]]
        List<List<Integer>> ans1 = new ArrayList<>();
        LinkedHashMap<Integer, List<Integer>> map = new LinkedHashMap();
        myDeep(root, map, 0);
        for (Map.Entry<Integer, List<Integer>> integerListEntry : map.entrySet()) {
            ans1.add(integerListEntry.getValue());
        }
        return ans1;
    }

    private static void myDeep(TreeNode node, LinkedHashMap<Integer, List<Integer>> map, Integer level) {
        if (node == null) {
            return;
        }
        if (map.get(level) == null) {
            List<Integer> list = new ArrayList<>();
            map.put(level, list);
        }
        map.get(level).add(node.val);
        myDeep(node.left, map, (level + 1));
        myDeep(node.right, map, (level + 1));
    }


    /**
     * leecode 53
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
//        输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//        输出：6
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    /**
     * 160. 相交链表
     *
     * 此题主要了解思路，用代码无法验证，因为使用的链表的构造方式与leecode不同
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        listA = [4,1,8,4,5], listB = [5,6,1,8,4,5] result = [8,4,5]
//        ListNode pa = headA;
//        while (pa != null){
//            ListNode paNext = pa.next;
//            ListNode pb = headB;
//            while (pb != null ){
//                ListNode pbNext = pb.next;
//                if(pa == pb){
//                    return pa;
//                }
//                pb = pbNext;
//            }
//            pa = paNext;
//        }
//        return null;


//        Set<ListNode> visited = new HashSet<ListNode>();
//        ListNode temp = headA;
//        while (temp != null) {
//            visited.add(temp);
//            temp = temp.next;
//        }
//        temp = headB;
//        while (temp != null) {
//            if (visited.contains(temp)) {
//                return temp;
//            }
//            temp = temp.next;
//        }
//        return null;

        // 这个题这种解法，多看官方题解，太妙了
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;


    }


    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3, 4};
        int[] arr3 = {1, 2, 3, 4, 5};
//        ListNode listNode1 = buildListNodeByArray(arr1);
//        ListNode listNode2 = buildListNodeByArray(arr2);
//        ListNode mergeTwoLists = mergeTwoLists(listNode1, listNode2);
//        System.out.println(mergeTwoLists);

//        ListNode listNode3 = ListNode.buildListNodeByArray(arr3);
//        ListNode reverseKGroup = reverseKGroup(listNode3,2);
//        System.out.println(reverseKGroup);

//        int[] arr4 ={1,1,1};
//
//        System.out.println(subarraySum(arr4, 2));
//        Object[] arr = {3, 9, 20, null, null, 15, 7};
//        TreeNode treeNode = TreeNode.buildTreeNodeByArray(arr);
//        Collection<List<Integer>> lists = levelOrder(treeNode);
//        System.out.println(lists);
//
//        int[] nums =  {-2,1,-3,4,-1,2,1,-5,4};
//        int i = maxSubArray(nums);
//        System.out.println(i);
        int[] arrA = {1,9,1,2,4};
        int[] arrB = {3,2,4};
        ListNode listA = ListNode.buildListNodeByArray(arrA);
        ListNode listB = ListNode.buildListNodeByArray(arrB);
        ListNode intersectionNode = getIntersectionNode(listA, listB);
        System.out.println(intersectionNode);

    }


}
