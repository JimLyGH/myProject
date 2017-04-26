package com.jimly.kayak.log4j;

import org.apache.log4j.Logger;

public class Entrance {
	
	private static Logger logger = Logger.getLogger(Entrance.class);
	
	public static void main(String[] args) {
		
		System.out.println(logger.isDebugEnabled());
		
		logger.fatal("this is a fatal");

		logger.error("this is a error");

		logger.warn("this is a warn");
		
		logger.debug("this is a debug");
		
		logger.info("this is a info");
		
	}

}
