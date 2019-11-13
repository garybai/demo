package com.example.unnameddemo.test;

import cn.hutool.core.bean.BeanUtil;

/**
 * @author Gary
 * @className Test
 * @description TODO
 * @date 2019-04-21 18:00
 **/
public class Test {

    //    public static void main(String[] args) {
//        SeasonEnum spring = SeasonEnum.SPRING;
//        System.out.println("SPRING枚举值：" + spring.name());
//
//        int index = StatusEnum.Doing.getIndex();
//        System.out.println("状态Doing的索引值为：" + index);
//        StatusEnum statusEnum = StatusEnum.getValueByIndex(2);
//        System.out.println("索引值为2的枚举值是：" + statusEnum);
//
//        Integer index1 = MonthEnum.Apr.getIndex();
//        System.out.println("Apr 对应的索引值为：" + index1);
//        MonthEnum monthEnum = MonthEnum.valueOf(5);
//        System.out.println("索引为5的枚举值是：" + monthEnum);
//
//        Integer i = WeekDayEnum.MON.getIndex();
//        System.out.println("MON的索引值为：" + i);
//        Integer ii = WeekDayEnum.getIndexByValue("星期日");
//        System.out.println("星期日的索引值为：" + ii);
//        String value = WeekDayEnum.getValueByName("FRI");
//        System.out.println("FRI的value为：" + value);
//        String v = WeekDayEnum.getValueByIndex(4);
//        System.out.println("索引值为4的value为：" + v);
//        Map<Integer, String> map = WeekDayEnum.getIndexValueMap();
//        System.out.println(map);
//
//    }
    public static void main(String[] args) {

        CarPO carPO = new CarPO(100L, "BMW");
        UserPO userPO = new UserPO(1L, "aa", 10, "社会,民生,生活", carPO);
        UserDTO userDTO = new UserDTO();

        try {
            BeanUtil.copyProperties(userPO, userDTO);
            System.out.println(userPO);
            System.out.println(userDTO);
            System.out.println(userDTO.getTags().size());
        }catch (Exception e){
            System.out.println("转换错误");
        }

//        Map<String, Object> x = BeanUtil.beanToMap(userDTO);
//        System.out.println(x);

//        Map<String, Object> y = new HashMap<>(4);
//        y.put("id", 10L);
//        y.put("name", "bb");
//        y.put("carPO", carPO);
//        UserDTO userDTO1 = new UserDTO();
//        System.out.println(BeanUtil.fillBeanWithMap(y, userDTO1, true));

    }
}
