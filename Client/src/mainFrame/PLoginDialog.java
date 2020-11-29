package mainFrame;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import constants.Constants.ELoginDialog;
import control.CUser;
import mainFrame.Main.ActionHandler;
import valueObject.VLogin;
import valueObject.VUser;

public class PLoginDialog extends JDialog {
	// attributes
	private static final long serialVersionUID = 1L;

	// components
	private JLabel lblId;
	private JTextField txtId;
	private JLabel lblPw;
	private JPasswordField txtPw;
	private JButton okButton;
	private JButton cancelButton;
		
	FindPasswordDialog findPasswordDialog;
	
	public PLoginDialog(ActionHandler actionHandler) {
		// attributes
		this.setSize(ELoginDialog.width.getInt(), 
				ELoginDialog.height.getInt());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.setTitle("수강신청 로그인");
		this.setLayout(new FlowLayout());
		
		findPasswordDialog = new FindPasswordDialog();
		
		// components
		JPanel line0 = new JPanel();
			ImageIcon originIcon = new ImageIcon("data/logo.png");  
		    Image originImg = originIcon.getImage(); 
		    Image changedImg= originImg.getScaledInstance(200, 200, Image.SCALE_SMOOTH );
		    ImageIcon icon = new ImageIcon(changedImg);
		    JLabel lblLogo = new JLabel(icon);
//		    lblLogo.setBounds(55, 20, 200, 200);
		    line0.add(lblLogo);
		    this.add(line0);
		
		JPanel line1 = new JPanel();
			this.lblId = new JLabel(ELoginDialog.nameLabel.getText());
			line1.add(this.lblId);		
			this.txtId = new JTextField(ELoginDialog.sizeNameText.getInt());
			line1.add(this.txtId);
		this.add(line1);
		JPanel line2 = new JPanel();
			this.lblPw = new JLabel(ELoginDialog.passwordLabel.getText());
			line2.add(this.lblPw);		
			this.txtPw = new JPasswordField(ELoginDialog.sizePasswordText.getInt());
			line2.add(this.txtPw);
		this.add(line2);
		JPanel line3 = new JPanel();
			JLabel lblFinePassword = new JLabel("비밀번호를 잊으셨나요?");
			lblFinePassword.addMouseListener(new MouseAdapter() {  
			    public void mouseClicked(MouseEvent e) {  
			    	findPasswordDialog.setVisible(true);
			    }
			    @Override
			    public void mouseEntered(MouseEvent arg0) {
			    	lblFinePassword.setForeground(Color.blue);		     
			    }
			    @Override
			    public void mouseExited(java.awt.event.MouseEvent e) {
			    	lblFinePassword.setForeground(Color.black);		     
			     
			    }
			}); 
		line3.add(lblFinePassword);
		this.add(line3);
		
		JPanel line4 = new JPanel();
			this.okButton = new JButton(ELoginDialog.okButtonLabel.getText());
			this.okButton.addActionListener(actionHandler);
			this.okButton.setActionCommand(this.okButton.getText());
			this.getRootPane().setDefaultButton(this.okButton);
									
			line4.add(this.okButton);		
			this.cancelButton = new JButton(ELoginDialog.cancelButtonLabel.getText());
			this.cancelButton.addActionListener(actionHandler);
			this.cancelButton.setActionCommand(this.cancelButton.getText());
			line4.add(this.cancelButton);
		this.add(line4);

	}
	
	public void initialize() {
		
	}
	
	public VUser getUser(String actioncommand) {
		VUser vUser = null;
		if(actioncommand.contentEquals(this.okButton.getText())) {
			
			CUser cUser = new CUser();
			// VLogin에 데이터를 담아서 CUser에 전달
			String id = this.txtId.getText();
			String pw = this.txtPw.getText();
			if(id.equals("") || pw.equals("")) {
				JOptionPane.showMessageDialog(this, "아이디와 패스워드를 입력하세요.", "알림", JOptionPane.ERROR_MESSAGE);
				return null;
			}
			VLogin vLogin = new VLogin(id, pw);
			// CUser은 VUser을 반환해줌
			vUser = cUser.getUser(vLogin);
			
			if (vUser == null) {
				JOptionPane.showMessageDialog(this, "아이디와 패스워드를 확인하세요.", "알림", JOptionPane.ERROR_MESSAGE);
				return null;
			}

		}
		return vUser;
	
	}
	
	public String getId() {
		return this.txtId.getText();
	}
	
	public String getPassword() {
		return this.txtPw.getText();
	}

	
}
