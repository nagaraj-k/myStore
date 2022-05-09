package com.utitlities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryClass implements IRetryAnalyzer {
	
	int retry=0;
	final int maxRetry=0;
	
	@Override
	public boolean retry(ITestResult result)
	{
		if(retry<maxRetry)
		{
			retry++;
			return true;
		}
		return false;
	}

}
