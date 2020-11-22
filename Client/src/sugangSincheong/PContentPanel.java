package sugangSincheong;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import constants.Constants.EConfiguration;
import mainFrame.PFileMenu;
import model.MUser;
import valueObject.VGangjwa;
import valueObject.VUser;

public class PContentPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private PSelection pSelection;
	private PMove pMove1;
	private PResult pMiridamgi;
	private PMove pMove2;
	private PResult pSincheong;
	
	private ListSelectionHandler listSelectionHandler;
	private ActionHandler actionHandler;
	private VUser vUser;

	private Vector<VGangjwa> vSelectedGangjwas;
	
	public PContentPanel() {
		
		this.listSelectionHandler = new ListSelectionHandler();
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		
         this.pSelection = new PSelection(listSelectionHandler);
         this.add(this.pSelection);
         
         this.actionHandler = new ActionHandler();
         this.pMove1 = new PMove(this.actionHandler);
         this.add(this.pMove1);
         
         this.pMiridamgi = new PResult("미리담기");
         this.add(pMiridamgi);
         
         this.pMove2 = new PMove(this.actionHandler);
         this.add(this.pMove2);
         
         this.pSincheong = new PResult("수강신청");
         this.add(pSincheong);
         
	}

	public void initialize(VUser mStudent) {	
		this.vUser = mStudent;
		
		this.pMove1.initialize();
		this.pMove2.initialize();
		
		// 미리 담기 & 수강신청 초기화
		this.pMiridamgi.initialize(this.vUser.getStuNum().toString(), "basket");
		this.pSincheong.initialize(this.vUser.getStuNum().toString(), "sincheong");
//		this.pMiridamgi.initialize(mStudent.getStuNum()+EConfiguration.miridmagiFilePostfix.getText());
//		this.pSincheong.initialize(mStudent.getStuNum()+EConfiguration.sincheongFilePostfix.getText());
		
		this.pSelection.initialize(this.pMiridamgi, this.pSincheong);
		
	}
	

//	public void save() {
//		this.pMiridamgi.save(this.vUser.getStuNum().toString(), "basket");
//		this.pSincheong.save(this.vUser.getStuNum().toString(), "sincheong");
//	}

	/////////////////////////////////////////////////////////////////
	// Table event handling 
	/////////////////////////////////////////////////////////////////
	
	private void updateGangjwas(Object source) { //직접들어가서비교
		this.pSelection.updateGangjwas(source);
	}


	public class ListSelectionHandler implements ListSelectionListener{
		@Override
		public void valueChanged(ListSelectionEvent event) {
			updateGangjwas(event.getSource());

		}
	}
	
	/////////////////////////////////////////////////////////////////
	// button event handling 
    /////////////////////////////////////////////////////////////////
	private void moveGangjwas(PGangjwaContainer source, PGangjwaContainer target) {
		vSelectedGangjwas = source.removeSelectedGangjwas();			
		target.addGangjwas(vSelectedGangjwas);
		
	}
	
	
	private void moveGangjwas(Object source) {
		if(source.equals(this.pMove1.getMoveRightButton())) {
			this.moveGangjwas(this.pSelection, this.pMiridamgi);
			this.pMiridamgi.save(this.vUser.getStuNum().toString(), "basket", vSelectedGangjwas);
			
		} else if(source.equals(this.pMove1.getMoveLeftButton())) {
			this.moveGangjwas(this.pMiridamgi, this.pSelection);			
			this.pSincheong.delete(this.vUser.getStuNum().toString(), "basket", vSelectedGangjwas);
		}
		else if(source.equals(this.pMove2.getMoveRightButton())) {
			this.moveGangjwas(this.pMiridamgi, this.pSincheong);
			this.pSincheong.delete(this.vUser.getStuNum().toString(), "basket", vSelectedGangjwas);
			this.pSincheong.save(this.vUser.getStuNum().toString(), "sincheong", vSelectedGangjwas);
			
		}
		else if(source.equals(this.pMove2.getMoveLeftButton())) {
			this.moveGangjwas(this.pSincheong, this.pMiridamgi);
			this.pMiridamgi.save(this.vUser.getStuNum().toString(), "basket", vSelectedGangjwas);
			this.pSincheong.delete(this.vUser.getStuNum().toString(), "sincheong", vSelectedGangjwas);
			
		}
	
			
		}
	public class ActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			moveGangjwas(event.getSource());
			
		}
		
	}

	
		
  }



