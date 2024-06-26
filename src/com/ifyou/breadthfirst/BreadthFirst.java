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
     * 使用广度优先搜索算法在图（graph）中查找从起始节点（start）到目标节点（target）的路径。
     * @param graph 包含节点和它们邻居节点关系的图，键为节点名称，值为邻居节点列表
     * @param start 起始节点的名称
     * @param target 目标节点的名称
     * @return 如果找到从起始节点到目标节点的路径，则返回true；否则返回false
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
    public static class Node{
        String name;
        Integer level;

        public Node(String name, Integer level) {
            this.name = name;
            this.level = level;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }
    }

    /**
     * 根据给定的图（Map<String,List<String>>）使用广度优先搜索算法查找从起点（String start）到目标点（String target）的路径
     *
     * @param graph 图的表示，键为节点的名称，值为该节点的邻居列表
     * @param start 起点节点的名称
     * @param target 目标节点的名称
     * @return 包含起点到目标点路径的节点列表，如果未找到路径则返回空列表
     */
    public static List<Node> breadthFirst1(Map<String,List<String>> graph,String start,String target){
        Integer level = 0;
        List<Node> path = new ArrayList<>();
        Node startNode = new Node(start,level);
        path.add(startNode);
        if(start.equals(target)){
            return path;
        }
        Queue<Node> queue = new ArrayDeque<>();
        List<String> friends = graph.get(start);

        for (int i = 0; i < friends.size(); i++) {
            Node node = new Node(friends.get(i),(level+1));
            queue.offer(node);
        }
        Set<String> checked = new HashSet<>();
        while (!queue.isEmpty()){
            Node person = queue.poll();
            if(!checked.contains(person.getName())){
                if(person.getName().equals(target)){
                    path.add(person);
                    return path;
                }else{
                    List<String> newFriends = graph.get(person.getName());
                    for (int i = 0; i < newFriends.size(); i++) {
                        Node node = new Node(newFriends.get(i), (person.level+1));
                        queue.offer(node);
                    }
                }
                checked.add(person.getName());
            }
        }
        return path;
    }


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
