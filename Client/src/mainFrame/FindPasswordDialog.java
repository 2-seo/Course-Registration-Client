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
		
		this.setTitle("��й�ȣ ã��");
		this.setLayout(new FlowLayout());
		
		buttonHandler = new ButtonHandler();
		
		JPanel line1 = new JPanel();
			JLabel lblStudentNum = new JLabel("     �й�       ");
			txtStudentNum = new JTextField(15);
			line1.add(lblStudentNum);
			line1.add(txtStudentNum);
		this.add(line1);
		
		JPanel line2 = new JPanel();
			JLabel lblHint = new JLabel("��й�ȣ ��Ʈ");
			txtHint = new JTextField(15);
			line2.add(lblHint);
			line2.add(txtHint);
		this.add(line2);
		
		JPanel line3 = new JPanel();
			JButton btnOk = new JButton("ã��");
			JButton btnClose = new JButton("�Ʊ�");
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
//				showMessage("��й�ȣ�� " + mUser.getPassword() + " �Դϴ�.");
//				JOptionPane.showMessageDialog(this, "��й�ȣ�� " + mUser.getPassword() + " �Դϴ�.", "�˸�", JOptionPane.ERROR_MESSAGE);
				MessageFrame.showMessage("�˸�", "��й�ȣ�� " + mUser.getPassword() + " �Դϴ�.", MessageFrame.INFO_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "�й��� ��й�ȣ ��Ʈ�� Ȯ�����ּ���", "�˸�", JOptionPane.ERROR_MESSAGE);
//				showMessage("�й��� ��й�ȣ ��Ʈ�� Ȯ�����ּ���");
//				return;
			}
		} else {						
			JOptionPane.showMessageDialog(this, "�й��� ��й�ȣ ��Ʈ�� �Է����ּ���", "�˸�", JOptionPane.ERROR_MESSAGE);
//			showMessage("�й��� ��й�ȣ ��Ʈ�� �Է����ּ���");
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
