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
		
		this.setTitle("���� ���� ����");
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
		btnInquire = new JButton("�����ϱ�");
		btnEditInquire = new JButton("���Ǽ���");
		btnOpenAnswerFrame = new JButton("�亯����");
		btnClose = new JButton("�ݱ�");			
		
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
			
			if(result.equals("�亯���")) {
				System.out.println("here ok2");
							
				this.editInquireFrame.setInquireInfo(mInquire);
				this.editInquireFrame.setVisible(true);
				
			} else if(result.equals("�亯�Ϸ�")) {
				JOptionPane.showMessageDialog(this, "�亯�� �Ϸ�� ���ǻ����� ������ �� �����ϴ�.");
			}			
			
		} else {
			JOptionPane.showMessageDialog(this, "������ ���ǻ����� �������ּ���.");
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
			JOptionPane.showMessageDialog(this, "Ȯ���Ͻ� �亯�� ���ǻ����� �������ּ���.");
			return;
		}
		
		String result = mInquire.getResult();
		String inquireNo = mInquire.getNo();
		
		if(result.equals("�亯�Ϸ�")) {						
			
			CInquireResult cInquireResult = new CInquireResult();
			MInquireResult mInquireResult = cInquireResult.getInquireResult(inquireNo);
			
			this.answerFrame.setInquireInfo(mInquire);
			this.answerFrame.setAnswerInfo(mInquireResult);
			this.answerFrame.setVisible(true);
			
		} else {
			JOptionPane.showMessageDialog(this, "���� ���ǻ����� �亯�� �ۼ����� �ʾҽ��ϴ�.");
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
