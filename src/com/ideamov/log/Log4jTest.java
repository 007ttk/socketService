package com.ideamov.log;

import org.apache.log4j.Logger;

public class Log4jTest {
	public static Logger logger1 = Logger.getLogger(Log4jTest.class);
	   public static void main(String[] args) {
	       //logger1
	       logger1.trace("我是logger1，trace");
	       logger1.debug("我是logger1，debug");
	       logger1.info("我是logger1，info");
	       logger1.warn("我是logger1，warn");
	       logger1.error("我是logger1，error");
	       logger1.fatal("我是logger1，fatal");
	   }
}
