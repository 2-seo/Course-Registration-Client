package mainFrame.notice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.MNotice;

public class NoticeDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private NoticeTable noticeTable;
	private ViewNoticeDialog viewNoticeDialog;
	
	private JPanel buttonPanel;
	private JButton btnView;
	private JButton btnClose;

	private ActionListener buttonHandler;
	
	
	public NoticeDialog() {
		
		this.setTitle("공지사항");
		this.setSize(600, 380);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		
		viewNoticeDialog = new ViewNoticeDialog();
		
		// Notice table Setting
		JScrollPane scrollPane = new JScrollPane();
		this.noticeTable = new NoticeTable();
		scrollPane.setViewportView(this.noticeTable);
		scrollPane.setBounds(0, 0, 600, 300);
		this.add(scrollPane);
		
		// Button Panel Setting
		buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 300, 600, 100);
		
		buttonHandler = new ButtonHandler();
		
		btnView = new JButton("보기");
		btnClose = new JButton("닫기");
		btnView.setActionCommand("openViewNoticeDialog");
		btnClose.setActionCommand("closeNoticeDialog");
		
		btnView.addActionListener(buttonHandler);
		btnClose.addActionListener(buttonHandler);
		
		this.buttonPanel.add(btnView);
		this.buttonPanel.add(btnClose);
		
		this.add(buttonPanel);
		
		
		
	}
	
	public void initialize() {
		this.noticeTable.updateTableContents();
	}
	
	private void openViewNoticeDialog() {
		MNotice mNotice = noticeTable.getSelectedNotice();
		viewNoticeDialog.setText(mNotice.getTitle(), mNotice.getContents());
		viewNoticeDialog.setVisible(true);
	}

	private void closeNoticeDialog() {
		this.dispose();
	}
	
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String action = e.getActionCommand();
			
			
			
			if(action == "openViewNoticeDialog") {
				openViewNoticeDialog();
			} else if(action == "closeNoticeDialog") {
				closeNoticeDialog();
				
			} else if(action == "closeNoticeDialog") {
				
			}
			
		}
		
	}
	
}
