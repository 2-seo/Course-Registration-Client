package mainFrame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import constants.Constants.EToolBar;
import mainFrame.inquire.InquireFrame;
import mainFrame.notice.NoticeDialog;
import valueObject.VUser;

public class PToolBar extends JToolBar {
	
	private static final long serialVersionUID = 1L;
	
	private ActionListener buttonHandler;
	private NoticeDialog noticeDialog;
	private StudentInfoFrame studentInfoFrame;
	private InquireFrame inquireFrame;
	
	private VUser vStudent;
	
	public PToolBar() {
				
		
		buttonHandler = new ButtonHandler();
		noticeDialog = new NoticeDialog();
		studentInfoFrame = new StudentInfoFrame();
		inquireFrame = new InquireFrame();
		
		for (EToolBar eTool: EToolBar.values()) {
			ImageIcon originIcon = new ImageIcon(eTool.getPath());  
			Image originImg = originIcon.getImage(); 
			Image changedImg= originImg.getScaledInstance(25, 25, Image.SCALE_SMOOTH );
			ImageIcon Icon = new ImageIcon(changedImg);
			JButton button = new JButton(Icon);
			button.addActionListener(this.buttonHandler);
			button.setActionCommand(eTool.getText());
		    this.add(button);
	
		}
		
	}

	public void initialize(VUser vStudent) {
		this.vStudent = vStudent;
	}
	
	
	private void openNoticeDialog() {
		noticeDialog.initialize();
		noticeDialog.setVisible(true);		
	}
	
	private void openStudnetInfoFrmae() {
		studentInfoFrame.setStudentInfo(this.vStudent);
		studentInfoFrame.setVisible(true);
	}
	
	private void openInquireFrame() {
		inquireFrame.initialize(this.vStudent);
		inquireFrame.setVisible(true);
		
	}
	
	private class ButtonHandler implements ActionListener {

		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String action = e.getActionCommand();
			
			if(action.equals(EToolBar.Notice.getText())) {
				openNoticeDialog();
			} else if(action.equals(EToolBar.PersonalInfo.getText())) {
				openStudnetInfoFrmae();
			} else if(action.equals(EToolBar.Inquire.getText())) {
				openInquireFrame();
			} else if(action.equals(EToolBar.Grade.getText())) {
				try {
					java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://www.mju.ac.kr/mjukr/index.do"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		
	}
	
}
