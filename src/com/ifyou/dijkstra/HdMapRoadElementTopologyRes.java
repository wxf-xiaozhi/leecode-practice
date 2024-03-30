package com.ifyou.dijkstra;



import java.util.UUID;

/**
 * @author qiye
 */

public class HdMapRoadElementTopologyRes {

    /**
     * 路网元素ID
     */
    private UUID id;
    /**
     * 路网元素名称
     */
    private String elementName;
    /**
     * 路网元素类型
     */
    private Integer elementType;
    /**
     * 路网元素编号
     */
    private Integer elementSn;
    /**
     * 驶离参考线ID
     */
    private Integer exitLanId;
    /**
     * 驶入参考线ID
     */
    private Integer enterLanId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public Integer getElementType() {
        return elementType;
    }

    public void setElementType(Integer elementType) {
        this.elementType = elementType;
    }

    public Integer getElementSn() {
        return elementSn;
    }

    public void setElementSn(Integer elementSn) {
        this.elementSn = elementSn;
    }

    public Integer getExitLanId() {
        return exitLanId;
    }

    public void setExitLanId(Integer exitLanId) {
        this.exitLanId = exitLanId;
    }

    public Integer getEnterLanId() {
        return enterLanId;
    }

    public void setEnterLanId(Integer enterLanId) {
        this.enterLanId = enterLanId;
    }
}
