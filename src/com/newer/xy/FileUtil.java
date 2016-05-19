package com.newer.xy;

import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 封装对文件的操作
 * 
 * @author xiayu
 *
 */
public class FileUtil {

	private static String m;

	/**
	 * 获得文件的 MD5值
	 * 
	 * @param file
	 * @return
	 */
	public static String getMD5(File file) {
		return get(file, "MD5");
	}

	public static String getSHA(File file) {
		return get(file, "SHA-1");
	}

	/**
	 * 通过文件和MD5获得进行MD5转换后的文件名
	 * 
	 * @param file
	 *            文件
	 * @param MD5
	 *            文件的Md5值
	 * @return 操作后获得的文件名
	 */
	public static String getFilename(File file, String MD5) {
		String name = file.getName();
		String prefix = "." + name.substring(name.lastIndexOf(".") + 1);
		String FileName = MD5 + prefix;
		return FileName;
	}

	private static String get(File file, String algorithm) {

		// 函数包
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);

			String fileName = file.getName();
			byte[] data = fileName.getBytes();
			byte[] result = md.digest(data);

			// 字节数组转换为十六进制数
			BigInteger b = new BigInteger(1, result);
			// 整数转换为字符串：数值系统
			m = b.toString(16);
//			System.out.println(m);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return m;
	}

}
