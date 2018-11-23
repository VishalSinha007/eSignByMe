package com.eSign.indexpage;

import java.io.File;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import com.eSign.Verification.SignedForOneSigner_generalverification;
import com.eSign.init.AbstractPage;
import com.eSign.init.Common;

public class SignedForOneSigner_generalindexpage extends AbstractPage{
	
	public static String mobile="+61444444444";
	public static String authencation="555555";
	
	public SignedForOneSigner_generalindexpage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@type='text' and @name='username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@type='password' and @name='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit' and @title='login']")
	private WebElement clickonloginbutton;
	
	@FindBy(xpath="//th[text()='Package Name']")
	private WebElement homepage;
	
	
	public SignedForOneSigner_generalverification Username(String UserName){
		
		Common.waitForElement(driver, username);
		Common.pause(2);
		Common.type(username, UserName);
		Common.log("  -> Username entered: "+username.getAttribute("value"));
		
		return new SignedForOneSigner_generalverification(driver);
		
	}
	
	public SignedForOneSigner_generalverification Password(String PassWord){
		
		Common.waitForElement(driver, password);
		Common.pause(2);
		Common.type(password, PassWord);
		Common.log("  -> Password entered: "+password.getAttribute("value"));
		
		return new SignedForOneSigner_generalverification(driver);
	}
	
	public SignedForOneSigner_generalverification clickonLoginButton(){
		
		Common.pause(2);
		clickonloginbutton.click();
		
		return new SignedForOneSigner_generalverification(driver);
	}
	
	
	@FindBy(id="workflows")
	private WebElement workflow;
	
	@FindBy(xpath="//select[@id='workflows']")
	private WebElement ibmdigital;
	
	public SignedForOneSigner_generalverification chooseIbmDigital(){
		
		Common.waitForElement(driver, ibmdigital);
		Select select=new Select(ibmdigital);
		Common.pause(2);
		select.selectByVisibleText("IBM Digital Contracts Demo v. 1");
		Common.log("  -> Select workflow from the DropDown: IBM Digital Contracts Demo v. 1");
		
		return new SignedForOneSigner_generalverification(driver);
	}
	
	@FindBy(xpath="//button[@id='create_package']")
	private WebElement createpackage;
	
	public SignedForOneSigner_generalverification createpackage(){
		
		Common.waitForElement(driver, createpackage);
		Common.pause(2);
		createpackage.click();
		Common.log("  -> Click on Create Option"+createpackage.getText());
		
		return new SignedForOneSigner_generalverification(driver);
	}
	
	@FindBy(xpath="//input[@id='packageReference']")
	private WebElement internalreferance;
	
	@FindBy(xpath="//input[contains(@class,'firstName')]")
	private List <WebElement> firstname;
	
	@FindBy(xpath="//input[contains(@class,'lastName')]")
	private List <WebElement> lastname;
	
	@FindBy(xpath="//input[@class='email']")
	private List <WebElement> email;
	
	@FindBy(xpath="//input[@class='phone']")
	private List <WebElement> phonenumber;
	
	
	/*
	 * Borrower 1 Details
	 */
	
	String Email1 = "autoemailBorrower"+Common.generateRandomChars(8);
	String	randonemail1=Email1+"@mailinator.com";
	
	public SignedForOneSigner_generalverification BorrowerOneDetails(){
		
		String rfrnce = "InternalRefranceName"+Common.generateRandomChars(8);
		Common.type(internalreferance, rfrnce);
		Common.log("  -> Internal Refrence Value ===>" +internalreferance.getAttribute("value"));
		
		String fname = "FirstName"+Common.generateRandomChars(8);
		Common.type(firstname.get(0), fname);
		Common.log("  -> First Name ===>" +firstname.get(0).getAttribute("value"));
		
		String lname = "LastName"+Common.generateRandomChars(8);
		Common.type(lastname.get(0), lname);
		Common.log("  -> Last Name ===>" +lastname.get(0).getAttribute("value"));
		
		Email1 = "autoemailBorrower"+Common.generateRandomChars(8);
		Common.type(email.get(0), randonemail1);
		Common.log("  -> Email Id ===>" +email.get(0).getAttribute("value"));
		
		Common.type(phonenumber.get(0), mobile);
		Common.log("  -> Phone Number ===>" +mobile);
		
		return new SignedForOneSigner_generalverification(driver);
	}
	
	
	@FindBy(xpath="//span[@class='table']//span//input")
	private List<WebElement> WarfAttachment;
	
