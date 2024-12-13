package test_class;

import org.testng.annotations.Test;

import base_class.Baseclass;
import page_class.Pageclass;


public class Testclass extends Baseclass {

	
	
	@Test
	public void submittest() throws Exception
	{
		Pageclass p1=new Pageclass(driver);
		p1.scrolldown();
		p1.field("Aiswariya","PV" , "aiswariyaprasheel5@gmail.com","8908337376", "Kannur", "ABC", "kochi","3","1230000", "Btech", "coet", "java,sql");
		p1.genderfield();
		p1.functionfield();
		p1.industryfield();
		Thread.sleep(1000);
		p1.Uploadtest();
		p1.fileUpload("C:\\\\Users\\\\chait\\\\OneDrive\\\\Documents\\\\resume.docx");
	    p1.captureScreenshot();

	}		
}
