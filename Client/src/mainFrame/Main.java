package mainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import client.UserClient;
import constants.Constants;
import valueObject.VUser;

public class Main {

	private PLoginDialog pLoginDialog;
	private PMainFrame pMainFrame;
	private ActionHandler actionHandler;

	  
	public Main() {  // ���� ������� initialize�ϴ°� 
		
		actionHandler = new ActionHandler();	
		pLoginDialog = new PLoginDialog(actionHandler);
		pLoginDialog.setVisible(true);
					
	}
		
	private void initialize() {
		pLoginDialog.initialize();
	}
		
		
	private void validateUser(String actioncommand) {
			VUser vUser = pLoginDialog.getUser(actioncommand);
			if(vUser != null) {
				pMainFrame = new PMainFrame(); //new ���� �����ͺ���������
				pMainFrame.setVisible(true);
				pMainFrame.initialize(vUser); //initialize���� �����ͺ���
				this.pLoginDialog.dispose();	
			}		
					
	}
		
	public class ActionHandler implements ActionListener {
	
		public void actionPerformed(ActionEvent event) {
	
			if (event.getActionCommand().equals(Constants.ELoginDialog.okButtonLabel.getText())) {
				validateUser(event.getActionCommand());
//				sendUserInfo();
			} else if (event.getActionCommand().equals(Constants.ELoginDialog.cancelButtonLabel.getText())) {
				System.exit(0);
			}
		}
	
	}
	
	public static void main(String[] args) {
				
		Main main = new Main();
		main.initialize();
				
	}
  
 }

	 


