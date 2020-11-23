package model;

public class MUser extends MModel {

	private String stuNum;
	private String name;
	private String password;
	private String majorId;
	private String major;
	private String address;
	private String hint;

	public MUser() {		
		
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

	
}