	@FindBy(xpath="//span[@class='tablecell']//input[@type='checkbox']")
	private List<WebElement> WarfAttachmenttext;
	
	/*
	 * WAFR Attachment
	 */
	
	public SignedForOneSigner_generalverification wafrattachment(){
		
		int sizeofdocument = WarfAttachmenttext.size();
		Common.log("  -> Total Number of Document Attached in Page ===>" +sizeofdocument);
		
		int itemselect = Common.randBetween(0, WarfAttachmenttext.size()-1);
		Common.log("  -> "+(itemselect+1)+" Attachments going to be select.");
		
		for(int i=0;i<=itemselect;i++){
			
			WarfAttachmenttext.get(i).click();
			Common.log("  ->Attachment is Selected");
			Common.pause(2);
		}
		
		return new SignedForOneSigner_generalverification(driver);
	}
	
	
	/*
	 *Gurantor 1 Details to be Filled 
	 */
	
	@FindBy(xpath="//div[@class='rolename']//input")
	private List<WebElement> Gurantorcheckbox;
	
	String Email2 = "autoemailgurantor"+Common.generateRandomChars(10);
	
	public SignedForOneSigner_generalverification GurantorOneDetails(){
		
		Gurantorcheckbox.get(1).click();
		Common.log("Click on Check Box Guarantor::1");
		
		String fname = "FirstName"+Common.generateRandomChars(10);
		Common.type(firstname.get(1), fname);
		Common.log("  -> First Name ===>" +firstname.get(1).getAttribute("value"));
		
		String lname = "LastName"+Common.generateRandomChars(10);
		Common.type(lastname.get(1), lname);
		Common.log("  -> Last Name ===>" +lastname.get(1).getAttribute("value"));
		
		Email2 = "autoemailgurantor"+Common.generateRandomChars(10);
		Common.type(email.get(1), Email2+"@mailinator.com");
		Common.log("  -> Email Id ===>" +email.get(1).getAttribute("value"));
		
		Common.type(phonenumber.get(1), mobile);
		Common.log("  -> Phone Number ===>" +mobile);
		
		return new SignedForOneSigner_generalverification(driver);
	}
	
	
	String Email3 = "autoemailrelationship"+Common.generateRandomChars(12);
	
	public SignedForOneSigner_generalverification RelationshipManager(){
		
		Gurantorcheckbox.get(2).click();
		Common.log("Click on Check Box Relationship Manager::");
		
		String fname = "FirstName"+Common.generateRandomChars(12);
		Common.type(firstname.get(2), fname);
		Common.log("  -> First Name ===>" +firstname.get(2).getAttribute("value"));
		
		String lname = "LastName"+Common.generateRandomChars(12);
		Common.type(lastname.get(2), lname);
		Common.log("  -> Last Name ===>" +lastname.get(1).getAttribute("value"));
		
		Email3 = "autoemailrelationship"+Common.generateRandomChars(12);
		Common.type(email.get(2), Email3+"@mailinator.com");
		Common.log("  -> Email Id ===>" +email.get(1).getAttribute("value"));
		
		Common.type(phonenumber.get(2), mobile);
		Common.log("  -> Phone Number ===>" +mobile);
		
		return new SignedForOneSigner_generalverification(driver);
	}
	
	/*
	 * WARF Document Attachment
	 */
	
	@FindBy(xpath="//span[@class='table']//span//input[@title]")
	private List<WebElement> WarfAttachmentfile;
	
	
	public SignedForOneSigner_generalverification WarfAttachmentfile(){
		
		Common.log("  -> Number of element Under Warf File ===>" +WarfAttachmentfile.size());
		Common.pause(2);
		WarfAttachmentfile.get(11).click();
		
		return new SignedForOneSigner_generalverification(driver);
	}
	
