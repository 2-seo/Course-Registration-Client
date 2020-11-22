package mainFrame;
import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import constants.Constants;
import model.MUser;
import sugangSincheong.PSugangSincheongPanel;
import valueObject.VUser;

public class PMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private WindowListener windowListener;
	private PMenuBar pMenuBar;
	private PToolBar pToolBar;
	private PSugangSincheongPanel pMainPanel;
	
	// constructor
	public PMainFrame() {
		// set attributes
		this.setTitle("수강신청");
		this.setSize(
				Constants.EMainFrame.width.getInt(), 
				Constants.EMainFrame.height.getInt()
				);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.windowListener = new WindowHandler();
		this.addWindowListener(windowListener);
		this.setLayout(new BorderLayout());
		
		// create and register components
		this.pMenuBar = new PMenuBar();
		this.setJMenuBar(this.pMenuBar);
		
		this.pToolBar = new PToolBar();
		this.add(this.pToolBar, BorderLayout.NORTH);
		
		this.pMainPanel = new PSugangSincheongPanel();
		this.add(this.pMainPanel, BorderLayout.CENTER);	

	}
	
	public void initialize(VUser vStudent) {
		this.pMenuBar.initialize();
		this.pToolBar.initialize(vStudent);
		this.pMainPanel.initialize(vStudent);
	}
	
//	private void save() {
//		this.pMainPanel.save();
//	}
	
	private class WindowHandler implements WindowListener{

		@Override
		public void windowOpened(WindowEvent e) {}
		@Override
		public void windowClosing(WindowEvent e) {
//			save();
		}
		@Override
		public void windowClosed(WindowEvent e) {}
		@Override
		public void windowIconified(WindowEvent e) {}
		@Override
		public void windowDeiconified(WindowEvent e) {}
		@Override
		public void windowActivated(WindowEvent e) {}
		@Override
		public void windowDeactivated(WindowEvent e) {}
		
	}
}
