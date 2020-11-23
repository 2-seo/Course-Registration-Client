package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.StringTokenizer;
import java.util.Vector;

import client.UserClient;

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
	
	public MModel getAModel(String type, String message, Class<? extends MModel> clazz) {

        MModel mModel = null;		
		String data = client.send(type, message);		
		
		try {
			if(!data.equals("")) {			
				StringTokenizer st = new StringTokenizer(data.trim(), "***forsplitdata***");			
				
				while (st.hasMoreTokens()) {
					mModel = clazz.getConstructor().newInstance();
					mModel.read(st);				
				}
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

		return mModel;

    }
	
	public Vector<MModel> getModels(String type, String message, Class<? extends MModel> clazz) {

        Vector<MModel> mModels = new Vector<>();							
		String data = client.send(type, message);		
		
		StringTokenizer st = new StringTokenizer(data.trim(), "***forsplitdata***");
					 
		try {
			while (st.hasMoreTokens()) {
				MModel mModel = clazz.getConstructor().newInstance();
				mModel.read(st);
				mModels.add(mModel);
			}		
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		return mModels;
        
    }
	
	public void save(String fileName, Vector<MModel> mModels) {
		File path = new File("lectureInfo/data/" + fileName);
		try(BufferedWriter bufferWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "MS949"))) {
			for(MModel mModel : mModels) {
				mModel.save(bufferWriter);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}

	public void sendToServer(String type, String message) {
		
        client.send(type, message.trim());
        
    }
	
	
}
