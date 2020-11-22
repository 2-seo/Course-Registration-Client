package mainFrame.inquire;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import control.CInquireResult;
import model.MInquire;
import model.MInquireResult;
import valueObject.VUser;

public class InquireFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private InquireTable inquireTable;
	private JPanel buttonPanel;
	private JButton btnInquire;
	private JButton btnEditInquire;
	private JButton btnClose;
	private JButton btnOpenAnswerFrame;
	
	private ActionListener buttonHandler;
	private VUser vStudent;
	private CreateInquireFrame createInquireFrame;
	private EditInquireFrame editInquireFrame;
	private AnswerFrame answerFrame;
	
	public InquireFrame()  {
		
		this.setTitle("나의 문의 내역");
		this.setSize(600, 500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		
		buttonHandler = new ButtonHandler();
		this.inquireTable = new InquireTable();
		this.createInquireFrame = new CreateInquireFrame(buttonHandler);
		this.editInquireFrame = new EditInquireFrame(buttonHandler);
		this.answerFrame = new AnswerFrame(buttonHandler);
				
		// Campus table Setting
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(this.inquireTable);
		scrollPane.setBounds(0, 0, 600, 380);
		this.add(scrollPane);
		
		// Button Setting
		buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 400, 600, 100);
		btnInquire = new JButton("문의하기");
		btnEditInquire = new JButton("문의수정");
		btnOpenAnswerFrame = new JButton("답변보기");
		btnClose = new JButton("닫기");			
		
		btnInquire.addActionListener(buttonHandler);
		btnEditInquire.addActionListener(buttonHandler);
		btnOpenAnswerFrame.addActionListener(buttonHandler);
		btnClose.addActionListener(buttonHandler);		
		
		btnInquire.setActionCommand("openCreateInquireFrame");
		btnEditInquire.setActionCommand("openEditInquireFrame");
		btnOpenAnswerFrame.setActionCommand("openAnswerFrame");
		btnClose.setActionCommand("closeInquireFrmae");		
		
		this.buttonPanel.add(this.btnInquire);
		this.buttonPanel.add(this.btnEditInquire);
		this.buttonPanel.add(this.btnOpenAnswerFrame);
		this.buttonPanel.add(this.btnClose);		
		
		this.add(buttonPanel);
		
	}
	
	public void initialize(VUser vStudent) {
		this.vStudent = vStudent;
		this.inquireTable.initialize(vStudent);
		this.inquireTable.updateInquireeTable();	
	}
	
	private void openCreateInquireFrame() {
		createInquireFrame.setVisible(true);		
	}
	
	private void closeInquireFrmae() {
		this.dispose();
	}
	
	private void createInquire() {
		String stuNum = this.vStudent.getStuNum().toString();
		this.createInquireFrame.createInquire(stuNum);
		this.inquireTable.updateInquireeTable();
	}
	
	private void closeCreateInquireFrame() {
		this.createInquireFrame.closeCreateInquireFrame();
	}
	
	private void openEditInquireFrame() {
		MInquire mInquire = this.inquireTable.getSelectedInquire();
		
		if(mInquire != null) {
			
			String result = mInquire.getResult();
			
			if(result.equals("답변대기")) {
				System.out.println("here ok2");
							
				this.editInquireFrame.setInquireInfo(mInquire);
				this.editInquireFrame.setVisible(true);
				
			} else if(result.equals("답변완료")) {
				JOptionPane.showMessageDialog(this, "답변이 완료된 문의사항은 수정할 수 없습니다.");
			}			
			
		} else {
			JOptionPane.showMessageDialog(this, "수정할 문의사항을 선택해주세요.");
		}
						
	}
	
	private void updqteInquire() {		
		this.editInquireFrame.updqteInquire();
		this.inquireTable.updateInquireeTable();
	}
	
	private void closeEditInquireFrame() {
		this.editInquireFrame.closeEditInquireFrame();
	}
	
	private void openAnswerFrame() {
		MInquire mInquire = this.inquireTable.getSelectedInquire();
		
		if(mInquire == null) {
			JOptionPane.showMessageDialog(this, "확인하실 답변의 문의사항을 선택해주세요.");
			return;
		}
		
		String result = mInquire.getResult();
		String inquireNo = mInquire.getNo();
		
		if(result.equals("답변완료")) {						
			
			CInquireResult cInquireResult = new CInquireResult();
			MInquireResult mInquireResult = cInquireResult.getInquireResult(inquireNo);
			
			this.answerFrame.setInquireInfo(mInquire);
			this.answerFrame.setAnswerInfo(mInquireResult);
			this.answerFrame.setVisible(true);
			
		} else {
			JOptionPane.showMessageDialog(this, "아직 문의사항의 답변이 작성되지 않았습니다.");
		}
	}
	
	private void closeAnswerFrame() {
		this.answerFrame.closeAnswerFrame();
	}
	
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();
			
			if(action.equals("openCreateInquireFrame")) {
				openCreateInquireFrame();
				
			} else if(action.equals("openEditInquireFrame")) {
				openEditInquireFrame();
				
			} else if(action.equals("closeInquireFrmae")) {
				closeInquireFrmae();
				
			} else if(action.equals("createInquire")) {
				createInquire();
				
			} else if(action.equals("closeCreateInquireFrame")) {
				closeCreateInquireFrame();
							
			} else if(action.equals("updqteInquire")) {
				updqteInquire();
				
			} else if(action.equals("closeEditInquireFrame")) {
				closeEditInquireFrame();
				
			} else if(action.equals("openAnswerFrame")) {
				openAnswerFrame();
			} else if(action.equals("closeAnswerFrame")) {
				closeAnswerFrame();
			}
			
		}
		
	}

	

}
