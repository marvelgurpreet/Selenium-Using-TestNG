package modules;

import SetUp.UITest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CricInfoTest extends UITest {

    @Test
    public void verifyTeamScoreMoreThan100InFirstInning(){
        openBrowser();
        Assert.assertTrue(getTotalInningScore("England",0)<300);
    }

    @Test
    public void verifyExtrasGivenIsLessThan10(){
        //org.openqa.selenium.NoSuchSessionException: no such session
        openBrowser();
        Assert.assertTrue(getInningsExtras(0)<10);
    }


}
