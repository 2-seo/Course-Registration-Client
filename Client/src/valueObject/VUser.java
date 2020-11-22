package valueObject;

public class VUser {
	private String stuNum;
	private String name;
	private String password;
	private String majorId;
	private String major;
	private String address;
	private String hint;
	
	public VUser(String stuNum, String name, String password, String majorId, String major, String address, String hint) {
		super();
		this.stuNum = stuNum;
		this.name = name;
		this.password = password;
		this.majorId = majorId;
		this.major = major;
		this.address = address;
		this.hint = hint;
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
	
	
}
