package com.ifyou.dijkstra;

/**
 * @author GW00300432
 */

public enum TopologyLaneTypeEnum {

    FORWARD("正向驶入", 1),

    REVERSE("驶入倒车", 2),

    REPAIR_FORWARD("二次正向驶入", 3),

    REPAIR_REVERSE("二次驶入倒车", 4),

    LIFT_FORWARD("举斗正向", 5),

    EXIT("驶离", 6),

    WAIT_FORWARD("等待位正向驶入", 7),

    WAIT_REVERSE("等待位驶入倒车", 8),

    NORMAL_LANE("正常车道", 9),

    TURNING_LANE("回头车道", 10);

    private String displayName;

    private int code;

    TopologyLaneTypeEnum(String name, int code) {
        this.displayName = name;
        this.code = code;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getCode() {
        return code;
    }

    public static TopologyLaneTypeEnum valueOf(int value) {
        switch (value) {
            case 1:
                return TopologyLaneTypeEnum.FORWARD;
            case 2:
                return TopologyLaneTypeEnum.REVERSE;
            case 3:
                return TopologyLaneTypeEnum.REPAIR_FORWARD;
            case 4:
                return TopologyLaneTypeEnum.REPAIR_REVERSE;
            case 5:
                return TopologyLaneTypeEnum.LIFT_FORWARD;
            case 6:
                return TopologyLaneTypeEnum.EXIT;
            case 7:
                return TopologyLaneTypeEnum.WAIT_FORWARD;
            case 8:
                return TopologyLaneTypeEnum.WAIT_REVERSE;
            case 9:
                return TopologyLaneTypeEnum.NORMAL_LANE;
            case 10:
                return TopologyLaneTypeEnum.TURNING_LANE;
            default:
                return null;

        }
    }
}
