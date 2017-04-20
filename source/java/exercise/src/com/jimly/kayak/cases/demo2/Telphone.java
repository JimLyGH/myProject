package com.jimly.kayak.cases.demo2;

public class Telphone {

	private int price;
	
	public Telphone(int price) {
		this.price = price;
	}
	
	public void company(){
		System.out.println("Telphone");
	}
	
	public void call(){
		System.out.println("Telphone call");
	}
	
	
	static class XiaoMi{
		
		static String uName = "leijun";
		
		public XiaoMi() {
			System.out.println("XiaoMi init " + uName);
		}
		
		public void company() {
			System.out.println("XiaoMi");
		}
		
	}
	
	class IPhone {
		
		public IPhone() {
			System.out.println(Telphone.this.price);
		}
		
		public void company() {
			System.out.println("IPhone");
		}
		
	}
	
	
}
