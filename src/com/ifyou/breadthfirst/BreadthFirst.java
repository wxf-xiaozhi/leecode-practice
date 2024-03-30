package com.ifyou.breadthfirst;

import java.util.*;

/**
 * @ClassName: BreadthFirst
 * @description: 广度优先算法
 * @author: xiaofang.wu
 * @create: 2024-03-30 11:50
 */
public class BreadthFirst {


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
     * 检查是否
     *
     * @param graph
     * @param start
     */
    public static Boolean breadthFirst(Map<String,List<String>> graph,String start,String target){
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



    public static void main(String[] args) {
        Map<String, List<String>> graph = buildGraph();
        Boolean b = breadthFirst(graph, "you", "芒果商");
        String ans = b ?"you的朋友关系网中存在芒果商":"you的朋友关系网中没有芒果商";
        System.out.println(ans);
    }



}
