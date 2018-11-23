package com.eSign.index;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.testng.annotations.Test;
import com.eSign.init.Common;
import com.eSign.init.SeleniumInit;
import com.utility.TestData;

public class SignedForOneSigner_index extends SeleniumInit{
	
	
	public static int step, numberOfFailure;
	
	@Test
	
	/*
	 * TC_DB_01
	 */
	public void SignedForOneSigner(){
		
		step=1; numberOfFailure=0;	
		
		Common.logcase("Verify that User is in Login Page and Username and Password Option is Available");
		
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(Calendar.getInstance().getTime());
		Common.log("Time and Date of Test Execution===>" +timeStamp);
		System.err.println("Time and Date of Test Execution===>" +timeStamp);
		
		/*
		 * Verify Login Page
		 */
		
	/*	boolean verify_loginpage = signedforonesignergeneralverification.VerifyLoginPage();
		
		if(verify_loginpage){
			Common.log("===>URL is Launched and User is Redirected to Login Page</br>");
			Common.AssertPassed();
		}	
		else{
			Common.log("===>URL is Launched and User is not Redirected to Login Page</br>");
			Common.AssertFailed();
	}*/
	
		/*
		 * Verify that User is Login with Valid Username and Password
		 */
		Common.logcase("Login Page : Verify that User is Login with Valid Username and Password.");
		
		Common.logstep("Step "+(step++)+"Enter Username");
		signedforonesignergeneralverification=signedforonesignergeneralindexpage.Username(TestData.getUserName());
			
		Common.logstep("Step "+(step++)+"Enter Password");
		signedforonesignergeneralverification=signedforonesignergeneralindexpage.Password(TestData.getPassword());
		
		Common.logstep("Step "+(step++)+"Click on Login Button");
		signedforonesignergeneralverification=signedforonesignergeneralindexpage.clickonLoginButton();
		
		
		boolean homepageverify = signedforonesignergeneralverification.verifyhomepage();
		
		if(homepageverify){
			Common.log("===>USer is Redirected to Home Page</br>");
			Common.AssertPassed();
		}	
		else{
			Common.log("===>User is not Redirected to Home Page</br>");
			Common.AssertFailed();
			numberOfFailure++;
	}
		
		
		/*
		 * Select IBM Digital From DropDown
		 */
		
		Common.logstep("Step "+(step++)+"Choose Option From WorkFlow DropDown");
		signedforonesignergeneralverification=signedforonesignergeneralindexpage.chooseIbmDigital();
		
		/*
		 * Click on Create Option
		 */
		
		Common.logstep("Step "+(step++)+"Click on Create Option");
		signedforonesignergeneralverification=signedforonesignergeneralindexpage.createpackage();
		
		
		/*
		 * Fill the borrower 1 Details
		 */
		
		Common.logstep("Step "+(step++)+"Fill the Borrower 1 Details");
		signedforonesignergeneralverification=signedforonesignergeneralindexpage.BorrowerOneDetails();
		
		
		/*
		 *Attach the WARF Document 
		 */
		 
		Common.logstep("Step "+(step++)+"Attach the WARF Document Randomly");
		signedforonesignergeneralverification=signedforonesignergeneralindexpage.wafrattachment();
		
		
		/*
		 * Click on Check Box For Guarantor ::1
		 */
		
		Common.logstep("Step "+(step++)+"Click on Check Box For Guarantor ::1 and fill all details");
		signedforonesignergeneralverification=signedforonesignergeneralindexpage.GurantorOneDetails();
		

		/*
		 * Click on Relationship Manager ::
		 */
		
		Common.logstep("Step "+(step++)+"Click on Check Box For Relationship Manager and fill all details");
		signedforonesignergeneralverification=signedforonesignergeneralindexpage.RelationshipManager();
		
		/*
		 * Click on WARF Attachment
		 */
		
		Common.logstep("Step "+(step++)+"Click on Warf Attachment CheckBox");
		signedforonesignergeneralverification=signedforonesignergeneralindexpage.WarfAttachmentfile();
		
		/*
		 * Click on Create Button
		 */
		
		Common.logstep("Step "+(step++)+"Click on Create Button");
		signedforonesignergeneralverification=signedforonesignergeneralindexpage.createbutton();
		
		
		/*
		 * Upload the Document 
		 */
		
		Common.logstep("Step "+(step++)+"Click on Create Button");
		signedforonesignergeneralverification=signedforonesignergeneralindexpage.DocumentRequired();
		
		/*
		 * Read Data From Mailinator
		 */
		
		Common.logstep("Step "+(step++)+"Click on Create Button");
		signedforonesignergeneralverification=signedforonesignergeneralindexpage.ReadDataFromMailinator();
		
		/*
		 * Go inside mailinator Mail and Click on the mail
		 */
		
		Common.logstep("Step "+(step++)+"Click on Create Button");
		signedforonesignergeneralverification=signedforonesignergeneralindexpage.IBMDigitalMail();
		
		
		/*
		 * Fill The Loan Document Details
		 */
		
		Common.logstep("Step "+(step++)+"Click on Loan Document Page and Fill The Loan Document Details");
		signedforonesignergeneralverification=signedforonesignergeneralindexpage.loandocumentpage();
		
		
	/*
	 * Loan Document Form FillUpVerification	
	 */

			/*boolean verify_loanpage = signedforonesignergeneralverification.loanportalVerification();
			
			if(verify_loanpage){
				Common.log("===>Loan Page has Been Verified Successfully</br>");
				Common.AssertPassed();
			}	
			else{
				Common.log("===>Loan Page has Not Been Verified Successfully</br>");
				Common.AssertFailed();*/
		
//}
			
		Common.logstep("Step "+(step++)+"Verify Thanks Message is Displayed");
		signedforonesignergeneralverification=signedforonesignergeneralindexpage.thanksmsg();
			
} 
	}