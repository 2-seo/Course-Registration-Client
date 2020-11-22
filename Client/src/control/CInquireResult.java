package control;

import model.DataAccessObject;
import model.MInquireResult;

public class CInquireResult {
	
	public CInquireResult() {
		
	}
	
	public MInquireResult getInquireResult(String inquireNo) {
		
		DataAccessObject dao = DataAccessObject.getInstance();
		return dao.getInquireResult(inquireNo);
		
	}
	

}
