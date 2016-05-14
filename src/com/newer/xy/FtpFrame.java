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

public class FtpFrame extends JFrame {

	private JPanel panel;
	private JButton choseBtn;
	private JButton sendBtn;
	File file;
	private JLabel labelFilename;
	private JLabel label1;
	String MD5 = "null";
	private JButton Btnlogin;
	
	
	ClientUtil clientUtil = new ClientUtil();

	public static void main(String[] args) {
		FtpFrame frame = new FtpFrame();
	}

	public FtpFrame() {

		setSize(480, 320);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		choseBtn = new JButton("选择上传的文件");
		choseBtn.setBounds(116, 10, 228, 23);
		panel.add(choseBtn);

		sendBtn = new JButton("上传");
		sendBtn.setBounds(251, 248, 93, 23);
		panel.add(sendBtn);


		labelFilename = new JLabel("New label");
		labelFilename.setBounds(198, 134, 117, 15);
		panel.add(labelFilename);

		label1 = new JLabel("已选择的文件");
		label1.setBounds(95, 134, 93, 15);
		panel.add(label1);
		
		Btnlogin = new JButton("登陆");
		Btnlogin.setBounds(95, 248, 93, 23);
		panel.add(Btnlogin);
		
		Btnlogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					clientUtil.login();
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
				chooser.showDialog(FtpFrame.this, "确定");

				file = chooser.getSelectedFile();
				labelFilename.setText(file.getName());
				MD5 = MDUtil.getMD5(file);

			}
		});
		
		sendBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clientUtil.upLoadFile(file, MD5);
			}
		});

	}
}
