package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VGangjwa;

public class MGangjwa {
	private Scanner scanner;
	private FileWriter fileWriter;
	
	private String id;
	private String name;
	private String lecturer;
	private String credit;
	private String time;
	private String majorId;
	
		
	public MGangjwa(Scanner scanner) {
		this.scanner = scanner;
	}

	public MGangjwa(FileWriter fileWriter, VGangjwa vGangjwas) {
		this.fileWriter =fileWriter;
		this.id = vGangjwas.getId();
		this.name = vGangjwas.getName();
		this.lecturer = vGangjwas.getLecturer();
		this.credit = vGangjwas.getCredit();
		this.time = vGangjwas.getTime();
		this.majorId = vGangjwas.getMajorId();
		
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
	
	public void read() {	
		
		this.id = scanner.next();
		this.name = scanner.next();
		this.lecturer = scanner.next();
		this.credit = scanner.next();
		this.time = scanner.next();
		this.majorId = scanner.next();
	}
	
	public void save() {
		try {
			this.fileWriter.write(this.id+" ");
			this.fileWriter.write(this.name+" ");
			this.fileWriter.write(this.lecturer+" ");
			this.fileWriter.write(this.credit+" ");
			this.fileWriter.write(this.time+"\n");
			this.fileWriter.write(this.majorId+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addWrite(FileWriter fw, VGangjwa vSelectedGangjwa) {	

		try {
			fw.write(vSelectedGangjwa.getId());
			fw.write(" ");
			fw.write(vSelectedGangjwa.getName());
			fw.write(" ");
			fw.write(vSelectedGangjwa.getLecturer());
			fw.write(" ");
			fw.write(vSelectedGangjwa.getCredit());
			fw.write(" ");
			fw.write(vSelectedGangjwa.getTime());
			fw.write(" ");
			fw.write(vSelectedGangjwa.getMajorId());
			fw.write(" ");
			fw.write("\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return id + " " + name + " " + lecturer + " " + credit + " "
				+ time + " " + majorId;
	}

}