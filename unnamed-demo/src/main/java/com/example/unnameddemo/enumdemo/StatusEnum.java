package com.example.unnameddemo.enumdemo;

/**
 * 订单状态枚举类
 *
 * @author Gary
 * @date 2019-04-27 19:29
 */
public enum StatusEnum {

    //未开始
    NotStart(0),

    //执行中
    Doing(1),

    //暂停
    Pause(2),

    //已完成
    Completed(3),

    //删除
    Del(4),

    //提前结束
    CutShort(5);

    private int index;

    StatusEnum(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    /**
     * 根据index返回对应的枚举值
     *
     * @param index
     * @return
     */
    public static StatusEnum getValueByIndex(int index) {
        switch (index) {
            case 0:
                return NotStart;
            case 1:
                return Doing;
            case 2:
                return Pause;
            case 3:
                return Completed;
            case 4:
                return Del;
            case 5:
                return CutShort;
            default:
                return null;
        }
    }

}
