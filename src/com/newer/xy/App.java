package com.newer.xy;

import java.io.File;

public class App {
	public static void main(String[] args) {
		File file = new File("F:\\1.jpg");
		FileUtil.getMD5(file);
		String fileName=file.getName();
	    String prefix="." + fileName.substring(fileName.lastIndexOf(".")+1);
	    System.out.println("." + prefix);
		
	}
}
