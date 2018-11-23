package com.utility;

import com.eSign.init.Common;

public class temp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String mail ="prashantp@accorin.com";
		
		String[] a =mail.split("@");
		System.out.println(a[0]);
		System.out.println("==============");
		System.out.println(a[1]);
		String newemail = a[0]+"+"+Common.generateRandomNumber(6)+"@"+a[1];
		System.out.println(newemail);
	}

}