	/*
	 * WARF Document Attachment
	 */
	
	@FindBy(xpath="//button[@id='createpkgid']")
	private WebElement createbutton;
	
	
	public SignedForOneSigner_generalverification createbutton(){
		
		Common.log("  -> Click on Create Button After filling All the Details ===>" +createbutton.getText());
		Common.pause(4);
		Common.jsClick(driver, createbutton);
		
		return new SignedForOneSigner_generalverification(driver);
	}
	
	/*
	 * Upload A Document
	 */
	
	@FindBy(xpath="//span[contains(.,'Cloud Services Agreement')]/../..//input")
	private List<WebElement> DocumentRequired;
	
	@FindBy(xpath="//span[contains(.,'Cloud Services Agreement')]/../..//input[@type='file']")
	private WebElement ChooseaFile;
	
	@FindBy(xpath="//button[@id='sendPackage']")
	private WebElement SendNowButton;
	
	File file=new File("D:\\Workspace\\eSign\\Resources\\Cloud Hosting Agreement.pdf");
	
	public SignedForOneSigner_generalverification DocumentRequired(){
		
		Common.waitForElement(driver, driver.findElement(By.xpath("//h3[contains(.,'Documents to be e-signed:')]")));
		DocumentRequired.get(0).click();
		Common.log("  -> Click on Cloud service Aggrement <-  ");
		
		Common.waitForElement(driver, By.xpath("//span[@id='fileupload']//span[text()='Cloud Services Agreement']"));
		Common.pause(2);
		//Common.clickOn( driver, ChooseaFile);
		
		//Common.waitForElement(driver,By.xpath("//span[@class='fa fa-check']"));
	//	File file=new File("D:\\Workspace\\eSign\\Resources\\Cloud Hosting Agreement.pdf");
		ChooseaFile.sendKeys(file.getAbsolutePath());
		Common.log("  -> New File Uploaded ===>" +file.getAbsolutePath());
		
		Common.pause(8);
		Common.waitForElement(driver, SendNowButton);
		Common.pause(8);
		Common.clickOn(driver, SendNowButton);
		Common.log("  -> Click on Send Now Button "  );
		
		return new SignedForOneSigner_generalverification(driver);
	}
	
	
	/*
	 * Go to Mailinator
	 */
	
	@FindBy(xpath=".//input[@id='inboxfield']")
	private WebElement writeemailid;
	
	@FindBy(xpath="//span[@class='input-group-btn']")
	private WebElement GoButton;
	
	public SignedForOneSigner_generalverification ReadDataFromMailinator(){
		
		Common.pause(3);
		Common.log("  ===>  Navigate to Mailinator  <===");
		driver.navigate().to("https://www.mailinator.com/");
		writeemailid.sendKeys(randonemail1);
		Common.log(" --> Email ID In Mailinator ===>" +randonemail1.toString());
		
		Common.pause(2);
		Common.clickOn(driver, GoButton);
		
		return new SignedForOneSigner_generalverification(driver);
	}
	
	
	/*
	 * Read Data in Mailinator
	 */
	
	@FindBy(xpath="//tr[@class='even pointer ng-scope']/td[4]")
	 WebElement IBMDigitalMailclick;
	
	@FindBy(xpath="//a[contains(.,'Go to My documents')]")
	 WebElement GoToMyDocument;
	
	@FindBy(xpath="//button[text()='Accept']")
	WebElement Acceptbutton;
	
	@FindBy(xpath="//a[contains(.,'Request SMS Authentication Code')]")
	WebElement SmsAuthencticationCode;
	
	@FindBy(xpath="//input[@ng-model='passcode']")
	private WebElement EnterSmsCode;
	
	@FindBy(xpath="//button[text()='Authenticate']")
	private WebElement AuthenticateClick;
	
