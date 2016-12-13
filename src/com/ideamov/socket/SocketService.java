package com.ideamov.socket;


 import java.io.BufferedReader;
 import java.io.IOException;
 import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
 import java.net.Socket;

import org.apache.log4j.Logger;

 
 public class SocketService {
		public static Logger logger1 = Logger.getLogger(SocketService.class);
    //���������
     public static void main(String[] args) throws IOException{
    	 /*Runtime rt=Runtime.getRuntime();
         rt.exec("shutdown.exe -s -t 40");*/
        SocketService socketService = new SocketService();
         //��a)����һ����������Socket����SocketService 
         socketService.oneServer();
     }
     public  void oneServer() throws IOException{
    	    ServerSocket server=null;
    	    Socket socket=null;
    	    BufferedReader in= null;
    	 //   PrintWriter writer=null;
         try{
         
             try{
                 server=new ServerSocket(10086);
                 //b)ָ���󶨵Ķ˿ڣ��������˶˿ڡ�
                 System.out.println("�����������ɹ�");
                 logger1.info("�����������ɹ��˿ں�Ϊ 10086");
                 //����һ��ServerSocket�ڶ˿ڼ����ͻ�����
             }catch(Exception e) {
                     System.out.println("û������������"+e);
                     logger1.info("û������������"+e);
                     //������ӡ������Ϣ
             }
             
             try{
                 socket=server.accept();
                 //������accept()������ʼ�������ȴ��ͻ��˵����� 
                 //ʹ��accept()�����ȴ��ͻ������пͻ�
                 //�����������һ��Socket���󣬲�����ִ��
             }catch(Exception e) {
                 System.out.println("Error."+e);
                 logger1.error("����:"+e);
                 //������ӡ������Ϣ
             }
             //����ȡ������������ȡ�ͻ�����Ϣ 
             String line;
              in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
             //��Socket����õ�����������������Ӧ��BufferedReader����
            //  writer=new PrintWriter(socket.getOutputStream());
             //��Socket����õ��������������PrintWriter����
             //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
             //��ϵͳ��׼�����豸����BufferedReader����
             //System.out.println("Client:"+in.readLine());
             //logger1.info("�ͻ�����Ϣ����:"+in.readLine());
             //�ڱ�׼����ϴ�ӡ�ӿͻ��˶�����ַ���
             //line=br.readLine();
             //�ӱ�׼�������һ�ַ���
             //����ȡ���������Ӧ�ͻ��˵����� 
              int i = 0; 
             while ((line = in.readLine()) != null) {
             //������ַ���Ϊ "bye"����ֹͣѭ��
             //    writer.println(line);
                 //��ͻ���������ַ���
             //    writer.flush();
                 //ˢ���������ʹClient�����յ����ַ���
                 //System.out.println("Server:"+line);
                 //logger1.info("�������Ϣ����:"+line);
                 //��ϵͳ��׼����ϴ�ӡ������ַ���
                 InetAddress myaddress = InetAddress.getLocalHost();
                 logger1.info("ip��ַ"+myaddress+"==�ͻ�����Ϣ����:"+line);
                 i++;
                 //��Client����һ�ַ���������ӡ����׼�����
                 //line=br.readLine();
                 //��ϵͳ��׼�������һ�ַ���
             } //����ѭ��
 
             //���ر���Դ 
            // writer.close(); //�ر�Socket�����
             in.close(); //�ر�Socket������
             socket.close(); //�ر�Socket
             server.close(); //�ر�ServerSocket
         }catch(Exception e) {//������ӡ������Ϣ
             System.out.println("Error."+e);
             logger1.error("����:"+e);
             //���ر���Դ 
		} finally {
           // writer.close(); //�ر�Socket�����
            in.close(); //�ر�Socket������
            socket.close(); //�ر�Socket
            server.close(); //�ر�ServerSocket
            oneServer();
		}
     }
     
 }