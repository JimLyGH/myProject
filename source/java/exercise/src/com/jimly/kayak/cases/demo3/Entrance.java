package com.jimly.kayak.cases.demo3;


/**
 * 1���ӿ�֧�ֶ�̳�,��(��ͨ��ͳ�����)��֧�ֶ�̳�
 * 2��һ����̳��˳������ʵ����ĳ���ӿ�,��Ҫ�����еĳ��󷽷�����ȫ��ʵ��,������Ҫ������Ϊ������
 * 3���ӿڱȳ����������
 * 4��������ͽӿڶ�����ʵ����,���ǿ��Զ��������ͽӿڵ�����
 * 5���г��󷽷�������붨��Ϊ������,��������δ��Ҫ�г��󷽷�
 * */
public class Entrance {

	public static void main(String[] args) {
		
		System.out.println("########## CLASS ONE  ##########");
		Man man = new Class1();
		man.work();
		
		Women women = new Class1();
		women.cook();
		
		People people = new Class1();
		people.head();
		
		Class1 cla1 = new Class1();
		cla1.country();
		
		System.out.println("########## CLASS TWO  ##########");
		Class2 cla2 = new Class2();
		cla2.eat();
		cla2.driver();
		cla2.study();
		
		System.out.println("########## CLASS THREE  ##########");
		Abstract3 abstract3 = new Class3("zhangsan");
		abstract3.read();
		abstract3.sleep();
		
		
	}
	
}
