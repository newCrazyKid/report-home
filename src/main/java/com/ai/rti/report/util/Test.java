/**
 * 
 */
package com.ai.rti.report.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 * @param request
 * @param response
 * @return
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> depList = new ArrayList<String>();
		depList.add("2100000000");
		depList.add("2400000000");
		depList.add("2300000000");
		System.out.println(depList.contains("2900000000"));
	}

}
