package SetUp;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

abstract public class UITestSetUp {

    String driverType = "CHROME";
    WebDriver driver;
    private String url = "http://www.espncricinfo.com/series/18025/scorecard/1119535/england-vs-pakistan-1st-test-pak-in-ire-eng-scot-2018";

    @BeforeTest
    public void setDriver(){

        if (driverType.equals("CHROME")) {
            setChromeDriver();
        }
        else{

        }

    }

    public void setChromeDriver(){
        String dir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",dir+"\\src\\test\\java\\program\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public void openBrowser(){
        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void QuitBrowser(){
        driver.quit();
    }

}
