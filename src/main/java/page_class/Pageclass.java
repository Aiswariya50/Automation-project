package page_class;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class Pageclass {

	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"footer\"]/div/div/div[1]/div[2]/div/div[3]/ul/li[2]/a")
	WebElement Submit;
	@FindBy(xpath="//*[@id=\"firstName\"]")
	WebElement Firstname;
	@FindBy(xpath="/html/body/div[4]/section[2]/div/div/form/div/div[2]/div/input")
	WebElement Lastname;
	@FindBy(xpath="/html/body/div[4]/section[2]/div/div/form/div/div[3]/div/select")
	WebElement Gender;
	@FindBy(xpath="//*[@id=\"cont_email\"]")
	WebElement Email;
	@FindBy(xpath="//*[@id=\"it_mobile\"]")
    WebElement Mobile;		
	@FindBy(xpath="//*[@id=\"city_name\"]")
	WebElement Cityname;
	@FindBy(xpath="/html/body/div[4]/section[2]/div/div/form/div/div[8]/div/input")
	WebElement Company ;
	@FindBy(xpath="/html/body/div[4]/section[2]/div/div/form/div/div[9]/div/input")
	WebElement Designation;
	@FindBy(xpath="/html/body/div[4]/section[2]/div/div/form/div/div[10]/div/input")
	WebElement Experience;
	@FindBy(xpath="/html/body/div[4]/section[2]/div/div/form/div/div[11]/div/input")
	WebElement CurrentCtc;
	@FindBy(xpath="/html/body/div[4]/section[2]/div/div/form/div/div[12]/div/input")
	WebElement Degree;
	@FindBy(xpath="/html/body/div[4]/section[2]/div/div/form/div/div[13]/div/input")
	WebElement Institute;
	@FindBy(xpath="/html/body/div[4]/section[2]/div/div/form/div/div[14]/div/select")
	WebElement function;
	@FindBy(xpath="/html/body/div[4]/section[2]/div/div/form/div/div[15]/div/select")
	WebElement Industry;
	@FindBy(xpath="/html/body/div[4]/section[2]/div/div/form/div/div[16]/div/input")
	WebElement Skills;
	@FindBy(xpath="/html/body/div[4]/section[2]/div/div/form/div/div[3]/div/select")
	WebElement SelectGender;
	@FindBy(xpath="/html/body/div[4]/section[2]/div/div/form/div/div[4]/div/input")
	WebElement datePicker;
	
	
	
	public Pageclass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void scrolldown() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,1000)", "");
		Submit.click();
	}
	
	public void field(String first,String last,String email,String mob,String city,String comp,String design,String exp,String ctc,String deg,String inst,String skill)
	{
		Firstname.sendKeys(first);
		Lastname.sendKeys(last);
		Email.sendKeys(email);
		Mobile.sendKeys(mob);
		Cityname.sendKeys(city);
		Company.sendKeys(comp);
		Designation.sendKeys(design);
		Experience.sendKeys(exp);
		CurrentCtc.sendKeys(ctc);
		Degree.sendKeys(deg);
		Institute.sendKeys(inst);
		Skills.sendKeys(skill);
	}
	
	public void genderfield() {
		WebElement genderdropdown = driver.findElement(By.xpath("/html/body/div[4]/section[2]/div/div/form/div/div[3]/div/select"));
        
        
        Select select = new Select(genderdropdown);
        select.selectByValue("F");
		
	}
	public void functionfield() {
		WebElement functiondropdown=driver.findElement(By.xpath("/html/body/div[4]/section[2]/div/div/form/div/div[14]/div/select"));
	
	   Select select = new Select(functiondropdown);
	   select.selectByValue("2000023");
	}
	public void industryfield() {
		WebElement industrydropdown=driver.findElement(By.xpath("/html/body/div[4]/section[2]/div/div/form/div/div[15]/div/select"));
	   Select select = new Select(industrydropdown);
	   select.selectByValue("10000049");
	}
	
	public void Uploadtest() throws AWTException, InterruptedException
	 {
	  driver.findElement(By.xpath("//*[@id=\"custom-button\"]")).click();
	        fileUpload("C:\\Users\\chait\\OneDrive\\Documents\\resume.docx");
	  
	 }
	  public void fileUpload(String p) throws AWTException, InterruptedException {
	  StringSelection strSelection=new StringSelection(p);
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection, null);
	 
	  
	  Robot robot=new Robot();
	  robot.delay(3000);
	  robot.keyPress(KeyEvent.VK_CONTROL);
	  robot.keyPress(KeyEvent.VK_V);
	  robot.keyRelease(KeyEvent.VK_V);
	  robot.keyRelease(KeyEvent.VK_CONTROL);
	  Thread.sleep(3000);
	  robot.keyPress(KeyEvent.VK_ENTER);
	  robot.keyRelease(KeyEvent.VK_ENTER);
	  Thread.sleep(3000);
	 }
	  
	  
	  public void captureScreenshot() throws IOException {
		  File s=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(s, new File("C:\\Users\\chait\\OneDrive\\Pictures\\screenshot.png"));
		  
		  
	        }
	    
}


	
	
