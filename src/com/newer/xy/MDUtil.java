package com.newer.xy;

import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 生成文件的数字摘要（MD5、SHA1、CRC）
 * 
 * @author xiayu
 *
 */
public class MDUtil {
	/**
	 * 获得文件的 MD5值
	 * 
	 * @param file
	 * @return
	 */
	public static String getMD5(File file){
		return get(file, "MD5");
	}
	
	public static String getSHA(File file){
		return get(file, "SHA-1");
	}
	
	private static String get(File file,String algorithm) {

		// 函数包
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			
			byte[] data = "".getBytes();
			byte[] result = md.digest(data);
			
//			System.out.println(result.length);
//			System.out.println(Arrays.toString(result));
			
			//字节数组转换为十六进制数
			BigInteger b = new BigInteger(1, result);
//			System.out.println(b.toString());
			//整数转换为字符串：数值系统
			String m = b.toString(16);
//			System.out.println(m);
			return m;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
		
}
