package com.ideamov.log;

import org.apache.log4j.Logger;

public class Log4jTest {
	public static Logger logger1 = Logger.getLogger(Log4jTest.class);
	   public static void main(String[] args) {
	       //logger1
	       logger1.trace("����logger1��trace");
	       logger1.debug("����logger1��debug");
	       logger1.info("����logger1��info");
	       logger1.warn("����logger1��warn");
	       logger1.error("����logger1��error");
	       logger1.fatal("����logger1��fatal");
	   }
}
