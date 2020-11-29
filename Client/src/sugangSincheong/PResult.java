package sugangSincheong;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import constants.Constants.EPResult;
import control.CResult;
import valueObject.VGangjwa;
import valueObject.VUser;

public class PResult extends PGangjwaContainer {
	
private static final long serialVersionUID = 1L;

private JTable table;

private DefaultTableModel tableModel;
//public Vector<String> header;
public Vector<VGangjwa> vGangjwas = new Vector<VGangjwa>();
public Vector<VGangjwa> vDeleteGangjwas;
public VUser vUser;
String title;


	public PResult(String title) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.table = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		
		this.setName(title);
		Vector<String> header = new Vector<String>();
		for(EPResult EPResult : EPResult.values()) {
		header.addElement(EPResult.getText());
		}
		this.tableModel = new DefaultTableModel(header, 0);
		this.table.setModel(this.tableModel);

		scrollPane.setViewportView(this.table);
		this.add(scrollPane);
	}

	public void initialize(String fileName, String tableName) {
		// fileName == userId
		CResult cResult = new CResult();
		this.vGangjwas = cResult.get(fileName, tableName);
		this.updateTableData();
		
	}
	

	public Vector<VGangjwa> getGangjwas(){
		return this.vGangjwas;
	}
	
	public void saveTextFile(String fileName) {
		CResult cResult = new CResult();
		cResult.saveTextFile(fileName, this.vGangjwas);
		
	}

	public void save(String fileName, String tableName, Vector<VGangjwa> vSelectedGangjwas) {
		
		if(vSelectedGangjwas.size() <= 0) {
			return;
		}
		
		CResult cResult = new CResult();
		cResult.save(fileName, tableName, vSelectedGangjwas);
		
	}
	
	public void delete(String fileName, String tableName, Vector<VGangjwa> vSelectedGangjwas) {
		
		if(vSelectedGangjwas.size() <= 0) {
			return;
		}
		
		CResult cResult = new CResult();
		cResult.delete(fileName, tableName, vSelectedGangjwas);
		
	}
	
	public Vector<VGangjwa> removeDuplicated(Vector<VGangjwa> vSelectedGangjwas) {
		for(int index = vSelectedGangjwas.size()-1; index>=0; index--) {
			for(VGangjwa vGangjwa : this.vGangjwas) {
				if(vSelectedGangjwas.get(index).getId().equals(vGangjwa.getId())) {
					vSelectedGangjwas.remove(index);
					break;
				}
			}
		}
		return vSelectedGangjwas;
	}
	
	private void updateTableData() {
		this.tableModel.setRowCount(0); // √ ±‚»≠ 
		for(VGangjwa vGangjwa : vGangjwas) {
			Vector<String> row = new Vector<String>();
			row.add(vGangjwa.getId());
			row.add(vGangjwa.getName());
			this.tableModel.addRow(row);	
		}
		if(vGangjwas.size()>0) {
			this.table.getSelectionModel().addSelectionInterval(0, 0);
		}
	}

	public void addGangjwas(Vector<VGangjwa> vSelectedGangjwas) {
		
		Vector<VGangjwa> vRemoveGangjwas = removeDuplicated(vSelectedGangjwas);
		this.vGangjwas.addAll(vRemoveGangjwas);
		this.updateTableData();
	}
	


	public Vector<VGangjwa> removeSelectedGangjwas() {
		int[] indices = this.table.getSelectedRows();
		Vector<VGangjwa> vRemoveGangjwas = new Vector<VGangjwa>();
		for(int i=indices.length-1; i>=0; i--) {
			VGangjwa vRemoveGangjwa = this.vGangjwas.remove(indices[i]);
			vRemoveGangjwas.add(vRemoveGangjwa);
		}
		this.updateTableData();
		return vRemoveGangjwas;
			
	}
	
	public Vector<VGangjwa> getvDeleteGangjwas() {
		return this.vDeleteGangjwas;
	}

	


	


}
