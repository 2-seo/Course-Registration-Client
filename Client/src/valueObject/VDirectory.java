package valueObject;

public class VDirectory {
    private String name;
    private String fileName;
    
    public VDirectory() {

    }

    public void initialize(String name, String fileName) {
    	this.name = name;
    	this.fileName = fileName;
    }
    public String getName() {
    	return name;
    }
    public String getFileName() {
    	return fileName;
    }

	
}
