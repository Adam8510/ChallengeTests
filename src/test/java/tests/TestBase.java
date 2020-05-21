
package tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import common.DriverManager;
import common.DriverUtils;

public class TestBase {

    @BeforeMethod
    public void beforeTest(){
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage("C:/HSBC_zadanie/coding-challenge/src/main/resources/index.html");

    }

    @AfterMethod
    public void afterTest(){
        DriverManager.disposeDriver();
    }
}
