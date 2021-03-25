package reportConfig;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentReportManager {
    private ExtentReportManager() {
    }

    static ThreadLocal<ExtentTest> tl = new ThreadLocal();

    static void setTest(ExtentTest test) {
        tl.set(test);
    }

    static ExtentTest getTest() {
        return tl.get();
    }

    public static void unloadTest() {
        tl.remove();
    }
}
