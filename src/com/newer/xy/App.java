package com.newer.xy;

import java.io.File;

public class App {
	public static void main(String[] args) {
		File file = new File("F://test");
		MDUtil.getMD5(file);
	}
}
