package test.testnglistener;

import com.qa.framework.testnglistener.ICustomTestListener;
import org.apache.log4j.Logger;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestResult;

/**
 * Created by kcgw001 on 2016/4/18.
 */
public class TestListener implements ICustomTestListener {
    private static Logger logger = Logger.getLogger(TestListener.class.getSimpleName());
    public void onTestFailure(ITestResult tr) {
        logger.info("onCustomTestFailure");
    }

    public void onTestSkipped(ITestResult tr) {
        logger.info("onCustomTestSkipped");
    }

    public void onTestSuccess(ITestResult tr) {
        logger.info("onCustomTestSuccess");
    }

    public void onTestStart(ITestResult tr) {
        logger.info("onTestStart");
    }

    public void onFinish(ISuite iSuite) {
        logger.info(iSuite.getName() + " finish");
    }

    public void onStart(ISuite iSuite) {
        logger.info(iSuite.getName() + " start");
    }

    public void onStart(ITestContext testContext) {
        logger.info("onStart");
    }

    ;

    public void onFinish(ITestContext testContext) {
        logger.info("onFinish");
    }

    ;
}
