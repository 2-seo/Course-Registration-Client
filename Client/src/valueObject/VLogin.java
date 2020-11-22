package valueObject;

public class VLogin {
	private String userId;
	private String password;
	
	public VLogin(String userId, String password) {
		this.userId = userId;
		this.password = password;
	
	}
	public void initialize(String userId, String password) {
		this.userId = userId;
		this.password = password;
		
	}
	public String getUserId() {
		return userId;
	}
	public String getPassword() {
		return password;
	}
	@Override
	public String toString() {
		return  userId + " " + password;
	}
	
	

	
}
