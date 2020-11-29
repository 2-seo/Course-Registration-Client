package sugangSincheong;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;

import valueObject.VGangjwa;

public class PSelection extends PGangjwaContainer {
	private static final long serialVersionUID = 1L;

	PHackgwaSelection pHackgwaSelection;
	private PGangjwaSelection pGangjwaSelection;

	public PSelection(ListSelectionListener listSelectionHandler) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.pHackgwaSelection = new PHackgwaSelection(listSelectionHandler);
		this.add(pHackgwaSelection);

		JScrollPane scrollPane = new JScrollPane();
		this.pGangjwaSelection = new PGangjwaSelection();
		scrollPane.setViewportView(this.pGangjwaSelection);
		this.add(scrollPane);
	}

	public void initialize(PResult pMiridamgi, PResult pSincheong) {

		this.pHackgwaSelection.initialize();
		String fileName = this.pHackgwaSelection.getFileName();
		this.pGangjwaSelection.initialize(fileName, pMiridamgi, pSincheong);
		
//		this.pGangjwaSelection.removeDuplicated(pMiridamgi);
//		this.pGangjwaSelection.removeDuplicated(pSincheong); 
		//this.pGangjwaSelection.updateTableContents();
	}

	public void updateGangjwas(Object source) {
		String fileName = this.pHackgwaSelection.update(source);
		this.pGangjwaSelection.update(fileName);
		
//		this.pGangjwaSelection.removeDuplicated(miridamgiGangjwas);
//		this.pGangjwaSelection.removeDuplicated(sincheongGangjwas);
//		this.pGangjwaSelection.updateTableContents();

	}

	@Override
	public void addGangjwas(Vector<VGangjwa> vSelectedGangjwas) {
		
		String fileName = this.pHackgwaSelection.getFileName();
		this.pGangjwaSelection.update(fileName);

	}

	@Override
	public Vector<VGangjwa> removeSelectedGangjwas() {
		return this.pGangjwaSelection.removeSelectedGangjwas();
	}

}

