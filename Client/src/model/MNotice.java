package model;

import java.util.StringTokenizer;

public class MNotice {
	
	private String id;
	private String title;
	private String contents;
	private String writer;
	private StringTokenizer st;
	

	public MNotice(StringTokenizer st) {
		this.st = st;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContents() {
		return contents;
	}

	public String getWriter() {
		return writer;
	}
	
	public void read() {
		this.id = this.st.nextToken();
		this.title = this.st.nextToken();
		this.contents = this.st.nextToken();
		this.writer = this.st.nextToken().trim();
	}

	
	
}
