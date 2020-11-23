package control;

import model.DataAccessObject;
import model.MInquireResult;
import model.MModel;

public class CInquireResult {
	
	public CInquireResult() {
		
	}
	
	public MInquireResult getInquireResult(String inquireNo) {
		
		DataAccessObject dao = DataAccessObject.getInstance();
		String type = "getAnswer";
		String message = inquireNo;
		MModel mModel = dao.getAModel(type, message, MInquireResult.class);
		MInquireResult mInquireResult = (MInquireResult) mModel;
		return mInquireResult;
		
	}
	

}
