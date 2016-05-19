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
import java.io.InputStream;
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

	public static void main(String[] args) {
		ServerFrame serverFrame = new ServerFrame();
	}

	public ServerFrame() {

		setSize(175, 139);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		getContentPane().setLayout(null);
		labelIp = new JLabel("IP");
		labelIp.setBounds(22, 13, 12, 15);
		getContentPane().add(labelIp);
		textIp = new JTextField();
		textIp.setBounds(61, 10, 66, 21);
		getContentPane().add(textIp);
		textIp.setColumns(10);
		textIp.setText("127.0.0.1");

		labelport = new JLabel("端口");
		labelport.setBounds(10, 41, 41, 15);
		getContentPane().add(labelport);

		textPort = new JTextField();
		textPort.setBounds(61, 38, 66, 21);
		getContentPane().add(textPort);
		textPort.setColumns(10);
		textPort.setText(String.valueOf(port));

		buttonOnline = new JButton("登陆");
		buttonOnline.setBounds(32, 66, 93, 23);
		getContentPane().add(buttonOnline);

		buttonOnline.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					ServerSocket serverSocket = new ServerSocket(9000);
					System.out.println("服务器启动");
					ServerUtil.downLoadfile(serverSocket);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

	}
}
