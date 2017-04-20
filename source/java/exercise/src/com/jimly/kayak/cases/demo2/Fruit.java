package com.jimly.kayak.cases.demo2;

public abstract class Fruit {
	
	private int num;
	
	public Fruit(int num) {
		this.setNum(num);
	}
	
	public abstract void apple();

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
