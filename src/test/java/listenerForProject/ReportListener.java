/**
 * 
 */
package listenerForProject;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.BaseClass.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.utitlities.ExtentReportsClass;
import com.utitlities.ScreenShotClass;

/**
 * @author nagaraj.k
 *
 */
public class ReportListener extends BaseClass implements ITestListener {

	ExtentReports extentReports=ExtentReportsClass.reportGenerator();
	ExtentTest extentTest;
	private static ThreadLocal<ExtentTest> threadLocalTest= new ThreadLocal<ExtentTest>();
	
	
	@Override
	public void onTestStart(ITestResult result) {
		extentTest=extentReports.createTest(result.getMethod().getMethodName());
		threadLocalTest.set(extentTest);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
	
		threadLocalTest.get().log(Status.PASS, "It is successful");
	}
	@Override
	public void onTestFailure(ITestResult result) {
	
		threadLocalTest.get().fail("hi", MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotClass.takeScreenShot()).build());
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}
	@Override
	public void onStart(ITestContext context) {
		
	}
	@Override
	public void onFinish(ITestContext context) {
		
		extentReports.flush();
		
	}
	
	
	

}
