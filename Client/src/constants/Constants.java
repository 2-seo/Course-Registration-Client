package constants;

import java.util.Vector;

public class Constants {
	
	public enum EConfiguration{
		rootFileName("1"),
		miridmagiFilePostfix("M"),
		sincheongFilePostfix("S");
		
		private String text;
		private EConfiguration(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum ELoginDialog {
		width("300"),
		height("420"),
		nameLabel(" ���̵�   "),
		sizeNameText("10"),
		passwordLabel("��й�ȣ"),
		sizePasswordText("10"),
		okButtonLabel("�α���"),
		cancelButtonLabel("�ݱ�"),
		noAccountInfo("ȸ�� ������ �������� �ʽ��ϴ�."),
		loginFailed("���̵� ��й�ȣ�� �ٸ��ϴ�.");
		
		private String text;
		private ELoginDialog(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}

	
	public enum EMainFrame {
		width("1000"),
		height("600");
		
		private String text;
		private EMainFrame(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EMenuBar {
		FILE("����"),
		EDIT("����");
		
		private String text;
		
		EMenuBar(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EFileMenu {
		NEW("����"),
		OPEN("����"),
		SAVE("����"),
		SAVEAS("�ٸ��̸�����"),
		PRINT("����Ʈ"),
		EXIT("����");
		
		private String text;
		
		EFileMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EEditMenu {
		COPY("����"),
		CUT("�ڸ���"),
		PASTE("�ٿ��ֱ�"),
		DELETE("����");
		
		private String text;
		
		EEditMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EToolBar{
		Notice("��������", "data/notice.png"),
		PersonalInfo("��������", "data/student.png"),
		Inquire("�����ϱ�", "data/inquire.png"),
		Grade("Ȩ������", "data/homepage.png");
			
		private String text;
		private String path;

		EToolBar(String text, String path){
			this.text = text;
			this.path=path;
		}

		public String getText() {
			return this.text;
		}
		
		public String getPath() {
			return this.path;
		}

	}
	
	public enum EDirectory{
		campus("ķ�۽�"),
		college("����"),
		hackgwa("�а�");
		
		private String text;
		private EDirectory(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}

	public enum EPGangjwaSelection{
		gangjwaNo("���¹�ȣ"),
		gangjwaName("���¸�"),
		damdangGyosu("��米��"),
		hakjeom("����"),
		time("�ð�");
		
		private String text;
		private EPGangjwaSelection(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}

	public enum EPResult{
		gangjwaNo("���¹�ȣ"),
		gangjwaName("���¸�");
		
		private String text;
		private EPResult(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
}
