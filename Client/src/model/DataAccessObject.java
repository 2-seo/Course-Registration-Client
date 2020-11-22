package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

import client.UserClient;
import valueObject.VGangjwa;
import valueObject.VLogin;
import valueObject.VUser;

public class DataAccessObject {
	
	// Singleton Pattern
	private static DataAccessObject dao = null;
	private UserClient client;
	
	private DataAccessObject() {
		client = new UserClient();
	}
	
	public synchronized static DataAccessObject getInstance() {
		if(dao == null) {
			dao = new DataAccessObject();
		}
		return dao;
	}

	public MUser getUser(VLogin vLogin) {
		
		MUser mUser = null;
		
		String type = "login";
		String data = client.send(type, vLogin).trim();
		System.out.println(data);
		if(!data.equals("")) {			
			Scanner scanner = new Scanner(data);
			
			while (scanner.hasNext()) {			
				mUser = new MUser(scanner);
				mUser.read();
			}
		}
	
		return mUser;
		
	}
	

	public Vector<MDirectory> getDirectories(String fileName, String tableName) {
		Vector<MDirectory> mDirectories = new Vector<MDirectory>();		
			
		String type = "getDirectorys";
		String data = client.send(type, fileName + " " + tableName);
		System.out.println(data);
		
		Scanner scanner = new Scanner(data);
		
		while (scanner.hasNext()) {
			MDirectory mDirectory = new MDirectory(scanner);
			mDirectory.read();
			mDirectories.add(mDirectory);
		}
		
		scanner.close();
	
		return mDirectories;
	}
	
	public Vector<MGangjwa> getGangjwas(String fileName) {
		Vector<MGangjwa> mGangjwas = new Vector<MGangjwa>();

		String type = "getGangjwas";
		System.out.println("fileName ================ " + fileName);
		String data = client.send(type, fileName);
		System.out.println(data);
		Scanner scanner = new Scanner(data);
		
		while (scanner.hasNext()) {
			MGangjwa mGangjwa = new MGangjwa(scanner);
			mGangjwa.read();
			mGangjwas.add(mGangjwa);
		}
		
		scanner.close();

		return mGangjwas;
		
	}

	public void saveResults(String fileName, String tableName, Vector<VGangjwa> vGangjwas) {
		
		if(vGangjwas.size() <= 0) {
			return;
		}
		
		try {
			FileWriter fileWriter = new FileWriter(new File("userInfo/"+fileName));
			for(VGangjwa vGangjwa : vGangjwas) {
				MGangjwa mGangjwa = new MGangjwa(fileWriter, vGangjwa);
				mGangjwa.save();
			}
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String type = "save";
		String data = fileName + " " + tableName;
		for(VGangjwa vGangjwa : vGangjwas) {
			data += " " + vGangjwa.getId();
		}
		client.send(type, data);
		
	}
	
	public void removeResults(String fileName, String tableName, Vector<VGangjwa> vGangjwas) {				
		System.out.println(vGangjwas.size());
		if(vGangjwas.size() <= 0) {
			return;
		}
		
		try {
			FileWriter fileWriter = new FileWriter(new File("userInfo/"+fileName));
			for(VGangjwa vGangjwa : vGangjwas) {
				MGangjwa mGangjwa = new MGangjwa(fileWriter, vGangjwa);
				mGangjwa.save();
			}
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String type = "delete";
		String data = fileName + " " + tableName;
		for(VGangjwa vGangjwa : vGangjwas) {
			data += " " + vGangjwa.getId();
		}
		client.send(type, data);
		
	}

	public Vector<MGangjwa> getResults(String fileName, String tableName) {

		
		Vector<MGangjwa> mGangjwas = new Vector<MGangjwa>();
		
		String type = tableName;
		String data = client.send(type, fileName);
		
		if(!data.equals("")) {
			
			Scanner scanner = new Scanner(data);
			
			while (scanner.hasNext()) {
				MGangjwa mGangjwa = new MGangjwa(scanner);
				mGangjwa.read();
				mGangjwas.add(mGangjwa);
			}
			
			scanner.close();
		}
		
		return mGangjwas;
	}

	public Vector<MNotice> getNotice() {
		
		Vector<MNotice> mNotices = new Vector<>();
		
		String type = "getNotice";
		String data = client.send(type, "");
		
		StringTokenizer st = new StringTokenizer(data.trim(), "***forsplitdata***");
			
		while (st.hasMoreTokens()) {
			MNotice mNotice = new MNotice(st);
			mNotice.read();
			mNotices.add(mNotice);
		}
		
		
		
		return mNotices;
		
	}

	public void updateUser(String data) {
		String type = "updateUser";
		client.send(type, data);
		
	}

	public MUser findeUser(String userInfo) {
		MUser mUser = null;
		
		String type = "findUser";
		String data = client.send(type, userInfo);
		
		if(!data.equals("")) {			
			
			Scanner scanner = new Scanner(data.trim());						
			while (scanner.hasNext()) {			
				mUser = new MUser(scanner);
				mUser.read();
			}
		}
	
		return mUser;
	}

	public Vector<MInquire> getInquire(VUser vUser) {
		String stuNum = vUser.getStuNum().toString();
		
		String type = "getMyInquire";
		String data = client.send(type, stuNum);
		System.out.println(data);
		Vector<MInquire> mInquires = new Vector<>();
		
		if(!data.equals("")) {			
			StringTokenizer st = new StringTokenizer(data.trim(), "***forsplitdata***");			
			
			while (st.hasMoreTokens()) {
				MInquire mInquire = new MInquire(st);
				mInquire.read();
				mInquires.add(mInquire);
			}
		}
	
		return mInquires;
				
	}

	public void createInquire(String title, String contents, String stuNum) {
		String type = "createInquire";
		String data = title + " " + contents + " " + stuNum;
		client.send(type, data);
		
	}

	public void updateInquire(String title, String contents, String no) {
		String type = "updateInquire";
		String data = title + " " + contents + " " + no;
		client.send(type, data.trim());
		
	}

	public MInquireResult getInquireResult(String inquireNo) {
		
		
		String type = "getAnswer";
		String data = client.send(type, inquireNo);
		
		MInquireResult mInquireResult = null;
		
		if(!data.equals("")) {			
			StringTokenizer st = new StringTokenizer(data.trim(), "***forsplitdata***");
			
			
			while (st.hasMoreTokens()) {
				mInquireResult = new MInquireResult(st);
				mInquireResult.read();				
			}
		}
	
		return mInquireResult;
	}	
	
}
