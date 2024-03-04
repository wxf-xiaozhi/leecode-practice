package com.sxnd.leecode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * (一句话描述该类的功能)
 *
 * @version v1.0
 * @Author: xiaozhi
 * @Date: 2024/3/2 16:54
 */
public class HWPractice {
    /**
     * leecode 1
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                if(target == (nums[i] + nums[j])){
//                    ans[0] = i;
//                    ans[1] = j;
//                }
//            }
//        }
//        return ans;

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

    /**
     * 牛客HJ3 明明的随机数
     */
    public int[] uniqSort(int[] arr){
        TreeSet<Integer> set = new TreeSet();
        //输入
        for(int i =0 ; i < arr.length ;i++){
            set.add(arr[i]);
        }
        int[] ans = new int[set.size()];
        //输出
        int index  = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            ans[index++] =next.intValue();
        }
        return ans;
    }

    /**
     *
     * HJ23
     */
    public static  String deleteMinChar(String str){
        Map<Character,Integer> map = new HashMap<>();
        for(int i =0;i < str.length();i++){
            Character s = str.charAt(i);
            if(map.get(s) != null){
                map.put(s,map.get(s)+1);
            }else{
                map.put(s,1);
            }
        }
        Integer min = Integer.MAX_VALUE;
        Iterator it = map.values().iterator();
        while(it.hasNext()){
            min = Math.min(min,(Integer)it.next());

        }
        StringBuffer sb = new StringBuffer();
        for(int i =0;i < str.length();i++){
            if(map.get(str.charAt(i)) != min ){
                sb.append(str.charAt(i));
            }

        }
        return sb.toString();


    }

    /**
     * HJ106
     * @param str
     * @return
     */
    public static String getStr(String str){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            stack.push(str.charAt(i));
        }
        StringBuilder sb= new StringBuilder("");
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    /**
     * HJ33
     */
    public void convert(String ip){

    }


    public static class Interval {
        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }


    }
    /**
     * NC37.合并区间
     *
     * @param intervals
     * @return
     */
    public static List<Interval> merge (List<Interval> intervals) {
        if(intervals.size() ==0){
            return intervals;
        }
        List<Interval> collect = intervals.stream().sorted(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        }).collect(Collectors.toList());
        ArrayList<Interval> ans = new ArrayList<>();
        Interval interval = collect.get(0);
        ans.add(interval);
        for (int i = 1; i < collect.size(); i++) {
            Interval interval1 = collect.get(i);
            if(interval1.start <= interval.end){
                int start = Math.min(interval1.start,interval.start);
                int end = Math.max(interval1.end,interval.end);
                ans.remove(ans.size()-1);
                interval = new Interval(start, end);
                ans.add(interval);
            }else{
                ans.add(interval1);
                interval = interval1;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
//        [[10,30],[20,60],[80,100],[150,180]]
        Interval interval = new Interval(10, 30);

        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(0, 2));
        input.add(new Interval(3, 5));
//        input.add(new Interval(80, 100));
//        input.add(new Interval(150, 180));
        merge(input);

    }


    /**
     * leecode 674. 最长连续递增序列
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        int len = 1;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1] < nums[i]){
                len++;
            }else{
                max = Math.max(max,len);
                len = 1;
            }
        }
        return Math.max(max,len);
    }

    /**
     * leecode 1. 两数之和
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.keySet().contains(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[2];
    }

    /**
     * leecode 1614. 括号的最大嵌套深度
     * @param s
     * @return
     */
    public static  int maxDepth(String s) {
        int n = 0;
        int count = 0;
        int ans = 0;
        while (n < s.length()){
            if(s.charAt(n) == '('){
                count++;
                ans = Math.max(ans,count);
            }else if(s.charAt(n) == ')') {
                count--;
            }
            n++;
        }
        return ans;
    }




}
