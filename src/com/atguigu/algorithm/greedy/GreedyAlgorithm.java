package com.atguigu.algorithm.greedy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * // 贪心算法解决集合覆盖
 *
 * @version v1.0
 * @Author: xiaozhi
 * @Date: 2024/2/15 19:11
 */
public class GreedyAlgorithm {
    /**
     * 1、遍历所有的广播电台, 找到一个覆盖了最多未覆盖的地区的电台(此电台可能包含一些已覆盖的地区，但没有关系）
     * 2、将这个电台加入到一个集合中(比如ArrayList), 想办法把该电台覆盖的地区在下次比较时去掉。
     * 3、重复第1步直到覆盖了全部的地区
     * @param args
     */
    public static void main(String[] args) {
        // 构造初始数据
        //创建广播电台,放入到 Map
        HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>(); //将各个电台放入到 broadcasts
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");
        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");
        //加入到 map
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);
        //allAreas 存放所有的地区
        HashSet<String> allAreas = new HashSet<String>();

        for (HashSet<String> value : broadcasts.values()) {
            allAreas.addAll(value);
        }


        // 贪心算法解决集合覆盖
        HashSet<String> tempSet = new HashSet<String>();
        List<String> selects = new ArrayList<>();

        while (allAreas.size() != 0) {
            String max = null;
            for (String key : broadcasts.keySet()) {
                tempSet.clear();
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                //求出 tempSet 和 allAreas 集合的交集, 交集会赋给 tempSet
                tempSet.retainAll(allAreas);
                // 如果当前这个集合包含的未覆盖地区的数量，比 maxKey 指向的集合地区还多
                // 就需要重置 maxKey
                // 体现出贪心算法的特点,每次都选择最优的
                if(tempSet.size() > 0 && (max == null || tempSet.size() > broadcasts.get(max).size()) ){
                    max = key;
                }
            }
            if(max != null){
                selects.add(max);
                allAreas.removeAll(broadcasts.get(max));
            }

        }
        System.out.println("得到的选择结果是" + selects);


    }
}
