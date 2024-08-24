package com.java_assignment;

import java.util.*;

public class Assignment_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter Full name:");
		Scanner sr = new Scanner(System.in);
		String name = sr.nextLine();
		System.out.println(name);
		System.out.print("Enter Roll No.:");
		int rollno = sr.nextInt();
		System.out.println(rollno);
		System.out.print("Enter Grade:");
		String grade = sr.next();
		System.out.println(grade);
		System.out.print("Enter Percentage:");
		double percentage = sr.nextDouble();
		System.out.print(percentage + "%");
		
	}
}
