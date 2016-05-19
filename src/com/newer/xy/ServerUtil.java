package com.newer.xy;

/**
 * 服务器工具类		 封装服务器的各种操作
 */
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class ServerUtil {
	/**
	 * 服务器接受文件的方法
	 * 
	 * @param serverSocket
	 *            客户端套接字
	 */
	public static void downLoadfile(ServerSocket serverSocket) {

		try {
			Socket socket = serverSocket.accept();
			InputStream inputStream = socket.getInputStream();

			// 读取存放文件名的字节数组
			byte[] fileNameBytes = new byte[1024 * 16];
			int fileNameLength = inputStream.read(fileNameBytes);

			String fileName = new String(fileNameBytes, 0, fileNameLength);

			System.out.println(fileName);
			
			LinkedList<String> list = new LinkedList<>();
			//获得服务器上所有的文件
			File file = new File("F://" + fileName);
			File[] fs = (new File(file.getParent())).listFiles();
			
			for (File f : fs) {
				String MD5 = FileUtil.getMD5(f); 
				String fName = FileUtil.getFilename(f, MD5); 
				list.add(fName);
				
				System.out.println(fName);
			}
			if (list.contains(fileName)) {
				System.out.println("已经秒传");
			} else {

				BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(new File("F://" + fileName)));

				byte[] buffer = new byte[1024 * 1024];
				int i;
				while ((i = inputStream.read(buffer)) != -1) {
					// i = inputStream.read(buffer, 0, buffer.length);
					// i= inputStream.read();
					bo.write(buffer, 0, i);
				}
				inputStream.close();
				bo.flush();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
