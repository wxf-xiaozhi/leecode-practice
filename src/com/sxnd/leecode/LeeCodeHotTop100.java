package com.sxnd.leecode;

import java.util.*;
import java.util.stream.Collectors;

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
     * leecode 21、合并两个有序链表
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
     * leecode 101 对称二叉树
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSame(root.left,root.right);

    }

    public static boolean isSame(TreeNode  node1,TreeNode node2){
        if(node1 == null && node2 == null){
            return true;
        }else if(node1 == null && node2 != null){
            return false;
        }else if(node1 != null && node2 == null){
            return false;
        }else{
            boolean a = (node1.val == node2.val);
            return a && isSame(node1.left,node2.right) && isSame(node1.right,node2.left);
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

        // 官方解法第一种

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

    /**
     * leecode 141 环形链表
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        // 解法一，使用hash表
//        Set<ListNode> set = new HashSet<>();
//        ListNode node = head;
//        while (node != null){
//            if(!set.add(node)){
//               return true;
//            }
//            ListNode next = node.next;
//            node = next;
//        }
//        return false;

        // 解法二、块慢指针，如果有环，则慢指针会追上快指针
        ListNode slow = head;
        ListNode fast = slow.next;
        while (fast != slow){
            if(fast == null || slow == null){
                return false;
            }
            // 快指针会一次跳两下
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    /**
     * leecode 142. 环形链表 II
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        // 解法一，hash表
        Set<ListNode> mySet = new HashSet<>();
        ListNode cur = head;
        while (cur != null){
            if(!mySet.add(cur)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * leecode 1143. 最长公共子序列
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        return 0;
    }

    /**
     * 70. 爬楼梯
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        // 自己写的，超出时间限制，感觉是对的
//        if(n <= 0){
//            return 0;
//        }
//        if(n == 1){
//            return 1;
//        }
//        if(n == 2){
//            return 2;
//        }
//        return climbStairs(n-1)+climbStairs(n-2);

        // f(x) = f(x-1)+f(x-2),滚动数组思想
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;


    }

    /**
     * 118. 杨辉三角
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        return mydeep(numRows);
    }
    public static List<List<Integer>> mydeep(int numRows){
        if(numRows < 1){
            return null;
        }
        if(numRows == 1){
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> rowList = Arrays.asList(new Integer[]{1});
            ans.add(rowList);
            return ans ;
        }
        if (numRows == 2){
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> rowList1 = Arrays.asList(new Integer[]{1});
            List<Integer> rowList = Arrays.asList(new Integer[]{1,1});
            ans.add(rowList1);
            ans.add(rowList);
            return ans;
        }
        List<Integer> rowList = new ArrayList<>();
        rowList.add(1);
        List<List<Integer>> ans = mydeep(numRows - 1);
        List<Integer> lastRowList = ans.get(ans.size()-1);
        for (int i = 0; i < lastRowList.size()-1; i++) {
            rowList.add(lastRowList.get(i)+ lastRowList.get(i+1));

        }
        rowList.add(1);
        ans.add(rowList);
        return ans;

    }

    /**
     * 283. 移动零
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
//        输入: nums = [0,1,0,3,12]
//        输出: [1,3,12,0,0]

        // 自己的写法，空间复杂度太高
//        List<Integer> arr = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i] != 0){
//                arr.add(nums[i]);
//            }
//
//        }
//        int i = 0;
//        while ( i < arr.size()) {
//            nums[i] = arr.get(i);
//            i++;
//        }
//        for (int j = i; j < nums.length ; j++) {
//            nums[j] = 0;
//        }

        // 官方解法 双指针解法,左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部
        int p1 = 0,p2 = 0;
        while (p1 < nums.length){
            if(nums[p1] != 0){
                int temp = nums[p1];
                nums[p1] = nums[p2];
                nums[p2] = temp;
                p2++;
            }
            p1++;
        }

    }

    /**
     * leecode 104. 二叉树的最大深度
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return mydeep1(root,1);
    }

    public static int mydeep1(TreeNode root,int deep){
        if(root == null){
            return 0;
        }
        return deep+Math.max(mydeep1(root.left,deep),mydeep1(root.right,1));
    }

    /**
     * 20. 有效的括号
     * @param s
     * @return
     */
    public static boolean isValid1(String s) {
        Map<Character,Character> map =new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        char[] chars = s.toCharArray();
        if(chars.length % 2 == 1){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if(aChar == '(' || aChar == '[' || aChar == '{' ){
                stack.push(aChar);
            }else{
                Character character = map.get(aChar);
                if(stack.isEmpty() || character != stack.peek()){
                    return false;
                }
                stack.pop();
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;

    }

    /**
     * 35. 搜索插入位置
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
//        输入: nums = [1,3,5,6], target = 5
//        输出: 2

//        输入: nums = [1,3,5,6], target = 2
//        输出: 1

        int r = nums.length -1;
        int l = 0;
        int pos = (l + r)/2;
        while (l <= r){
            if(nums[pos]<target)
                l=pos+1;
            else {
                r=pos-1;
            }
            pos = (l + r)/2;
        }

        return l;

    }

    /**
     * leecode 48. 旋转图像
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int curRow = 0;
        int curCol = 0;
        int max = n -1;
//        (0,0) = > (0 max)
//        (0,1) => (1,max)
//            上面
//        (curRow,curCol)  ==> ( curCol,max -curRow)
//
//        (1,1) =>(1,2)
//        (0,2)==>(2,3)

//        右边
//        (1,3) => (3,2)
//        (2,3) ==> (3,1)
//
//        (curRow,curCol) => (curCol,max-curRow)
//        (0,3) => (3,3)
//        (1,3) ==>(3,2)

//        下面
//        (3,3) ==>(3,0)
//        (curRow,curCol) ==> (curCol,max -curRow)
//        (3,1) =>(2,0)
//        (3,2) =>(2,0)

//        左面
//        (curRow,curCol) ==>(curCol,max-curRow)
//
//        (1,0) ==>(0,2)


//        int temp = matrix[curRow][curCol];
//        matrix[curRow][curCol] = matrix[curCol,max - curRow];
        int[][] myMa = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                myMa[i][j] = matrix[j][n-1-i];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = myMa[i][j];
            }
        }

    }

    /**
     * 56. 合并区间
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
//        输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//        输出：[[1,6],[8,10],[15,18]]
//        int p1 = 0;
//        int p2 = 1;
//        List<List<Integer>> result = new ArrayList<>();
//        int[] a = intervals[p1];
//
//        while (p2 < intervals.length){
//            int[] b = intervals[p2];
//            if(a[a.length-1] > b[0]){
//                int l = Math.min(a[0],b[0]);
//                int r = Math.max(a[a.length-1],b[b.length-1]);
//                a = new int[]{l, r};
//                result.add(Arrays.stream(a).boxed().collect(Collectors.toList()));
//            }else{
//                result.add(Arrays.stream(b).boxed().collect(Collectors.toList()));
//                p1++;
//            }
//            p2++;
//        }
//        System.out.println(result);

        if(intervals.length == 0){
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        List<int[]> merge = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            if(merge.size() == 0){
                merge.add(new int[]{L,R});
            }else if(merge.get(merge.size()-1)[1] < L){
                merge.add(new int[]{L,R});
            }else{
                merge.get(merge.size() - 1)[1] = Math.max(R,merge.get(merge.size()-1)[1]);
            }
        }
        return merge.toArray(new int[merge.size()][]);


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
//        int[] arrA = {1,9,1,2,4};
//        int[] arrB = {3,2,4};
//        ListNode listA = ListNode.buildListNodeByArray(arrA);
//        ListNode listB = ListNode.buildListNodeByArray(arrB);
//        ListNode intersectionNode = getIntersectionNode(listA, listB);
//        System.out.println(intersectionNode);

//        List<List<Integer>> generate = generate(1);
//        System.out.println(generate);

//        int[] nums = {0,1,0,3,0,12};
//        moveZeroes(nums);
//        for (int num : nums) {
//            System.out.println(num);
//        }

//        Object[] arr = {3,9,20,null,null,15,7};
//        TreeNode treeNode = TreeNode.buildTreeNodeByArray(arr);
//        int i = maxDepth(treeNode);
//        System.out.println(i);

//        String s = "){";
//        boolean valid1 = isValid1(s);
//        System.out.println(valid1);


        //        输入: nums = [1,3,5,6], target = 5
//        输出: 2

//        输入: nums = [1,3,5,6], target = 2
//        输出: 1

//        int[] nums = {1,3,5,6} ;
//        int i = searchInsert(nums, 5);
//        System.out.println(i);
//
//        int[] nums = {1,3,5,6} ;
//        int i1 = searchInsert(nums, 2);
//        System.out.println(i1);

        int[][] inter = {{1,3},{2,6},{8,10},{15,18}};
        merge(inter);

    }


}
