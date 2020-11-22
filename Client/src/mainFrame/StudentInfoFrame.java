package mainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.CUser;
import valueObject.VUser;

public class StudentInfoFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private String studentNum;
	private String strStudentName;
	private int majorId;
	private String majorName;
	private String strAddress;
	
	private JPanel pStudentNum;
	private JLabel lblStudnetNum;
	private JTextField txtStudentNum;

	private JPanel pName;
	private JLabel lblStuName;
	private JTextField txtStuName;
	
	private JPanel pMajor;
	private JLabel lblMajor;
	private JTextField txtMajor;	
	
	private JPanel pAddress;
	private JLabel lblAddress;
	private JTextField txtAddress;
	
	private JPanel pPassword;
	private JLabel lblPassword;
	private JTextField txtPassword;

	
	private JPanel pHint;
	private JLabel lblHint;
	private JTextField txtHint;
	
	private JPanel pButton;	
	private JButton btnOk;
	private JButton btnCancle;
	
	private JLabel lblWhatisHint;
	
	private ActionListener buttonHandler;
	
	public StudentInfoFrame() {
		
		this.setTitle("학생 정보");
		this.setSize(300, 360);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);				
		
		// Form Setting
		pStudentNum = new JPanel();
		lblStudnetNum = new JLabel("학번");
		txtStudentNum = new JTextField(20);
		txtStudentNum.setEnabled(false);
		pStudentNum.add(lblStudnetNum);
		pStudentNum.add(txtStudentNum);
		pStudentNum.setBounds(5, 10, 300, 40);
		this.add(pStudentNum);
		
		pName = new JPanel();
		lblStuName = new JLabel("이름");
		txtStuName = new JTextField(20);
		pName.add(lblStuName);
		pName.add(txtStuName);
		pName.setBounds(5, 50, 300, 40);
		this.add(pName);
		
		pMajor = new JPanel();
		lblMajor = new JLabel("전공");
		txtMajor = new JTextField(20);
		txtMajor.setEnabled(false);
		
		pMajor.add(lblMajor);
		pMajor.add(txtMajor);		
		pMajor.setBounds(5, 90, 300, 40);
		this.add(pMajor);
				
		pAddress = new JPanel();
		lblAddress = new JLabel("주소");
		txtAddress = new JTextField(20);
		pAddress.add(lblAddress);
		pAddress.add(txtAddress);		
		pAddress.setBounds(5, 130, 300, 40);
		this.add(pAddress);
		
		pPassword = new JPanel();
		lblPassword = new JLabel("비밀번호");
		txtPassword = new JTextField(18);
		pPassword.add(lblPassword);
		pPassword.add(txtPassword);		
		pPassword.setBounds(5, 170, 300, 40);
		this.add(pPassword);

		pHint = new JPanel();
		lblHint = new JLabel("비밀번호 힌트");
		txtHint= new JTextField(16);
		pHint.add(lblHint);
		pHint.add(txtHint);		
		pHint.setBounds(5, 210, 300, 40);
		this.add(pHint);
		lblWhatisHint = new JLabel("비밀번호 힌트는 비밀번호 찾기에 이용됩니다."); 
		lblWhatisHint.setBounds(31, 220, 300, 80);
		this.add(lblWhatisHint);
		
		buttonHandler = new ButtonHandler();
		
		pButton = new JPanel();
		btnOk = new JButton("수정");
		btnCancle = new JButton("취소");
		btnOk.setActionCommand("updateStudent");
		btnCancle.setActionCommand("closeStudentInfoFrame");
		buttonHandler = new ButtonHandler();
		btnOk.addActionListener(buttonHandler);
		btnCancle.addActionListener(buttonHandler);
		pButton.add(btnOk);
		pButton.add(btnCancle);				
		pButton.setBounds(5, 280, 300, 40);
		this.add(pButton);

	}
	
	public void initialize() {
		
	}
	
	public void setStudentInfo(VUser vStudent) {
		this.studentNum = vStudent.getStuNum().toString();
		this.txtStudentNum.setText(vStudent.getStuNum().toString());
		this.txtStuName.setText(vStudent.getName());
		this.txtMajor.setText(vStudent.getMajor());
		this.txtAddress.setText(vStudent.getAddress());
		this.txtPassword.setText(vStudent.getPassword());
		this.txtHint.setText(vStudent.getHint());
	}
	
	private void updateStudnet() {
		
		int strLen; 
		String hint = txtHint.getText();
		System.out.println(hint);
				
		if (hint.equals("") || txtStuName.getText().equals("") || txtPassword.getText().equals("")
				|| (strLen = hint.length()) == 0 || txtAddress.getText().equals("")) {						
			showMessage("공백이 존재합니다.");
			return; 
		} 
		for (int i = 0; i < strLen; i++) {
			boolean flag = false;
			if ((!Character.isWhitespace(hint.charAt(i)))) {
				flag = true;
				break; 				
			}
			if(flag == true)
				showMessage("비밀번호 힌트는 공백이 포함될 수 없습니다.");
		} 
		
		String message = "학생 정보를 변경하시겠습니까?";
		String optionTitle = "알림";
		int reply = JOptionPane.showConfirmDialog(this, message, optionTitle, JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
			CUser cUser = new CUser();
			String data = this.studentNum + " " + this.txtStuName.getText() + " " + txtPassword.getText() + " "+ txtAddress.getText() + " " + txtHint.getText();
			cUser.updateUser(data);
			this.dispose();
		}
		

	}
	
	private void closeStudentInfoFrame() {
		this.dispose();
	}
	
	private void showMessage(String message) {
		
		Thread t = new Thread(new Runnable(){
	        public void run(){
	            JOptionPane.showMessageDialog(null, message);
	        }
	    });
	  t.start();
	}
	
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();
			
			if(action.equals("updateStudent")) {
				updateStudnet();
			} else if(action.equals("closeStudentInfoFrame")) {
				closeStudentInfoFrame();
			}
			
		}
		
	}
	
}
