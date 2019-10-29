package com.example.unnameddemo.enumdemo;

/**
 * TODO
 *
 * @author Gary
 * @date 2019-04-21 22:11
 */
public enum MonthEnum {

    //1月
    Jan(1),
    //2月
    Feb(2),
    //3月
    Mar(3),
    //4月
    Apr(4),
    May(5),
    Jun(6),
    Jul(7),
    Aug(8),
    Sep(9),
    Oct(10),
    Nov(11),
    Dec(12);

    private Integer index;

    public Integer getIndex() {
        return index;
    }

    MonthEnum(Integer index) {
        this.index = index;
    }

    /**
     * 根据索引获取对应的枚举对象
     *
     * @param index
     * @return
     */
    public static MonthEnum valueOf(Integer index) {
        MonthEnum[] values = MonthEnum.values();
        for (MonthEnum value : values) {
            if (value.getIndex().equals(index)) {
                return value;
            }
        }
        return null;
    }

}
