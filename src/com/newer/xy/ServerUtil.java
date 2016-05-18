package com.newer.xy;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerUtil {

	public static void downLoadfile(ServerSocket serverSocket) {

		try {
			Socket socket = serverSocket.accept();
			InputStream inputStream = socket.getInputStream();

			// 读取存放MD5值的字节数组
			byte[] MD5Bytes = new byte[1024 * 16];
			int MD5Length = inputStream.read(MD5Bytes);

			String MD5 = new String(MD5Bytes, 0, MD5Length);

			System.out.println(MD5);

			File file = new File("F://" + MD5);
			if (file.exists()) {
				System.out.println("已经秒传");
			} else {

				BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(new File("F://" + MD5)));

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
