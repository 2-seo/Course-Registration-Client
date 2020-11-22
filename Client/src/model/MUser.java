package model;

import java.util.Scanner;
import java.util.StringTokenizer;

public class MUser {

	private String stuNum;
	private String name;
	private String password;
	private String majorId;
	private String major;
	private String address;
	private String hint;
	
	private Scanner scanner;
	
	public MUser(Scanner scanner) {
		this.scanner = scanner;
		
	}
	
	public String getStuNum() {
		return stuNum;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getMajorId() {
		return majorId;
	}
	public String getMajor() {
		return major;
	}
	public String getAddress() {
		return address;
	}
	
	public String getHint() {
		return hint;
	}

	@Override
	public String toString() {
		String data = stuNum + " " + name + " " + password + " " + majorId + " " + major + " " + address;
		System.out.println(data);
		return data;
	}
	
	public void read() {
		this.stuNum = scanner.next();
		this.name = scanner.next();
		this.password = scanner.next();
		this.majorId = scanner.next();
		this.major = scanner.next();
		this.address = scanner.next();
		this.hint = scanner.next();
		if(this.hint.equals("null")) {
			this.hint = "";
		}
	
	}
	
	
	
	
}
