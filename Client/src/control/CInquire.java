package control;

import java.util.Vector;

import model.DataAccessObject;
import model.MInquire;
import model.MModel;
import valueObject.VUser;

public class CInquire {

	public CInquire() {
		
	}
	
	public Vector<MInquire> getInquire(VUser vUser) {
		
		DataAccessObject dao = DataAccessObject.getInstance();
		
		String type = "getMyInquire";
		String message = vUser.getStuNum().toString();
		Vector<MModel> mModels = dao.getModels(type, message, MInquire.class);
		
		Vector<MInquire> mInquires = new Vector<>();
		for(MModel mModel : mModels) {
			MInquire mInquire = (MInquire) mModel;
			mInquires.add(mInquire);
		}
		
		return mInquires;

	}

	public void createInquire(String title, String contents, String stuNum) {
		DataAccessObject dao = DataAccessObject.getInstance();
		String type = "createInquire";
		String message = title + " " + contents + " " + stuNum;
		dao.sendToServer(type, message);
	}

	public void updateInquire(String title, String contents, String no) {
		DataAccessObject dao = DataAccessObject.getInstance();
		String type = "updateInquire";
		String message = title + " " + contents + " " + no;
		dao.sendToServer(type, message);
		
	}
	
}
