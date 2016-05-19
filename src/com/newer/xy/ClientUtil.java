package com.newer.xy;

/**
 * 客户端工具类	封装客户端的各种操作
 */
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

	private static Socket socket;

	public void login(String address, int port) throws UnknownHostException, IOException {
		socket = new Socket(address, port);
	}

	/**
	 * 往服务器发送文件
	 * 
	 * @param file
	 *            要发送的文件
	 * @param MD5
	 *            发送文件的 MD5 值
	 */
	public static void upLoadFile(File file, String MD5) {

		try {

			// 获得文件拓展名
			String fileName = FileUtil.getFilename(file, MD5);
//			String fileName = file.getName();
//			String prefix = "." + fileName.substring(fileName.lastIndexOf(".") + 1);
//			String newFileName = MD5 + prefix;

			BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
			OutputStream outputStream = socket.getOutputStream();
			
			// 发送文件的MD5值
			outputStream.write(fileName.getBytes());

			byte[] bytes = new byte[1024 * 16];
			// int length = inputStream.read(bytes,0,bytes.length);
			int length;

			while ((length = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, length);
			}

			inputStream.close();
			outputStream.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 往服务器发送文件夹
	 * 
	 * @param file
	 *            要发送的文件夹
	 * @param MD5
	 *            发送文件夹的 MD5 值
	 */
	public static void uploadDir(File file, String MD5) {

	}

}
