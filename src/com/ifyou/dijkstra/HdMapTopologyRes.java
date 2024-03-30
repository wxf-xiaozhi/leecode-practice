package com.ifyou.dijkstra;


import java.util.List;

/**
 * 高精地图路网拓扑结构
 */
public class HdMapTopologyRes {
    /**
     * 路网元素列表（区域）
     */
    private List<HdMapRoadElementTopologyRes> roadElements;
    /**
     * 车道线列表
     */
    private List<HdMapLaneTopologyRes> LaneList;
    /**
     * 节点列表
     */
    private List<HdMapLaneNodeTopologyRes> laneNodeList;

    public List<HdMapRoadElementTopologyRes> getRoadElements() {
        return roadElements;
    }

    public void setRoadElements(List<HdMapRoadElementTopologyRes> roadElements) {
        this.roadElements = roadElements;
    }

    public List<HdMapLaneTopologyRes> getLaneList() {
        return LaneList;
    }

    public void setLaneList(List<HdMapLaneTopologyRes> laneList) {
        LaneList = laneList;
    }

    public List<HdMapLaneNodeTopologyRes> getLaneNodeList() {
        return laneNodeList;
    }

    public void setLaneNodeList(List<HdMapLaneNodeTopologyRes> laneNodeList) {
        this.laneNodeList = laneNodeList;
    }
}
