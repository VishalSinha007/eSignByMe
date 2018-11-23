package com.testReport.utility;

import java.util.Set;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	
	@Override
    public void onFinish(ITestContext context) {
		Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
		Set<ITestResult> skippedTests = context.getSkippedTests().getAllResults();
		
		/*for (ITestResult temp : failedTests) {
			ITestNGMethod method = temp.getMethod();
			if (context.getFailedTests().getResults(method).size() > 1) {
				failedTests.remove(temp);
			} else {
				if (context.getPassedTests().getResults(method).size() > 0) {
					failedTests.remove(temp);
				}
			}
		}*/
		
		for (ITestResult tempfailed : failedTests) {
			ITestNGMethod methodfailed = tempfailed.getMethod();
			for (ITestResult tempskip : skippedTests) {
				ITestNGMethod methodskipped = tempskip.getMethod();
				if (methodfailed.equals(methodskipped)) {
					System.err.println(methodfailed.getMethodName()+"======="+methodskipped.getMethodName());
					skippedTests.remove(methodfailed);
				}
			}
			 /*else {
				if (context.getPassedTests().getResults(method).size() > 0) {
					failedTests.remove(temp);
				}
			}*/
		}
	}
  
    public void onTestStart(ITestResult result) {   }
  
    public void onTestSuccess(ITestResult result) {   }
  
    public void onTestFailure(ITestResult result) {   }

    public void onTestSkipped(ITestResult result) {   }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {   }
}  