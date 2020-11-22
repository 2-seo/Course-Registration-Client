package control;

import java.util.Vector;

import model.DataAccessObject;
import model.MNotice;

public class CNotice {

	
	public CNotice() {

	}
	
	public Vector<MNotice> getNotice() {
		DataAccessObject dao = DataAccessObject.getInstance();
		Vector<MNotice> mNotices = dao.getNotice();
		
		return mNotices;
	}

	
}
