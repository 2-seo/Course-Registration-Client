package sugangSincheong;

import java.util.Vector;

import javax.swing.JPanel;

import valueObject.VGangjwa;

public abstract class PGangjwaContainer extends JPanel {

	private static final long serialVersionUID = 1L;

	public abstract Vector<VGangjwa> removeSelectedGangjwas();
	public void addGangjwas(Vector<VGangjwa> vSelectedGangjwas) {};

}
