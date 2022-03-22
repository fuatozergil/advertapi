package com.poc.ilanapi.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.util.ResourceUtils;

/**
 * @author fuatozergil
 *
 */
public class Util {

	/**
	 * Detects header is in badwords or not
	 * 
	 * @param header
	 * @return
	 * @throws IOException
	 */
	public static boolean detectNotInBadWords(String header) throws IOException {

		File file = ResourceUtils.getFile("classpath:Badwords.txt");
		InputStream in = new FileInputStream(file);
		BufferedReader bf1 = null;
		try {
			bf1 = new BufferedReader(new java.io.InputStreamReader(in));
			String line1 = "";
			while ((line1 = bf1.readLine()) != null) {
				if (header != null && line1.equals(header)) {
					return false;
				}
			}
		} finally {
			bf1.close();
		}

		return true;

	}

}
