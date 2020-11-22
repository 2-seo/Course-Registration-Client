package mainFrame;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.CUser;
import model.MUser;

public class FindPasswordDialog extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private ActionListener buttonHandler;
	private JTextField txtStudentNum;
	private JTextField txtHint;
	
	public FindPasswordDialog() {
		
		this.setSize(300, 180);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.setTitle("비밀번호 찾기");
		this.setLayout(new FlowLayout());
		
		buttonHandler = new ButtonHandler();
		
		JPanel line1 = new JPanel();
			JLabel lblStudentNum = new JLabel("     학번       ");
			txtStudentNum = new JTextField(15);
			line1.add(lblStudentNum);
			line1.add(txtStudentNum);
		this.add(line1);
		
		JPanel line2 = new JPanel();
			JLabel lblHint = new JLabel("비밀번호 힌트");
			txtHint = new JTextField(15);
			line2.add(lblHint);
			line2.add(txtHint);
		this.add(line2);
		
		JPanel line3 = new JPanel();
			JButton btnOk = new JButton("찾기");
			JButton btnClose = new JButton("댣기");
			btnOk.setActionCommand("find");
			btnClose.setActionCommand("close");
			btnOk.addActionListener(buttonHandler);
			btnClose.addActionListener(buttonHandler);
			line3.add(btnOk);
			line3.add(btnClose);
		this.add(line3);
		
	}
	
	private void findStudnet() {
		CUser cUser = new CUser();
		if(!txtStudentNum.getText().equals("") && !txtHint.getText().equals("") ) {
			
			String data = this.txtStudentNum.getText() + " " + this.txtHint.getText();
			MUser mUser = cUser.findUser(data);
			if(mUser != null) {				
//				showMessage("비밀번호는 " + mUser.getPassword() + " 입니다.");
//				JOptionPane.showMessageDialog(this, "비밀번호는 " + mUser.getPassword() + " 입니다.", "알림", JOptionPane.ERROR_MESSAGE);
				MessageFrame.showMessage("알림", "비밀번호는 " + mUser.getPassword() + " 입니다.", MessageFrame.INFO_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "학번과 비밀번호 힌트를 확인해주세요", "알림", JOptionPane.ERROR_MESSAGE);
//				showMessage("학번과 비밀번호 힌트를 확인해주세요");
//				return;
			}
		} else {						
			JOptionPane.showMessageDialog(this, "학번과 비밀번호 힌트를 입력해주세요", "알림", JOptionPane.ERROR_MESSAGE);
//			showMessage("학번과 비밀번호 힌트를 입력해주세요");
		}
	}
	
	private void closeFindPasswordDialog() {
		this.dispose();
	}

	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String action = e.getActionCommand();
			
			if(action.equals("find")) {
				findStudnet();
			} else if(action.equals("close")) {
				closeFindPasswordDialog();
			}
			
		}
		
	}
	
	
}
