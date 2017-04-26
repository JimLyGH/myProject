package com.jimly.kayak.log4j;

import java.util.Date;

public class TipMessage {

	public static String tipInfo() {
		
		String content = 
				"您好：<br/>" +
				"<p>这个是" + new Date() + "对应的错误日志邮件,详细错误信息请查看如下表格：</p>";
		
		return content;
	}
	
}
