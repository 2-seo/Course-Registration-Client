package control;

import model.DataAccessObject;
import model.MModel;
import model.MUser;
import valueObject.VLogin;
import valueObject.VUser;

public class CUser {

	public VUser getUser(VLogin vLogin) {
		VUser vUser = null;
		
		DataAccessObject dao = DataAccessObject.getInstance();
		String type = "login";
		String message = vLogin.toString();
		MModel mModel = dao.getAModel(type, message, MUser.class);
		
		MUser mUser = (MUser) mModel;

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
		String type = "updateUser";
		String message = data;
		dao.sendToServer(type, message);
		
	}

	public MUser findUser(String data) {
		DataAccessObject dao = DataAccessObject.getInstance();
		String type = "findUser";
		String message = data;
		MModel mModel = dao.getAModel(type, message, MUser.class);
		MUser mUser = (MUser) mModel;
		return mUser;
	}

}
