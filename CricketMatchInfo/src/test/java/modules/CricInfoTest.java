package modules;

import SetUp.UITest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CricInfoTest extends UITest {


    static String FIRST_INNINGS="1st ";
    static String SECOND_INNINGS="2nd ";

    @Test
    public void verifyTeamScoreMoreThan100InFirstInning(){
        openBrowser();
        Assert.assertTrue(getTotalInningScore("England ",FIRST_INNINGS)<300);
    }

    @Test
    public void verifyExtrasGivenIsLessThan10(){
        //org.openqa.selenium.NoSuchSessionException: no such session
        openBrowser();
        Assert.assertTrue(getInningsExtras("England ",FIRST_INNINGS)<10);
    }


}
