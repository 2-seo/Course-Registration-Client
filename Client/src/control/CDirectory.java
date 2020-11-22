package control;

import java.util.Vector;

import model.DataAccessObject;
import model.MDirectory;
import valueObject.VDirectory;

public class CDirectory {
	
	public CDirectory() {
		
	}
	
	public Vector<VDirectory> getData(String fileName, String tableName){
		DataAccessObject dataAccessObject = DataAccessObject.getInstance();
		Vector<MDirectory> mDirectories = dataAccessObject.getDirectories(fileName, tableName);
		
		Vector<VDirectory> vDirectories = new Vector<VDirectory>();
		for(MDirectory mDirectory : mDirectories) {
			VDirectory vDirectory = new VDirectory();
			vDirectory.initialize(mDirectory.getName(),
					mDirectory.getFileName());
			vDirectories.add(vDirectory);
		}
		return vDirectories;
	}

}
