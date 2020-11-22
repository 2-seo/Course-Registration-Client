package model;

import java.util.Scanner;
import java.util.StringTokenizer;

public class MInquire {

	private String no;
	private String title;
	private String content;
	private String stuNum;
	private String result;
	private StringTokenizer st;
	
	public MInquire(String no, String title, String content, String stuNum, String result) {
		
		this.no = no;
		this.title = title;
		this.content = content;
		this.stuNum = stuNum;
		this.result = result;
	}

	public MInquire(StringTokenizer st) {
		this.st = st;
	}

	public String getNo() {
		return no;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getStuNum() {
		return stuNum;
	}

	public String getResult() {
		return result;
	}
	
	public void read() {
		this.no = this.st.nextToken().trim();
		this.title = this.st.nextToken().trim();
		this.content = this.st.nextToken().trim();
		this.stuNum = this.st.nextToken().trim();
		this.result = this.st.nextToken().trim();
	}
	
}
