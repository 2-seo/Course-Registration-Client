package mainFrame.inquire;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import control.CInquire;
import model.MInquire;

public class CreateInquireFrame extends JFrame {
		
	private static final long serialVersionUID = 1L;
	
	private JTextField txtTtile;
	private JTextArea txtContents;	
	
	private MInquire mInquire;
	
	
	public CreateInquireFrame(ActionListener buttonHandler) {
		
		this.setTitle("�����ϱ�");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JPanel line1 = new JPanel();
			JLabel lblTitle = new JLabel("���� ");
			txtTtile = new JTextField(25);			
			line1.add(lblTitle);
			line1.add(txtTtile);
		this.add(line1);
			
		JPanel line2 = new JPanel();
			txtContents = new JTextArea(10, 30);
			txtContents.setLineWrap(true);						
			line2.add(txtContents);
		this.add(line2);		
		
		JPanel line3 = new JPanel();
			JButton btnAnswer = new JButton("�����ϱ�");
			JButton btnClose = new JButton("�ݱ�");
			btnAnswer.setActionCommand("createInquire");
			btnClose.setActionCommand("closeCreateInquireFrame");
			btnAnswer.addActionListener(buttonHandler);
			btnClose.addActionListener(buttonHandler);
			line3.add(btnAnswer);
			line3.add(btnClose);
		this.add(line3);
					
	}
	
	public void setInquireInfo(MInquire mInquire) {
		this.mInquire = mInquire;
		this.txtTtile.setText(this.mInquire.getTitle());
		this.txtContents.setText(this.mInquire.getContent());
		
	}
	
	public void createInquire(String stuNum) {
		
		String message = "���ǻ��� �ۼ��Ͻðڽ��ϱ�?";
		String optionTitle = "�˸�";
		int reply = JOptionPane.showConfirmDialog(this, message, optionTitle, JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
		
			if(!this.txtContents.getText().equals("")) {
				CInquire cInquire = new CInquire();
				String title = this.txtTtile.getText();
				String contents = this.txtContents.getText();	
				cInquire.createInquire(title, contents, stuNum);
				
				this.dispose();
				
			} else {
				
				JOptionPane.showMessageDialog(this, "���� ������ �ۼ����ּ���.");
				
			}
		}
		
	}
	
	public void closeCreateInquireFrame() {
		this.dispose();
	}

	

}
