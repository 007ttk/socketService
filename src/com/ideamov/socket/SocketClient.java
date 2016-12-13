package com.ideamov.socket;


 import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
 import java.io.InputStream;
 import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
 import java.net.InetAddress;
 import java.net.Socket;
 import java.net.URL;
 
 public class SocketClient {
     // 搭建客户端
    	 public static void main(String[] args) throws IOException   {
    			//1.创建Socket客户端对象、连接指定服务端ip地址及端口号 （连接拒绝异常:java.net.ConnectException: Connection timed out: connect）
    			Socket cilent = null;
    			try {
    				cilent = new Socket("101.200.200.228", 10086);
    			} catch (Exception e) {
    				e.printStackTrace();
    			} 
    			finally {
    		    //建立通信失败、可能服务端程序处于关闭状态、但不确认开启时间、每隔时间端后尝试重新连接、直至链接成功
    				
    			}
    		    //2.创建字符输出流对象
    			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(cilent.getOutputStream()));
    			String baseData = null;
    			while (true) {
    				
    				if ("".equals(baseData)) {
    					break;                 //自定义结束条件
    				}
    				 //动态获取基站数据并以逗号分割转化成此格式
    				baseData="20160101000000,460014405235012,352304060047297,13567890000,0086"; 
    	               
    				
    				bw.write(baseData);
    				bw.newLine();
    				bw.flush();
    			}
    			// 释放资源
    			cilent.close();
    		}
 
 }