package com.ifyou.breadthfirst;

import java.util.*;

/**
 * @ClassName: BreadthFirst
 * @description: 广度优先算法
 * @author: xiaofang.wu
 * @create: 2024-03-30 11:50
 */
public class BreadthFirst {

    /**
     * 构造图数据。也就是一个关系网
     * @return
     */
    public static Map<String,List<String>> buildGraph(){

        Map<String,List<String>> graph = new HashMap<>();
        graph.put("you", Arrays.asList(new String[]{"alice", "bob", "claire"}));
        graph.put("bob",Arrays.asList(new String[]{"anuj", "peggy"}));
        graph.put("alice", Arrays.asList(new String[]{"peggy"}));
        graph.put("claire", Arrays.asList(new String[]{"thom", "jonny"}));
        graph.put("anuj",new ArrayList<>());
        graph.put("peggy", new ArrayList<>());
        graph.put("thom",new ArrayList<>());
        graph.put("jonny", new ArrayList<>());

        return graph;
    }

    /**
     * 因为使用到队列，遵循FIFO.所以会优先遍历一度关系，在遍历二度关系，所以如果能找到芒果商，找到的也是最短路径
     *
     *
     *
     * @param graph
     * @param start
     */
    public static Boolean breadthFirst(Map<String,List<String>> graph,String start,String target){

        if(start.equals(target)){
            return true;
        }

        Queue<String> queue = new ArrayDeque<>();

        List<String> friends = graph.get(start);
        for (int i = 0; i < friends.size(); i++) {
            queue.offer(friends.get(i));
        }
        Set<String> checked = new HashSet<>();
        while (!queue.isEmpty()){
            String person = queue.poll();
            if(!checked.contains(person)){
                if(person.equals(target)){
                    return true;
                }else{
                    List<String> newFriends = graph.get(person);
                    for (int i = 0; i < newFriends.size(); i++) {
                        queue.offer(newFriends.get(i));
                    }
                }
                checked.add(person);
            }
        }
        return false;
    }


//    public static String breadthFirst1(Map<String,List<String>> graph,String start,String target){
//
//        if(start.equals(target)){
//            return start;
//        }
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(start);
//        Lin<String> queue = new ArrayDeque<>();
//        List<String> friends = graph.get(start);
//        for (int i = 0; i < friends.size(); i++) {
//            queue.offer(friends.get(i));
//        }
//        int level = 1;
//        Set<String> checked = new HashSet<>();
//        while (!queue.isEmpty()){
//            String person = queue.poll();
//            if(!checked.contains(person)){
//                if(!friends.contains(person)){
//                    level++;
//                }
//                if(person.equals(target)){
//                    return stringBuilder.toString();
//                }else{
//                    List<String> newFriends = graph.get(person);
//                    for (int i = 0; i < newFriends.size(); i++) {
//                        queue.offer(newFriends.get(i));
//                    }
//                }
//                checked.add(person);
//            }
//        }
//        return "";
//    }


    /**
     * 前提 thom是芒果商
     * @param args
     */
    public static void main(String[] args) {
        Map<String, List<String>> graph = buildGraph();
        Boolean b = breadthFirst(graph, "you", "thom");
        String ans = b ?"you的朋友关系网中存在芒果商":"you的朋友关系网中没有芒果商";
        System.out.println(ans);
        if(b){

        }
    }



}
