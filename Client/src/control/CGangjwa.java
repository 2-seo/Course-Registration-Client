package control;

import java.util.Vector;

import model.DataAccessObject;
import model.MGangjwa;
import model.MModel;
import valueObject.VGangjwa;

public class CGangjwa {
	 
     public CGangjwa() {
 		
 	}
 	
 	public Vector<VGangjwa> getData(String fileName){
 		DataAccessObject dataAccessObject = DataAccessObject.getInstance();
 		String type = "getGangjwas";
 		String message = fileName;
 		Vector<MModel> mModels = dataAccessObject.getModels(type, message, MGangjwa.class);
 		
 		Vector<VGangjwa> vGangjwas = new Vector<VGangjwa>();
 		for(MModel mModel : mModels) {
 			MGangjwa mGangjwa = (MGangjwa) mModel;
 			VGangjwa vGangjwa = new VGangjwa(
 					mGangjwa.getId(),mGangjwa.getName(),mGangjwa.getLecturer(),
 					mGangjwa.getCredit(), mGangjwa.getTime() , mGangjwa.getMajorId()
 			); 			
 			vGangjwas.add(vGangjwa);
 		}
 		return vGangjwas;
 	}

 	


}
