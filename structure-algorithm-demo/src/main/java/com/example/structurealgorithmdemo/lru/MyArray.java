package com.example.structurealgorithmdemo.lru;

/**
 * 自己封装的数组
 *
 * @author Gary
 * @date 2019/12/7 19:38
 * @since jdk1.8
 **/
public class MyArray {
    /**
     * 存放数据的数组
     */
    private int[] intArr;
    /**
     * 实际存放元素的个数
     */
    private int elements;
    /**
     * 数组的最大长度
     */
    private int length;

    /**
     * 默认构造一个长度为 20 的数组
     */
    public MyArray() {
        elements = 0;
        length = 20;
        intArr = new int[20];
    }

    /**
     * 构造方法，传入数组的总长度
     *
     * @param length
     */
    public MyArray(int length) {
        elements = 0;
        this.length = length;
        intArr = new int[length];
    }

    /**
     * 获取数组实际存放的元素个数
     *
     * @return
     */
    public int getSize() {
        return elements;
    }

    /**
     * 遍历显示数组
     */
    public void display() {
        for (int i = 0; i < elements; i++) {
            System.out.print(intArr[i] + " ");
        }
        System.out.println("");
    }

    /**
     * 数组尾部添加元素，默认不能添加重复元素
     *
     * @param value
     * @return 添加成功返回 true，添加失败返回 false，如果数组已满，添加失败
     */
    public boolean addTail(int value) {
        if (elements == length) {
            return false;
        }
        intArr[elements] = value;
        elements++;
        return true;
    }

    /**
     * 数组头部添加元素
     *
     * @param value
     * @return
     */
    public boolean addHead(int value) {
        if (elements == length) {
            return false;
        }
        if (elements == 0){
            intArr[0] = value;
            elements++;
            return true;
        }

        elements++;
        int temp = elements - 1;
        while (temp >= 1){
            intArr[temp] = intArr[temp - 1];
            temp--;
        }

        intArr[0] = value;
        return true;
    }

    /**
     * 根据下标获取元素
     *
     * @param index
     * @return 如果下标超如有效值，提示越界
     */
    public int get(int index) {
        if (index < 0 || index > elements) {
            System.out.println("访问越界");
        }
        return intArr[index];
    }

    /**
     * 根据值查找下标，如果找不到就返回-1
     * 从头开始正向查找
     *
     * @param value
     * @return
     */
    public int find(int value) {
        int index = -1;
        for (int i = 0; i < elements; i++) {
            if (intArr[i] == value) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 根据值查找下标，如果找不到就返回-1
     * 从尾开始反向查找
     *
     * @param value
     * @return
     */
    public int findReverse(int value) {
        int index = -1;
        int temp = elements - 1;
        while (temp >= 0) {
            if (intArr[temp] == value) {
                index = temp;
                break;
            }
            temp--;
        }
        return index;
    }

    /**
     * 根据值删除元素
     *
     * @param value
     * @return 删除成功返回 true，删除失败返回 false，删除的值不存在，返回 false
     */
    public boolean delete(int value) {
        int index = find(value);
        return deleteByIndex(index);
    }

    public boolean deleteByIndex(int index) {
        if (index < 0 || index >= elements) {
            return false;
        }
        if (index == elements - 1) {
            elements--;
            return true;
        }
        for (int i = index; i < elements - 1; i++) {
            intArr[i] = intArr[i + 1];
        }
        elements--;
        return true;
    }

    /**
     * 修改值
     *
     * @param oldValue
     * @param newValue
     * @return 修改成功返回 true，修改失败返回 false
     */
    public boolean modify(int oldValue, int newValue) {
        int index = find(oldValue);
        if (index == -1) {
            System.out.println("要删除的值不存在");
            return false;
        }
        intArr[index] = newValue;
        return true;
    }

}
