package mainFrame.notice;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ViewNoticeDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JPanel pContainer;
	
	private JPanel pNorth;
	private JPanel pCenter;
	private JPanel pSouth;
	
	private JLabel lblTitle;
	private JTextField txtTtile;
	private JTextArea txtContent;
	private JButton btnOk;
	private JButton btnCancle;
	
	private NoticeTable noticeTable;
	private ActionListener buttonHandler;
	
	private Integer id;
	
	public ViewNoticeDialog() {
		this.setSize(600, 500);
		
		this.pContainer = new JPanel();
		this.pContainer.setSize(600, 500);
		this.pContainer.setLayout(new BorderLayout(10, 10));
		this.setLocationRelativeTo(null);
		this.setResizable(false);		
		
		// North
		this.pNorth = new JPanel();
		this.pNorth.setLayout(new BoxLayout(this.pNorth, BoxLayout.X_AXIS));
		
		this.lblTitle = new JLabel("Á¦¸ñ");
		this.txtTtile = new JTextField(50);
		this.txtTtile.setEditable(false);
		
		this.pNorth.add(lblTitle);
		this.pNorth.add(txtTtile);
		
		this.pContainer.add(pNorth, BorderLayout.NORTH);
		
		// Center
		this.pCenter = new JPanel();
		this.pCenter.setLayout(new GridLayout(1,1));
		
		this.txtContent = new JTextArea();
		this.txtContent.setEditable(false);
		this.txtContent.setLineWrap(true);
		
		this.pCenter.add(txtContent);
		
		this.pContainer.add(pCenter, BorderLayout.CENTER);
		
		// South
		this.pSouth = new JPanel();
				
		this.btnCancle = new JButton("´Ý±â");				
		this.btnCancle.setActionCommand("cancle");
		
		buttonHandler = new ButtonHandler();		
		btnCancle.addActionListener(buttonHandler);
		
		this.pSouth.add(btnCancle);

		this.pContainer.add(pSouth, BorderLayout.SOUTH);
		
		this.add(pContainer);
		
	}
	

	public void setId(Integer id) {
		this.id = id;		
	}	
	
	private void hideForm() {
		this.dispose();
	}
	
	public void setText(String title, String contents) {
		this.txtTtile.setText(title);
		this.txtContent.setText(contents);
	}
	
	
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String action = e.getActionCommand();
			
			if(action == "cancle") {
				hideForm();
							
			}
			
		}
		
	}



}
