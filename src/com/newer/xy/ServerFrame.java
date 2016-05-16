package com.newer.xy;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JButton;

public class ServerFrame extends JFrame {
	
	private JTextField textIp;
	private JTextField textPort;
	private JLabel labelport;
	private JLabel labelIp;
	private JButton buttonOnline; 
	private int port = 9000;
	private ServerSocket serverSocket;
	private Socket socket;
	
	public static void main(String[] args) {
		ServerFrame serverFrame = new ServerFrame();
	}

	public ServerFrame() {
		
		
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(null);
		labelIp = new JLabel("IP");
		labelIp.setBounds(69, 10, 54, 15);
		getContentPane().add(labelIp);
		textIp = new JTextField();
		textIp.setBounds(105, 10, 66, 21);
		getContentPane().add(textIp);
		textIp.setColumns(10);
		textIp.setText("127.0.0.1");
		
		labelport = new JLabel("端口");
		labelport.setBounds(232, 13, 54, 15);
		getContentPane().add(labelport);
		
		textPort = new JTextField();
		textPort.setBounds(276, 7, 66, 21);
		getContentPane().add(textPort);
		textPort.setColumns(10);
		textPort.setText(String.valueOf(port));
		
		buttonOnline = new JButton("登陆");
		buttonOnline.setBounds(154, 178, 93, 23);
		getContentPane().add(buttonOnline);
		
		buttonOnline.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					serverSocket = new ServerSocket(port);
					System.out.println("服务器启动");
					socket = serverSocket.accept();
					
					BufferedInputStream inputStream = new BufferedInputStream(
							socket.getInputStream());
					
					//读取存放MD5值的字节数组
					byte[] MD5Bytes = new byte[1024]; 
					int MD5Length =	inputStream.read();
					
					String MD5 = new String(MD5Bytes, 0, MD5Length);
					
					System.out.println(MD5);
					BufferedOutputStream pw = new BufferedOutputStream(new
							FileOutputStream(new File("F://test")));
					
					
					byte[] buffer = new byte[2048];
					int i = inputStream.read(buffer);
					while(i != -1){
						i = inputStream.read(buffer);
						pw.write(buffer);
					}
					inputStream.close();
					pw.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
			
	}
}
