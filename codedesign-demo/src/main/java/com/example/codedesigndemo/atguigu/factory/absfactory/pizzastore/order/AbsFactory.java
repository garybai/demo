package com.example.codedesigndemo.atguigu.factory.absfactory.pizzastore.order;


import com.example.codedesigndemo.atguigu.factory.absfactory.pizzastore.pizza.Pizza;

//һ�����󹤳�ģʽ�ĳ����(�ӿ�)
public interface AbsFactory {
	//������Ĺ��������� ����ʵ��
	public Pizza createPizza(String orderType);
}
