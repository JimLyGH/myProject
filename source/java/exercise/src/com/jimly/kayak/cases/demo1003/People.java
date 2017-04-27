package com.jimly.kayak.cases.demo1003;

/**
 * 接口支持多继承,类不支持多继承
 * */
public interface People extends Man, Women{
	
	/** 头 People */
	public void head();
	
	/** 手 People */
	public void hand();
	
	/** 眼睛 People */
	public void eye();

	/** 脚  People */
	public void foot();
}
