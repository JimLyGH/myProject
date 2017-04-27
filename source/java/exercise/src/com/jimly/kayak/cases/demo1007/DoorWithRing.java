package com.jimly.kayak.cases.demo1007;


/**
 * 定义了一个既有警报又有猫眼的门
 * 
 * 接口：like a / has a
 * 抽象类：is a
 * 
 * 接口定义的是一组规则，体现为一种能力
 * 需要实现特定的多项功能,而这些功能间可能完全没有任何联系
 * 	例如：报警和猫眼功能只是门的一个接口,形式上只是点缀效果
 * 		电脑案例说明：
 * 			抽象类：CPU、显示器、显卡(共有的一组属性)
 * 			接口    ：USB、外接键盘(起到点缀效果的属性)
 * 接口类名的格式一般都会以I开头
 * 
 * 另一种说法：(说的有点模糊)
 * 	抽象类是使用动机是为了代码的复用,接口使用动机是为了实现多态
 * */
public class DoorWithRing extends Door implements IAlarm, ICatEye{

	@Override
	public void doorBell() {
		System.out.println("IAlarm doorBell");
	}

	@Override
	void open() {
		System.out.println("Door open");
	}

	@Override
	void close() {
		System.out.println("Door close");
	}

	@Override
	public void see() {
		System.out.println("ICatEye see");
	}

}
