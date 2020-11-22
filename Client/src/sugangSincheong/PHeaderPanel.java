package sugangSincheong;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.MUser;
import valueObject.VUser;

public class PHeaderPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel welcomeLabel;
	public PHeaderPanel() {
		this.welcomeLabel = new JLabel();
		this.add(this.welcomeLabel);
	}
	public void initialize(VUser mStudent) {
		this.welcomeLabel.setText(mStudent.getName()+"¥‘ æ»≥Á«œººø‰.");
		
	}
}
