package control;

import java.util.Vector;

import model.DataAccessObject;
import model.MInquire;
import valueObject.VUser;

public class CInquire {

	public CInquire() {
		
	}
	
	public Vector<MInquire> getInquire(VUser vUser) {
		DataAccessObject dao = DataAccessObject.getInstance();
		return dao.getInquire(vUser);
	}

	public void createInquire(String title, String contents, String stuNum) {
		DataAccessObject dao = DataAccessObject.getInstance();
		dao.createInquire(title, contents, stuNum);
	}

	public void updateInquire(String title, String contents, String no) {
		DataAccessObject dao = DataAccessObject.getInstance();
		dao.updateInquire(title, contents, no);
		
	}
	
}
