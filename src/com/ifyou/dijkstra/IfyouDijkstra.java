package com.ifyou.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 如果内部的迪杰斯特拉的实战应用
 *
 * @version v1.0
 * @Author: xiaozhi
 * @Date: 2024/3/28 20:37
 */
public class IfyouDijkstra {

     public void buildGraph(HdMapTopologyRes hdMapTopologyRes){

          //key:nodeId, value: nodes列表序号
          Map<Integer, Integer> nodeIndexMap = new HashMap<>();
          //key:nodes列表序号, value: nodeId
          Map<Integer, Integer> indexNodeMap = new HashMap<>();
          //key: {preNodeId}-{sucNodeId}
          Map<String, HdMapLaneTopologyRes> laneMap = new HashMap<>();


          List<Integer> nodes = new ArrayList<>();
          int index = 0;
          for (HdMapLaneTopologyRes lane : hdMapTopologyRes.getLaneList()) {
               if (!nodeIndexMap.containsKey(lane.getPreNodeSn())) {
                    nodeIndexMap.put(lane.getPreNodeSn(), index);
                    indexNodeMap.put(index, lane.getPreNodeSn());
                    index++;
                    nodes.add(lane.getPreNodeSn());
               }
               if (!nodeIndexMap.containsKey(lane.getSucNodeSn())) {
                    nodeIndexMap.put(lane.getSucNodeSn(), index);
                    indexNodeMap.put(index, lane.getSucNodeSn());
                    index++;
                    nodes.add(lane.getSucNodeSn());
               }
               laneMap.put(String.valueOf(lane.getPreNodeSn()) + "-" + lane.getSucNodeSn(), lane);
          }

          int[][] graph = new int[nodes.size()][];
          for (int i = 0; i < nodes.size(); i++) {
               List<Integer> rows = new ArrayList<>();
               for (int j = 0; j < nodes.size(); j++) {
                    String key = String.valueOf(indexNodeMap.get(i)) + "-" + indexNodeMap.get(j);
                    if (laneMap.containsKey(key)) {
                         rows.add(j);
                    }
               }
               int[] rowArray = new int[rows.size()];
               for (int m = 0; m < rows.size(); m++) {
                    rowArray[m] = rows.get(m);
               }
               graph[i] = rowArray;
          }


     }


}
