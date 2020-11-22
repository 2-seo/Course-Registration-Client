package mainFrame.inquire;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.MInquire;
import model.MInquireResult;

public class AnswerFrame extends JFrame {
		
	private static final long serialVersionUID = 1L;
	
	private JTextField txtTtile;
	private JTextArea txtContents;
	private JTextArea txtAnswerContents;
	
	private MInquire mInquire;
	private MInquireResult mInquireResult;
	
	
	public AnswerFrame(ActionListener buttonHandler) {
		
		this.setTitle("답변하기");
		this.setSize(400, 480);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JPanel line1 = new JPanel();
			JLabel lblTitle = new JLabel("제목 ");
			txtTtile = new JTextField(25);
			txtTtile.setEditable(false);
			line1.add(lblTitle);
			line1.add(txtTtile);
		this.add(line1);
			
		JPanel line2 = new JPanel();
			txtContents = new JTextArea(10, 30);
			txtContents.setLineWrap(true);			
			txtContents.setEditable(false);
			line2.add(txtContents);
		this.add(line2);
		
		JPanel line3 = new JPanel();			
			txtAnswerContents = new JTextArea(10, 30);
			txtAnswerContents.setLineWrap(true);
			txtAnswerContents.setEditable(false);
			line3.add(txtAnswerContents);
		this.add(line3);
		
		JPanel line4 = new JPanel();			
			JButton btnClose = new JButton("닫기");			
			btnClose.setActionCommand("closeAnswerFrame");			
			btnClose.addActionListener(buttonHandler);			
			line4.add(btnClose);
		this.add(line4);
					
	}
	
	public void setInquireInfo(MInquire mInquire) {
		this.mInquire = mInquire;
		this.txtTtile.setText(this.mInquire.getTitle());
		this.txtContents.setText(this.mInquire.getContent());
		
	}
	
	public void setAnswerInfo(MInquireResult mInquireResult) {
		this.mInquireResult = mInquireResult;
		this.txtAnswerContents.setText(mInquireResult.getContents());
	}
	
	
	public void closeAnswerFrame() {
		this.dispose();
	}

	

}
