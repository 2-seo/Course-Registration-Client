package model;

import java.util.StringTokenizer;

public class MInquireResult {

	private String no;
	private String contents;
	private StringTokenizer st;
	
	MInquireResult(String no, String contents) {
		this.no = no;
		this.contents = contents;		
	}

	public MInquireResult(StringTokenizer st) {
		this.st = st;
	}

	public String getNo() {
		return no;
	}

	public String getContents() {
		return contents;
	}
	
	public void read() {
		this.no = this.st.nextToken().trim();
		this.contents = this.st.nextToken().trim();
	}
	
	
}
