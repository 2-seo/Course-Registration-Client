package valueObject;

public class VGangjwa {
	private String id;
	private String name;
	private String lecturer;
	private String credit;
	private String time;
	private String majorId;
	
	public VGangjwa(String id, String name, String lecturer, String credit, String time, String majorId) {	
		this.id = id;
		this.name = name;
		this.lecturer = lecturer;
		this.credit = credit;
		this.time = time;
		this.majorId = majorId;
	}
	
	public VGangjwa() {
		// TODO Auto-generated constructor stub
	}

	public void initialize(String id, String name, String lecturer, String credit, String time, String majorId) {
		this.id = id;
		this.name = name;
		this.lecturer = lecturer;
		this.credit = credit;
		this.time = time;
		this.majorId = majorId;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getLecturer() {
		return lecturer;
	}
	public String getCredit() {
		return credit;
	}
	public String getTime() {
		return time;
	}

	public String getMajorId() {
		return majorId;
	}
	
	@Override
	public String toString() {
		return id + " " + name + " " + lecturer + " " + credit + " "
				+ time + " " + majorId;
	}
}
