package com.newer.xy;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ClientFrame extends JFrame {

	private JPanel panel;
	private JButton choseBtn;
	private JButton sendBtn;
	private JLabel labelFilename;
	private JLabel label1;
	private JButton Btnlogin;
	String MD5 = "null";
	File file;
	
	
	ClientUtil clientUtil = new ClientUtil();

	public static void main(String[] args) {
		ClientFrame frame = new ClientFrame();
	}

	public ClientFrame() {

		setSize(240, 160);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		choseBtn = new JButton("选择上传的文件");
		choseBtn.setBounds(29, 10, 152, 23);
		panel.add(choseBtn);

		sendBtn = new JButton("上传");
		sendBtn.setBounds(123, 82, 93, 23);
		panel.add(sendBtn);


		labelFilename = new JLabel("New label");
		labelFilename.setBounds(113, 57, 103, 15);
		panel.add(labelFilename);

		label1 = new JLabel("已选择的文件");
		label1.setBounds(10, 57, 93, 15);
		panel.add(label1);
		
		Btnlogin = new JButton("登陆");
		Btnlogin.setBounds(10, 82, 93, 23);
		panel.add(Btnlogin);
		
		Btnlogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					clientUtil.login("127.0.0.1",9000);
					System.out.println("客户端已经登陆");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		choseBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				//设置chooser可以选择文件和目录
				chooser.setFileSelectionMode(chooser.FILES_AND_DIRECTORIES);
				chooser.showDialog(ClientFrame.this, "确定");

				file = chooser.getSelectedFile();
				labelFilename.setText(file.getName());
				MD5 = FileUtil.getMD5(file);

			}
		});
		
		sendBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ClientUtil.upLoadFile(file, MD5);
			}
		});

	}
}
