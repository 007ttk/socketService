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
     // ��ͻ���
    	 public static void main(String[] args) throws IOException   {
    			//1.����Socket�ͻ��˶�������ָ�������ip��ַ���˿ں� �����Ӿܾ��쳣:java.net.ConnectException: Connection timed out: connect��
    			Socket cilent = null;
    			try {
    				cilent = new Socket("101.200.200.228", 10086);
    			} catch (Exception e) {
    				e.printStackTrace();
    			} 
    			finally {
    		    //����ͨ��ʧ�ܡ����ܷ���˳����ڹر�״̬������ȷ�Ͽ���ʱ�䡢ÿ��ʱ��˺����������ӡ�ֱ�����ӳɹ�
    				
    			}
    		    //2.�����ַ����������
    			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(cilent.getOutputStream()));
    			String baseData = null;
    			while (true) {
    				
    				if ("".equals(baseData)) {
    					break;                 //�Զ����������
    				}
    				 //��̬��ȡ��վ���ݲ��Զ��ŷָ�ת���ɴ˸�ʽ
    				baseData="20160101000000,460014405235012,352304060047297,13567890000,0086"; 
    	               
    				
    				bw.write(baseData);
    				bw.newLine();
    				bw.flush();
    			}
    			// �ͷ���Դ
    			cilent.close();
    		}
 
 }