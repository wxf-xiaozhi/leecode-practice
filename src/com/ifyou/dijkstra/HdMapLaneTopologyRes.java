package com.ifyou.dijkstra;



import java.util.UUID;

/**
 * 车道线，道路
 */
public class HdMapLaneTopologyRes {

    /**
     * ID
     */
    private UUID id;

    /**
     * 路网元素类型
     */
    private Integer elementType;
    /**
     * 路网元素编号
     */
    private Integer elementSn;

    /**
     * 车道线编号
     */
    private Integer laneSn;

    /**
     * 车道线名称
     */
    private String laneName;

    /**
     * 前接点编号,不是车道线编号
     */
    private Integer preNodeSn;

    /**
     * 后接点编号,不是车道线编号
     */
    private Integer sucNodeSn;

    /**
     * 长度
     */
    private Integer laneLength;

    /**
     * 道路类型
     */
    private TopologyLaneTypeEnum laneType;

    public UUID getId() {
        return id;
    }

    public Integer getElementType() {
        return elementType;
    }

    public Integer getElementSn() {
        return elementSn;
    }

    public Integer getLaneSn() {
        return laneSn;
    }

    public String getLaneName() {
        return laneName;
    }

    public Integer getPreNodeSn() {
        return preNodeSn;
    }

    public Integer getSucNodeSn() {
        return sucNodeSn;
    }

    public Integer getLaneLength() {
        return laneLength;
    }

    public TopologyLaneTypeEnum getLaneType() {
        return laneType;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setElementType(Integer elementType) {
        this.elementType = elementType;
    }

    public void setElementSn(Integer elementSn) {
        this.elementSn = elementSn;
    }

    public void setLaneSn(Integer laneSn) {
        this.laneSn = laneSn;
    }

    public void setLaneName(String laneName) {
        this.laneName = laneName;
    }

    public void setPreNodeSn(Integer preNodeSn) {
        this.preNodeSn = preNodeSn;
    }

    public void setSucNodeSn(Integer sucNodeSn) {
        this.sucNodeSn = sucNodeSn;
    }

    public void setLaneLength(Integer laneLength) {
        this.laneLength = laneLength;
    }

    public void setLaneType(TopologyLaneTypeEnum laneType) {
        this.laneType = laneType;
    }
}
