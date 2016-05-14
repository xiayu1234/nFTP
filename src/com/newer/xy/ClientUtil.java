package com.newer.xy;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientUtil {
	
	private String address = "127.0.0.1";
	private int port ;
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
		Socket socket = new Socket(address,port);	
	}
	public void upLoadFile (File file,String MD5){
				
		try {
			FileReader reader = new FileReader(file); 
			PrintWriter pw=new PrintWriter(socket.getOutputStream());
			
			//发送文件的MD5值
			pw.write(MD5);
			
			char[] bufffer = new char[2048];
			
			if(reader.read(bufffer) != -1){
				pw.write(bufffer);
			}
			reader.close();
			pw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
