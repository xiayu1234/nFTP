package com.newer.xy;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class FtpFrame extends JFrame{
	
	private JPanel panel;
	private JButton choseBtn;
	private JButton sendBtn;
	File file;
	private JLabel labelFilename;
	private JLabel label1;

	
	
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
		
		choseBtn.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showDialog(FtpFrame.this, "确定");
				
				file = chooser.getSelectedFile();
				labelFilename.setText(file.getName());
				
			}
		});
		
		sendBtn = new JButton("上传");
		sendBtn.setBounds(130, 248, 93, 23);
		panel.add(sendBtn);
		
		JButton cancleBtn = new JButton("取消");
		cancleBtn.setBounds(265, 248, 93, 23);
		panel.add(cancleBtn);
		
		labelFilename = new JLabel("New label");
		labelFilename.setBounds(198, 134, 117, 15);
		panel.add(labelFilename);
		
		label1 = new JLabel("已选择的文件");
		label1.setBounds(95, 134, 93, 15);
		panel.add(label1);
		
	}
}
