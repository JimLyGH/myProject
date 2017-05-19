package com.jimly.kayak.cases.demo1013;

public class Entrance {

	public static void main(String[] args) {

		chkNum(-1);

	}

	public static void chkNum(int num) {
		if (num < 0) {
			try {
				throw new MyException("参数【" + num + "】不合法,必须大于0.");
			} catch (MyException e) {
				e.printStackTrace();
			}
		}
	}
}
