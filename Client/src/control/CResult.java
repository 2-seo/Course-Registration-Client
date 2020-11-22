package control;

import java.util.Vector;

import model.DataAccessObject;
import model.MGangjwa;
import valueObject.VGangjwa;

public class CResult {

	public CResult() {
		
	}
	public void save(String fileName, String tableName, Vector<VGangjwa> vGangjwas) {
		DataAccessObject dataAccessObject = DataAccessObject.getInstance();
		dataAccessObject.saveResults(fileName, tableName, vGangjwas);
	}
	
	public void delete(String fileName, String tableName, Vector<VGangjwa> vGangjwas) {
		DataAccessObject dataAccessObject = DataAccessObject.getInstance();
		dataAccessObject.removeResults(fileName, tableName, vGangjwas);
	}
	
	public Vector<VGangjwa> get(String fileName, String tableName) {
		DataAccessObject dataAccessObject = DataAccessObject.getInstance();
		Vector<MGangjwa> mGangjwas= dataAccessObject.getResults(fileName, tableName);
		
		Vector<VGangjwa> vGangjwas = new Vector<VGangjwa>();
		if(mGangjwas.size() > 0) {
			
			for(MGangjwa mGangjwa : mGangjwas) {
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
