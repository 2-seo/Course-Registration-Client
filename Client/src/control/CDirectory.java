package control;

import java.util.Vector;

import model.DataAccessObject;
import model.MDirectory;
import model.MModel;
import valueObject.VDirectory;

public class CDirectory {
	
	public CDirectory() {
		
	}
	
	public Vector<VDirectory> getData(String fileName, String tableName){
		DataAccessObject dataAccessObject = DataAccessObject.getInstance();
		String type = "getDirectorys";
		String message = fileName + " " + tableName;
		Vector<MModel> mModels = dataAccessObject.getModels(type, message, MDirectory.class);
		
		Vector<VDirectory> vDirectories = new Vector<>();

		for(MModel mModel : mModels) {
			MDirectory mMirectory = (MDirectory) mModel;
			VDirectory vDirectory = new VDirectory(
					mMirectory.getName(),
					mMirectory.getFileName()
			);
			
			vDirectories.add(vDirectory);
		}
		return vDirectories;
	}

}
