package retry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer // used to rerun the testcase
{
	private static final Logger LOG = LogManager.getLogger("Retry.class"); // initialize logger for track and log test
																			// retry attempts using log4j
	private static final int maxTry = 2; // maximum number of retry

	private int count = 0; // how many times the retry has been attempted

	@Override
	public boolean retry(final ITestResult iTestResult) {
		if (!iTestResult.isSuccess()) 
		{
			if (this.count < maxTry) 
			{
				LOG.info("Retrying test " + iTestResult.getName() + " with status "
						+ getResultStatusName(iTestResult.getStatus()) + " for the " + (this.count + 1) + " time(s).");
				this.count++;
				return true; // indicates retry attempts
			}
		}
		return false; // no more attempts of retry
	}

	public String getResultStatusName(final int status) 
	{
		String resultName = null;
		if (status == 1) 
		{
			resultName = "SUCCESS";
		}
		if (status == 2) 
		{
			resultName = "FAILURE";
		}
		if (status == 3) 
		{
			resultName = "SKIP";
		}
		return resultName;
	}

}
