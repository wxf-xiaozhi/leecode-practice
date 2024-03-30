package com.ifyou.dijkstra;


import java.util.UUID;

/**
 * 道路连接节点
 */
public class HdMapLaneNodeTopologyRes {

    /**
     * ID
     */
    private UUID id;

    /**
     * NODE编号
     */
    private Integer nodeSn;

    /**
     * NODE类型
     */
    private Integer nodeType;

    /**
     * 纬度
     */
    private Double lat;

    /**
     * 经度
     */
    private Double lon;

    /**
     * 高程
     */
    private Double alt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getNodeSn() {
        return nodeSn;
    }

    public void setNodeSn(Integer nodeSn) {
        this.nodeSn = nodeSn;
    }

    public Integer getNodeType() {
        return nodeType;
    }

    public void setNodeType(Integer nodeType) {
        this.nodeType = nodeType;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getAlt() {
        return alt;
    }

    public void setAlt(Double alt) {
        this.alt = alt;
    }
}