	String currWin=driver.getWindowHandle();
	
	public SignedForOneSigner_generalverification IBMDigitalMail(){
		
		 @SuppressWarnings("unused")
		String IBMDigitalMail = "//tr[@class='even pointer ng-scope']/td[4]";
		
		Common.waitForElementAndRefresh(driver, "IBMDigitalMail");
		
		//Common.waitForElement(driver, GoToMyDocument);
		Common.pause(2);
		Common.jsClick(driver, IBMDigitalMailclick);
		Common.log("  ---> Click on First mail in Email " );
		
		driver.switchTo().frame(driver.findElement(By.id("msg_body")));
		
		Common.waitForElement(driver, GoToMyDocument);
		Common.moveToElementByJs(driver, GoToMyDocument);
		Common.clickOn(driver, GoToMyDocument);
		Common.log("   ---> Click on My Document Option " +GoToMyDocument.getText());
		driver.switchTo().defaultContent();
		
		 currWin=driver.getWindowHandle();
		System.err.println("   --------->"+currWin+"<----------------- ");
		
		for (String handle : driver.getWindowHandles()) {
			 
			driver.switchTo().window(handle);
			
			System.err.println("----"+handle+"-----");
			
		}
		
		Common.pause(2);
		Common.waitForElement(driver, By.xpath("//button[text()='Accept']"));
		Common.pause(2);
		Common.jsClick(driver, Acceptbutton);
		//Common.log("  ----> Click on Accept Button and Go to SmS Authentication Page<--- " +Acceptbutton.getText());
		
		Common.waitForElement(driver, SmsAuthencticationCode);
		Common.jsClick(driver, SmsAuthencticationCode);
		//Common.log("   --->Click on SmS Authentication Button====>" +SmsAuthencticationCode.getText());
		
		Common.waitForElement(driver, EnterSmsCode);
		Common.type(EnterSmsCode, "555555");
		Common.log("  ---->Enter SMS Code Authentication====>" +authencation);
		
		Common.waitForElement(driver, AuthenticateClick);
		Common.clickOn(driver, AuthenticateClick);
		Common.log("  ---->Click on Authentication option after sms Code<----");
		
		//driver.switchTo().window(currWin);
		
		return new SignedForOneSigner_generalverification(driver);
	}
	
	
	
	/*
	 * LOAN Document Portal
	 */
	
	
	@FindBy(xpath="//button[contains(.,'View document')]")
	List <WebElement> ViewDocumentClick;
	
	@FindBy(xpath="//button[contains(.,'Back to loan documents portal')]")
	WebElement BacktoLoanDocumentPortal;
	
	@FindBy(xpath="//button[contains(.,'Sign online')]")
	WebElement SignOnlineClick;
	
	@FindBy(xpath="//span//span[contains(.,'Opt Out')]")
	WebElement outputbutton;
	
	@FindBy(xpath="//div[@id='field-navigator-below']//span[@class='icon']")
	WebElement clickonmsgarrow;
	
	@FindBy(xpath="//div[@class='cts']")
	WebElement clicktoSign;
	
	@FindBy(xpath="//span[text()='Ok']")
	WebElement clickonOK;
	
	@FindBy(xpath="//a[@id='backButton']")
	WebElement ReturnHomePage;
	
	@FindBy(xpath="//span[text()='Upload']")
	List <WebElement> uploadclick;
	
	@FindBy(xpath="//div[@class='points-marker']/i[1]")
	WebElement clickonreadytouploadcheckbox;
	
	@FindBy(xpath="//button[contains(.,'Ready to upload')]")
	WebElement ReadyToUploadButton;
	
	@FindBy(xpath="//div[@id='uploader']//input[@title='file input']")
	WebElement SelectFile;
	
	@FindBy(xpath="//button[contains(.,'Upload Now')]")
	WebElement UploadFile;
	
	@FindBy(xpath="//a[contains(.,'Submit loan documents')]")
	WebElement SubmitLoanDocument;
	
