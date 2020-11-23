package mainFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MessageFrame extends JFrame {

	private static final long serialVersionUID = 1L;
		
	private JLabel lblIcon;
	private JLabel lblMessage;
	private JButton btnOk;
	
	private ActionListener buttonHandler;
	
	public static final int ERROR_MESSAGE = 0;
	public static final int INFO_MESSAGE = 1;
	
	public MessageFrame(String title, String message, int icon_type) {
		
		this.setTitle(title);
		this.setSize(350, 130);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		
		
		String path = "";
		if(icon_type == 0) {
			path = "data/error_message.png";
		} else if(icon_type == 1) {
			path = "data/info_message.png";
		}
		
		JPanel contentPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
			// LOGO image
			ImageIcon originIcon = new ImageIcon(path);  
	        Image originImg = originIcon.getImage(); 
	        Image changedImg= originImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH );
	        ImageIcon icon = new ImageIcon(changedImg);
	        lblIcon = new JLabel(icon);       
	        
	        contentPanel.add(lblIcon);
			
			lblMessage = new JLabel(message);
			contentPanel.add(lblMessage);
		this.add(contentPanel, BorderLayout.CENTER);
		
		buttonHandler = new ButtonHandler();
		btnOk = new JButton("»Æ¿Œ");
		btnOk.addActionListener(buttonHandler);
		this.add(btnOk, BorderLayout.SOUTH);
		
		initialize();
	}
	
	public void initialize() {
		this.setVisible(true);
	}
	
	public static void showMessage(String title, String message, int icon_type) {				
		
		MessageFrame messageFrame = new MessageFrame(title, message, icon_type);
		
	}
	
	private void hideForm() {
		this.dispose();
	}
	
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			hideForm();
			
		}
		
	}

}
