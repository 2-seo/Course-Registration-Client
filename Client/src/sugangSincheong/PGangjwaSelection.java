package sugangSincheong;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import constants.Constants.EPGangjwaSelection;
import control.CGangjwa;
import valueObject.VGangjwa;

public class PGangjwaSelection extends JTable {

	private static final long serialVersionUID = 1L;

	CGangjwa cGangjwa;

	Vector<VGangjwa> vGangjwas;
	DefaultTableModel tableModel;
	private PResult pMiridamgi;
	private PResult pSincheong;

	public PGangjwaSelection() {
		Vector<String> header = new Vector<String>();
		for(EPGangjwaSelection ePGangjwaSelection: EPGangjwaSelection.values()) {
			header.addElement(ePGangjwaSelection.getText());
		}
		
		this.tableModel = new DefaultTableModel(header, 0);
		this.setModel(this.tableModel);


	}

	public void initialize(String fileName, PResult pMiridamgi, PResult pSincheong) {
		this.pMiridamgi = pMiridamgi;
		this.pSincheong = pSincheong;
		this.update(fileName);

	}
	
	private void removeDuplicated(Vector<VGangjwa> vSelectedGangjwas) {
		for(int index = vGangjwas.size()-1; index>=0; index--) {
			for(VGangjwa vGangjwa : vSelectedGangjwas) {
				if(this.vGangjwas.get(index).getId().equals(vGangjwa.getId())){
					this.vGangjwas.remove(index);
					break;
				}
			}
		}
	}
	
	public void updateTableContents() {
		
		this.tableModel.setRowCount(0); // √ ±‚»≠ 
		for(VGangjwa vGangjwa : vGangjwas) {
			Vector<String> row = new Vector<String>();
			row.add(vGangjwa.getId());
			row.add(vGangjwa.getName());
			row.add(vGangjwa.getLecturer());
			row.add(vGangjwa.getCredit());
			row.add(vGangjwa.getTime());
			this.tableModel.addRow(row);	
		}
		if(vGangjwas.size()>0) {
			this.getSelectionModel().addSelectionInterval(0, 0);
		}
		


	}
	
	public void update(String fileName) {
		this.cGangjwa = new CGangjwa();
		this.vGangjwas = this.cGangjwa.getData(fileName);
		
		this.removeDuplicated(this.pMiridamgi.getGangjwas());
		this.removeDuplicated(this.pSincheong.getGangjwas());
		
		this.updateTableContents();
	}
	
	public Vector<VGangjwa> removeSelectedGangjwas(){
		int[] indices = this.getSelectedRows();
		Vector<VGangjwa> vRemovedGangjwas = new Vector<VGangjwa>();
		for(int i=indices.length-1; i>=0; i--) {
			VGangjwa vRemovedGangjwa = this.vGangjwas.remove(indices[i]);
			vRemovedGangjwas.add(vRemovedGangjwa);
		}
		this.updateTableContents();
		return vRemovedGangjwas;
			

	}
	


}




