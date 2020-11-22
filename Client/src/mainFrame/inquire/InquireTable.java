package mainFrame.inquire;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import control.CInquire;
import model.MInquire;
import valueObject.VUser;

public class InquireTable extends JTable {
	private static final long serialVersionUID = 1L;

	private DefaultTableModel tableModel;
	
//	ListSelectionListener listSelectionHandler;
	Vector<String> header;
	private Vector<MInquire> mInquires;
	private VUser vStudent;
	
	public InquireTable() {
		// attributes
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		this.listSelectionHandler = listSelectionHandler;
//		this.getSelectionModel().addListSelectionListener(this.listSelectionHandler);		
		
		// data model
		header = new Vector<>();
		header.addElement("��ȣ");
		header.addElement("����");
//		header.addElement("����");
		header.addElement("�й�");
		header.addElement("ó�����");
		
		this.tableModel = new DefaultTableModel(header, 0);
		this.setModel(this.tableModel);
		
		
	}

	public void initialize(VUser vStudent) {
		this.vStudent = vStudent;
		updateInquireeTable();
	}
	
	
	public MInquire getSelectedInquire() {
		
		MInquire mInquire = null;
		
		int selectedIndex = this.getSelectedRow();
		if(selectedIndex >= 0) {
			mInquire = this.mInquires.get(selectedIndex);
			return mInquire;			
		}
		
		return mInquire;
	}

	public void updateInquireeTable() {
//		this.getSelectionModel().removeListSelectionListener(this.listSelectionHandler);
		
		
		// tablemodel�� rowCount�� 0���� ���� �ʱ�ȭ�� �Ѵ�.
		this.tableModel.setRowCount(0);
		
		CInquire cInquire = new CInquire();
		this.mInquires = cInquire.getInquire(this.vStudent);
		
		for (MInquire mInquire : this.mInquires) {
			Vector<String> row = new Vector<String>();
			row.add(mInquire.getNo().toString());
			row.add(mInquire.getTitle());
//			row.add(mInquire.getContent());
			row.add(mInquire.getStuNum());
			row.add(mInquire.getResult());
			this.tableModel.addRow(row);
		}

		if (this.mInquires.size() > 0) {
			this.getSelectionModel().addSelectionInterval(0, 0);
//			selectedFileName = vDirectories.get(0).getFileName();
		}
		
//		this.getSelectionModel().addListSelectionListener(this.listSelectionHandler);

	}

	
}