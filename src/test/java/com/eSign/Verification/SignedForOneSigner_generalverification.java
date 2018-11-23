package com.eSign.Verification;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.eSign.init.AbstractPage;
import com.eSign.init.Common;


public class SignedForOneSigner_generalverification extends AbstractPage{
	

	public SignedForOneSigner_generalverification(WebDriver driver) {
		super(driver);
	}

	
	/*
	 * Login Page (Login Logo is Displayed) 
	 */
		
		@FindBy(xpath="//legend[text()='Login']")
		WebElement loginlogoisdisplayed;
		
		@FindBy(xpath="//label[text()='Username']")
		WebElement Usernameoption;
		
		@FindBy(xpath="//label[text()='Password']")
		WebElement Passwordoption;
		
		
		
		public boolean VerifyLoginPage(){

		if (loginlogoisdisplayed.isDisplayed()) {
			
			Common.waitForElement(driver, userfullname);
			Common.log("==>Login Logo is Displayed::==>" +loginlogoisdisplayed.getText());
			System.err.println("==>Login Logo is Displayed::==>" +loginlogoisdisplayed.getText());
			
		 if(Usernameoption.isDisplayed()){
			 
				Common.waitForElement(driver, userfullname);
				Common.log("==>Username option is Displayed in Login Page::==>" +Usernameoption.getText());
				System.err.println("==>Username option is Displayed in Login Page::==>" +Usernameoption.getText());
			 
		 }	
			
		 if(Passwordoption.isDisplayed()){
			 
				Common.waitForElement(driver, userfullname);
				Common.log("==>Password option is Displayed in Login Page::==>" +Passwordoption.getText());
				System.err.println("==>Password option is Displayed in Login Page::==>" +Passwordoption.getText());
			 
		 }	
			
			return true;
			
		}else {
			 
			Common.log("==>Login Logo is Not Displayed::==>" +loginlogoisdisplayed.getText());
			System.err.println("==>Login Logo is Not Displayed::==>" +loginlogoisdisplayed.getText());
			
			Common.log("==>Username Option is Not Displayed in Login Home Page::==>" +Usernameoption.getText());
			System.err.println("==>Username Option is Not Displayed in Login Home Page::==>" +Usernameoption.getText());
			
			Common.log("==>Password Option is Not Displayed in Login Home Page::==>" +Passwordoption.getText());
			System.err.println("==>Password Option is Not Displayed in Login Home Page::==>" +Passwordoption.getText());
			
			return false;
	}
	}
		
	
		/*
		 * User is Redirected to Home Page
		 */
		
		
		@FindBy(xpath="//span[contains(.,'Welcome DEV09 Account')]")
		WebElement userfullname;
		
		
		public boolean verifyhomepage(){
			
			if(userfullname.isDisplayed()){
				
				Common.log("	User Full Name is Displayed ===>" +userfullname.getText());
				System.err.println("	User Full Name is Displayed ===>" +userfullname.getText());
				
				Common.log("	Get the Current Page URL ===>" +driver.getCurrentUrl());
				System.err.println("	Get the Current Page URL ===>" +driver.getCurrentUrl());
				return true;
			}else{
				
				Common.log("	Home Page URL NOt Matches and get the Current URL ===>" +driver.getCurrentUrl());
				System.err.println("	Home Page URL NOt Matches and get the Current URL ===>" +driver.getCurrentUrl());
			}
			return false;
		}
		
		
		/*
		 * LOAN Document Portal Verification
		 */
		
		@FindBy(xpath="//span[contains(.,'Not viewed')]")
		WebElement NotViewed;
		
		@FindBy(xpath="//span[text()='Viewed']")
		WebElement Viewed;
		
		@FindBy(xpath="//span[text()='Unsigned']")
		WebElement UnSigned;
		
		@FindBy(xpath="//span[text()='Signed']")
		WebElement Signed;
		
		@FindBy(xpath="//span[text()='Optional']")
		WebElement Optional;
		
		@FindBy(xpath="//span[text()='File uploaded']")
		WebElement FileUploaded;
		
		
		public boolean loanportalVerification(){
			
			if(NotViewed.isDisplayed()){
				
				Common.log("Document has Not been Selected===>" +NotViewed.getAttribute("value"));
				System.err.println("Document has Not been Selected===>" +NotViewed.getAttribute("value"));
				
				
			if(Viewed.isDisplayed()){
				
					Common.log("Document has been Viewed===> " +Viewed.getAttribute("value"));
					System.err.println("Document has been Viewed===> " +Viewed.getAttribute("value"));
					
			if(UnSigned.isDisplayed()){
				
				Common.log("Document is Not Assigned===>" +UnSigned.getAttribute("value"));
				System.err.println("Document is Not Assigned===>" +UnSigned.getAttribute("value"));
				
			if(Signed.isDisplayed()){
				
				Common.log("Documents has been Alloted===> " +Signed.getAttribute("value"));
				System.err.println("Documents has been Alloted===> " +Signed.getAttribute("value"));
				
			if(FileUploaded.isDisplayed()){
				
				Common.log("File has been Uploaded===>" +FileUploaded.getAttribute("value"));
				System.err.println("File has been Uploaded===>" +FileUploaded.getAttribute("value"));
				
				return true;
			}	}
			  }		}
			
			}else{
				
				
				Common.log("Document is Not Selected and Viewed");
				Common.log("Document is Not Selected and Signed");
				Common.log("Document is Not Uploaded");
				
				System.err.println("Document is Not Selected and Viewed");
				System.err.println("Document is Not Selected and Signed");
				System.err.println("Document is Not Uploaded");
			}
			return false;
		}
		
		
}
