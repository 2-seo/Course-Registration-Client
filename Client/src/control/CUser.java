package control;

import model.DataAccessObject;
import model.MUser;
import valueObject.VLogin;
import valueObject.VUser;

public class CUser {

	public VUser getUser(VLogin vLogin) {
		VUser vUser = null;
		
		DataAccessObject dataAccessObject = DataAccessObject.getInstance();
		MUser mUser = dataAccessObject.getUser(vLogin);
		
		if (mUser != null) {
			vUser = new VUser(					
						mUser.getStuNum(), mUser.getName(), mUser.getPassword(),
						mUser.getMajorId(), mUser.getMajor(), mUser.getAddress(),
						mUser.getHint()
					);
		}
		return vUser;
	}

	public void updateUser(String data) {
		
		DataAccessObject dao = DataAccessObject.getInstance();
		dao.updateUser(data);
		
	}

	public MUser findUser(String data) {
		DataAccessObject dao = DataAccessObject.getInstance();
		return dao.findeUser(data);
	}

}
