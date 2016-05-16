package com.newer.xy;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.OutputUtil;

public class ClientUtil {
	
	private String address = "127.0.0.1";
	private int port = 9000 ;
	private Socket socket;
	

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}


	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}


	public  void login () throws 
	UnknownHostException, IOException{
		socket = new Socket(address,port);	
	}
	
	public void upLoadFile (File file,String MD5){
				
		try {
			
//			BufferedReader reader = new BufferedReader(new 
//				InputStreamReader(new FileInputStream(file)));
			
			BufferedInputStream inputStream = new BufferedInputStream(
					new FileInputStream(file));
			
			OutputStream outputStream = socket.getOutputStream();
			
			//发送文件的MD5值
			outputStream.write(MD5.getBytes());
			
			byte[] bytes = new byte[1024*16];
//			int length = inputStream.read(bytes,0,bytes.length);
			int length ;
			
			while((length=inputStream.read(bytes)) != -1){
				outputStream.write(bytes, 0, length);
			}
			
			inputStream.close();
			outputStream.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
