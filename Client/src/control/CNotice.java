package control;

import java.util.Vector;

import model.DataAccessObject;
import model.MModel;
import model.MNotice;

public class CNotice {

	
	public CNotice() {

	}
	
	public Vector<MNotice> getNotice() {
		DataAccessObject dao = DataAccessObject.getInstance();
		
		String type = "getNotice";
		String message = "";
		
		Vector<MModel> mModels = dao.getModels(type, message, MNotice.class);
		
		Vector<MNotice> mNotices = new Vector<>();
		for(MModel mModel : mModels) {
			MNotice mNotice = (MNotice) mModel;
			mNotices.add(mNotice);
		}
		
		
		return mNotices;
	}

	
}
