package control;

import java.util.Vector;

import model.DataAccessObject;
import model.MGangjwa;
import valueObject.VGangjwa;
import valueObject.VUser;

public class CGangjwa {
	 
     public CGangjwa() {
 		
 	}
 	
 	public Vector<VGangjwa> getData(String fileName){
 		DataAccessObject dataAccessObject = DataAccessObject.getInstance();
 		Vector<MGangjwa> mGangjwas = dataAccessObject.getGangjwas(fileName);
 		
 		Vector<VGangjwa> vGangjwas = new Vector<VGangjwa>();
 		for(MGangjwa mGangjwa : mGangjwas) {
 			VGangjwa vGangjwa = new VGangjwa();
 			vGangjwa.initialize(mGangjwa.getId(),mGangjwa.getName(),mGangjwa.getLecturer(),
 					mGangjwa.getCredit(), mGangjwa.getTime(), mGangjwa.getMajorId());
 			vGangjwas.add(vGangjwa);
 		}
 		return vGangjwas;
 	}

 	


}
