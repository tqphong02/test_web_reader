package web_1;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.text.DecimalFormat;

public class TestListener implements ITestListener {
    private ExtentReports extent;
    private ExtentTest test;
    private int passCount = 0;
    private int failCount = 0;
    private int skipCount = 0;

    public void onStart(ITestContext context) {
        ExtentSparkReporter spark = new ExtentSparkReporter("extent.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        String category = ""; // Phù hợp với test case từ BBT_Test
        String message = ""; // Thông điệp tùy chỉnh cho mỗi test case
        String minCondition = ""; // Điều kiện tối thiểu
        String maxCondition = ""; // Điều kiện tối đa

        switch (testName) {
            case "testLogin":
                category = "Test_Login";
                message = "Testcase đăng nhập";
                minCondition = "Đăng nhập với tên người dùng và mật khẩu hợp lệ";
                maxCondition = "Đăng nhập với tên người dùng và mật khẩu dài và phức tạp";
                break;
            case "testSearch":
                category = "Test_Search";
                message = "Testcase tìm kiếm";
                minCondition = "Tìm kiếm với từ khóa đơn giản";
                maxCondition = "Tìm kiếm với từ khóa phức tạp và kết quả lớn";
                break;
            case "testFollow":
                category = "Test_Follow";
                message = "Testcase theo dõi";
                minCondition = "Theo dõi truyện với tài khoản hợp lệ";
                maxCondition = "Theo dõi truyện với tài khoản và số lượng truyện lớn";
                break;
            case "testUnfollow":
                category = "Test_Unfollow";
                message = "Testcase bỏ theo dõi";
                minCondition = "Bỏ theo dõi truyện đã theo dõi";
                maxCondition = "Bỏ theo dõi nhiều truyện cùng một lúc";
                break;
            case "testLogout":
                category = "Test_Logout";
                message = "Testcase đăng xuất";
                minCondition = "Đăng xuất từ trang web";
                maxCondition = "Đăng xuất và xóa tất cả dữ liệu phiên đăng nhập";
                break;
            default:
                category = "Other";
                message = "Testcase không xác định";
                break;
        }

        // Ghi log với nội dung tùy chỉnh cho mỗi test case
        test = extent.createTest(testName)
                .assignAuthor("Web_Truyện") // Thay "Tên Tác giả ở đây" bằng tên tác giả thích hợp
                .assignCategory(category)
                .assignDevice("Chrome") // Thêm trình duyệt Chrome
                .assignDevice("Edge") // Thêm trình duyệt Edge
                .assignDevice("FireFox")
                .assignDevice("Cốc_Cốc");
        
        // Ghi log với thông điệp tùy chỉnh
        test.log(Status.INFO, message);
        test.log(Status.INFO, "Min: " + minCondition);
        test.log(Status.INFO, "Max: " + maxCondition);
    }



    private void assignDevice(String string) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test passed");
        passCount++;
    }

    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test failed");
        failCount++;
    }

    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test skipped");
        skipCount++;
    }

    public void onFinish(ITestContext context) {
        extent.flush();
        int totalCount = passCount + failCount + skipCount;
        double passPercentage = (double) passCount / totalCount * 100;
        DecimalFormat df = new DecimalFormat("0.00");

        // Ghi thông tin phần trăm pass vào báo cáo HTML
        test.pass("Pass percentage: " + df.format(passPercentage) + "%");

        System.out.println("===============================================");
        System.out.println("Test Suite");
        System.out.println("Total tests run: " + totalCount + ", Passes: " + passCount + ", Failures: " + failCount + ", Skips: " + skipCount);
        System.out.println("Pass percentage: " + df.format(passPercentage) + "%");
        System.out.println("===============================================");
    }
}