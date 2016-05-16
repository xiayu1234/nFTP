package com.newer.xy;

import java.io.File;

public class App {
	public static void main(String[] args) {
		File file = new File("F://JSP.txt");
		MDUtil.getMD5(file);
	}
}