	@FindBy(xpath="//h1[contains(.,'Thank you for signing your documents')]")
	WebElement ThanksMessage;
	
	
	
	
	public SignedForOneSigner_generalverification loandocumentpage(){
		
		Common.waitForElement(driver, By.xpath("//button[contains(.,'View document')]"));
		ViewDocumentClick.get(0).click();
		Common.log("  ---->Click on Product Disclosure Statement Example <----");
		
		Common.waitForElement(driver, BacktoLoanDocumentPortal);
		Common.clickOn(driver, BacktoLoanDocumentPortal);
		Common.log("--->Click on Back to Loan document Page<---");
		
		Common.waitForElement(driver, By.xpath("//button[contains(.,'View document')]"));
		SignOnlineClick.click();
		Common.log("  ---->Click on Product Disclosure Statement Example <----");
		
		Common.waitForElement(driver, outputbutton);
		Common.clickOn(driver, clickonmsgarrow);
		Common.log("===> Click on Message dropdown Icon");
		
		Common.waitForElement(driver, clicktoSign);
		Common.clickOn(driver, clicktoSign);
		Common.log("===>Click To Sign Option");
		
		Common.waitForElement(driver, clickonOK);
		Common.clickOn(driver, clickonOK);
		Common.log("===>Click on Ok Button Under Pop Up ");
		
		Common.waitForElement(driver, ReturnHomePage);
		Common.pause(5);
		Common.clickOn(driver, ReturnHomePage);
		Common.log("====>Click on Return Home Page to go Back to Home Page");
		
		int uploadclicksize=uploadclick.size();
		
		System.err.println("Upload Document Size=====>" +uploadclicksize);
		
			if(uploadclick.size()>0){
		
				for(int j=0;j<uploadclicksize;j++){
			
					uploadclick.get(j).click();
			 
		/*Common.pause(4);
		uploadclick.get(0).click();
		Common.log("====>Click on Upload Option");*/
		
		Common.waitForElement(driver, clickonreadytouploadcheckbox);
		Common.clickOn(driver, clickonreadytouploadcheckbox);
		Common.log("====>Click on CheckBox of are you Ready to Upload Transfer of Land");
		
		Common.waitForElement(driver, ReadyToUploadButton);
		Common.clickOn(driver, ReadyToUploadButton);
		Common.log("====>Click on Ready to Upload");
		
		File uploadfile=new File("Resources/Cloud Hosting Agreement.pdf");
		System.err.println(uploadfile.getAbsolutePath());
		
		Common.waitForElement(driver, By.xpath("//div[text()='Select File']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(SelectFile);
		Common.pause(4);
		SelectFile.sendKeys(uploadfile.getAbsolutePath());
		System.err.println("File Selected and Ready to upload");
		Common.pause(4);
		Common.log("====>Choose the Cloud Hosting Aggrement File");
		
		Common.waitForElement(driver, UploadFile);
		Common.pause(6);
		Common.clickOn(driver, UploadFile);
		Common.pause(11);
		Common.log("====> After Selecting the File Upload the File");
		
		}
		}
		
		/*Common.waitForElement(driver, SubmitLoanDocument);
		Common.pause(2);
		Common.clickOn(driver, SubmitLoanDocument);
		Common.log("====>Click on Submit Loan Document");
		
		
		Common.waitForElement(driver, ThanksMessage);
		Common.log("Get Thanks Message===> " +ThanksMessage.getText());
		
		
		driver.switchTo().window(currWin);*/
		
		return new SignedForOneSigner_generalverification(driver);
	}
	
	
	public SignedForOneSigner_generalverification thanksmsg(){
		
		Common.waitForElement(driver, SubmitLoanDocument);
		Common.pause(2);
		Common.clickOn(driver, SubmitLoanDocument);
		Common.log("====>Click on Submit Loan Document");
		
		
		Common.waitForElement(driver, ThanksMessage);
		Common.log("Get Thanks Message===> " +ThanksMessage.getText());
		
		
		driver.switchTo().window(currWin);
		
		return new SignedForOneSigner_generalverification(driver);
	}
	
}
