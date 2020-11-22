package mainFrame;
import javax.swing.JMenuBar;

public class PMenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;

	private PFileMenu pFileMenu;
	private PEditMenu pEditMenu;
	
	public PMenuBar() {
		// create and register components
		this.pFileMenu = new PFileMenu();
		this.add(pFileMenu);
		
		this.pEditMenu = new PEditMenu();
		this.add(pEditMenu);
	}

	public void initialize() {
		this.pFileMenu.initialize();
		this.pEditMenu.initialize();
		
	}


}
