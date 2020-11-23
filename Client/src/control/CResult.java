package control;

import java.util.Vector;

import model.DataAccessObject;
import model.MGangjwa;
import model.MModel;
import valueObject.VGangjwa;

public class CResult {

	public CResult() {
		
	}
	
	public void saveTextFile(String fileName, Vector<VGangjwa> vGangjwas) {
		DataAccessObject dao = DataAccessObject.getInstance();
		Vector<MModel> mModels = new Vector<>();
		for(VGangjwa vGangjwa : vGangjwas) {
			MGangjwa mGangjwa = new MGangjwa();
			mGangjwa.setId(vGangjwa.getId());
			mGangjwa.setName(vGangjwa.getName());
			mGangjwa.setLecturer(vGangjwa.getLecturer());
			mGangjwa.setCredit(vGangjwa.getCredit());
			mGangjwa.setTime(vGangjwa.getTime());
			mModels.add(mGangjwa);
		}
				
		dao.save(fileName, mModels);
	}
	
	public void save(String fileName, String tableName, Vector<VGangjwa> vGangjwas) {
		
		DataAccessObject dao = DataAccessObject.getInstance();
		// DB Save
		String type = "save";
		String	message = fileName + " " + tableName;
		for(VGangjwa vGangjwa : vGangjwas) {
			message += " " + vGangjwa.getId();
		}
		dao.sendToServer(type, message);
	}
	
	public void delete(String fileName, String tableName, Vector<VGangjwa> vGangjwas) {
		DataAccessObject dao = DataAccessObject.getInstance();
				
		// DB delete
		String type = "delete";
		String message = fileName + " " + tableName;
		for(VGangjwa vGangjwa : vGangjwas) {
			message += " " + vGangjwa.getId();
		}
		dao.sendToServer(type, message);
	}
	
	public Vector<VGangjwa> get(String fileName, String tableName) {
		DataAccessObject dataAccessObject = DataAccessObject.getInstance();
		String type = tableName;
		String message = fileName;
		Vector<MModel> mModels = dataAccessObject.getModels(type, message, MGangjwa.class);
		
		Vector<VGangjwa> vGangjwas = new Vector<>();
		if(mModels.size() > 0) {
									
			for(MModel mModel : mModels) {
				MGangjwa mGangjwa = (MGangjwa) mModel;
				VGangjwa vGangjwa = new VGangjwa(
						mGangjwa.getId(),
						mGangjwa.getName(),
						mGangjwa.getLecturer(),
						mGangjwa.getCredit(),
						mGangjwa.getTime(),
						mGangjwa.getMajorId()
						);
				vGangjwas.add(vGangjwa);
			}
		}
		return vGangjwas;
		
	}
	

}
