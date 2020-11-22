package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

import mainFrame.PLoginDialog;
import mainFrame.PMainFrame;
import model.MUser;
import valueObject.VLogin;

public class UserClient extends JOptionPane{

	Socket socket;
	private PLoginDialog pLoginDialog;
	
	public UserClient() {
		
		startClient();
		
	}
	
	private void startClient() {

		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress("localhost", 5001));
			
			System.out.println("Success connect");
		} catch(IOException e) {
//					System.out.println("Fail connect Server is closed");
			if(!socket.isClosed()) {
				stopCient();
				return;
			}
		}

	}
	
	public void stopCient() {
		System.out.println("Stop client");
		JOptionPane.showMessageDialog(this.pLoginDialog, "서버가 닫쳐있습니다.\n다음에 다시 시도하세요.", "알림", JOptionPane.ERROR_MESSAGE);
		try {
			if(socket != null && !socket.isClosed()) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	private  String receive() {
		
		String data = "";		

		try {
			byte[] byteArr = new byte[5000];
			InputStream inputStream = socket.getInputStream();
			
			int readByteCount = inputStream.read(byteArr);
			if(readByteCount == -1) {
				System.out.println("disconnect inputstream");
				throw new IOException();
			}
			
			String originData = new String(byteArr, 0, readByteCount, "UTF-8");
			String[] dataArr = originData.split(" ");
			// data의 타입을 제거하고 1번부터 보내기 위함.
			for(int i = 1; i < dataArr.length; i++) {
				data += dataArr[i] + " ";
			}
			System.out.println("=================Receive===============");
			System.out.println(originData);
			System.out.println("=======================================");

			
		} catch(Exception e) {
			System.out.println("close at receive section");
			stopCient();
		
		}		
		
		return data;
	}
	
	public String send(String type, Object data) {
		
		String receiveData = null;
		try {	
								
			String sendData = type + " " + data.toString();
			System.out.println("==================SEND=================");
			System.out.println(sendData);
			System.out.println("=======================================");
			byte[] byteArr = sendData.getBytes("UTF-8");				
			OutputStream outputStream = socket.getOutputStream();				
			outputStream.write(byteArr);				
			outputStream.flush();
			// 원하는 데이터를 Server에 Send(요청)한 후 데이터를 받기
			receiveData = receive();
			
		} catch(Exception e) {
			
			e.printStackTrace();
			stopCient();
			
		}
		
		return receiveData;
		
	}
	
}
