package com.example.unnameddemo.enumdemo;

import java.util.HashMap;
import java.util.Map;

/**
 * 星期枚举类
 *
 * @author Gary
 * @date 2019-04-21 22:29
 */
public enum WeekDayEnum {

    // 星期日
    SUN(0, "星期日"),
    MON(1, "星期一"),
    TUE(2, "星期二"),
    WED(3, "星期三"),
    THU(4, "星期四"),
    FRI(5, "星期五"),
    SAT(6, "星期六");

    private Integer index;
    private String value;

    WeekDayEnum(Integer index, String value) {
        this.index = index;
        this.value = value;
    }

    public Integer getIndex() {
        return index;
    }

    public String getValue() {
        return value;
    }

    /**
     * 根据枚举名称获得value
     * 比如根据“FRI”得到“星期五”
     *
     * @param name
     * @return java.lang.String
     * @author Gary
     * @date 2019-04-21 22:35
     */
    public static String getValueByName(String name) {
        WeekDayEnum[] values = WeekDayEnum.values();
        for (WeekDayEnum value : values) {
            if (value.name().equals(name)) {
                return value.getValue();
            }
        }
        return null;
    }

    /**
     * 根据属性value获取属性index:
     * 比如根据 "星期三" 得到 3
     *
     * @param value
     * @return Integer
     */
    public static Integer getIndexByValue(String value) {
        for (WeekDayEnum weekDayEnum : WeekDayEnum.values()) {
            String v = weekDayEnum.getValue();
            if (v.equals(value)) {
                return weekDayEnum.getIndex();
            }
        }
        return null;
    }

    /**
     * 根据属性index获取属性value
     * 比如根据 3 得到 "星期三"
     *
     * @param index
     * @return
     */
    public static String getValueByIndex(Integer index) {
        for (WeekDayEnum weekDayEnum : WeekDayEnum.values()) {
            Integer in = weekDayEnum.getIndex();
            if (in.equals(index)) {
                return weekDayEnum.getValue();
            }
        }
        return null;
    }

    /**
     * 根据属性index获取对应的枚举值:
     * 比如根据 3 得到枚举值 WED
     *
     * @param index
     * @return
     */
    public static WeekDayEnum getNameByIndex(Integer index) {
        for (WeekDayEnum weekDayEnum : WeekDayEnum.values()) {
            if (weekDayEnum.getIndex().equals(index)) {
                return weekDayEnum;
            }
        }
        return null;
    }

    /**
     * 返回一个由index和value组成的map集合:
     * {0=星期日, 1=星期一, 2=星期二, 3=星期三, 4=星期四, 5=星期五, 6=星期六}
     *
     * @return
     */
    public static Map<Integer, String> getIndexValueMap() {
        Map<Integer, String> map = new HashMap<>();
        for (WeekDayEnum weekDayEnum : WeekDayEnum.values()) {
            Integer index = weekDayEnum.getIndex();
            String value = weekDayEnum.getValue();
            map.put(index, value);
        }
        return map;
    }

}
