package mainFrame.notice;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import control.CNotice;
import model.MNotice;

public class NoticeTable extends JTable {
	
	private static final long serialVersionUID = 1L;
	
	private Vector<String> header;
	private DefaultTableModel tableModel;
	
	private Vector<MNotice> mNotices;

	public NoticeTable() {
		
		this.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
	    header = new Vector<>();
		header.addElement("No.");
		header.addElement("제목");
		header.addElement("작성자");			
		
		this.tableModel = new DefaultTableModel(header, 0);
		this.setModel(this.tableModel);
//		this.getSelectionModel().addListSelectionListener(this.listSelectionHandler);	
		initialize();
	}
	
	private void initialize() {		
		updateTableContents();
	}

	public void updateTableContents() {

//		this.getSelectionModel().removeListSelectionListener(this.listSelectionHandler);
	

		this.tableModel.setRowCount(0);
		this.tableModel = new DefaultTableModel(header, 0);
		
		CNotice cNotice = new CNotice();
		mNotices = cNotice.getNotice();

		for(MNotice mNotice : mNotices) {
			Vector<String> row = new Vector<>();
			row.add(mNotice.getId());
			row.add(mNotice.getTitle());
			row.add(mNotice.getWriter());

			this.tableModel.addRow(row);	
		}
		
		if(mNotices.size()>0) {
			this.setModel(this.tableModel);
//			this.getSelectionModel().addSelectionInterval(0, 0);
		}
		
//		this.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
			
	}
	
	public MNotice getSelectedNotice() {
		int selectedRow = this.getSelectedRow();
		return this.mNotices.get(selectedRow);
	}
	
}