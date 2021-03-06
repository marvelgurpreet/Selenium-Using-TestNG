package SetUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

public class UITest extends UITestSetUp {


    public HashMap<String,Integer> getPerPlayerInningScore(String teamName, String inningNo){

        HashMap<String, Integer> mapPlayerScore = new HashMap<String, Integer>();
        WebElement inning = driver.findElement(By.xpath("//*[contains(text(),'"+teamName+inningNo+"Innings')]/ancestor::ul"));
        //"//*[contains(@class,'scorecard')]/ul"

        List<WebElement> playerList = inning.findElements(By.xpath(".//div[contains(@class,'row')]/div[contains(@class,'batsmen')]"));


            for(WebElement player:playerList){

                String playerName = player.findElement(By.xpath("./div[contains(@class,'batsmen')]")).getText();
                int playerScore = Integer.parseInt(player.findElement(By.xpath("./div[contains(@class,'runs')]")).getText());
                mapPlayerScore.put(playerName,playerScore);

            }

            return mapPlayerScore;

    }

    public int getTotalInningScore(String teamName, String inningNo){

        int teamScore = 0;
        int score = 0;

        HashMap<String,Integer> playerScore = getPerPlayerInningScore(teamName, inningNo);

        Set set = playerScore.entrySet();
        Iterator iterator = set.iterator();

        while(iterator.hasNext()) {
            Map.Entry player = (Map.Entry)iterator.next();
            System.out.print("key is: "+ player.getKey() + " & Value is: ");
            score = Integer.parseInt(player.getValue().toString());
            teamScore = Integer.sum(teamScore,score);
        }

        return teamScore;
    }

    public int getInningsExtras(String teamName, String inningNo){

        int extras=0;

        HashMap<String, Integer> mapPlayerScore = new HashMap<String, Integer>();
        //List<WebElement> inning = driver.findElements(By.xpath("//*[contains(@class,'scorecard')]/ul"));
        //WebElement extra = inning.get(inningNo).findElement(By.xpath(".//div[contains(@class,'row')]/div[contains(@class,'extras')]/div[2]"));
        WebElement extra = driver.findElement(By.xpath("//*[contains(text(),'"+teamName+inningNo+"Innings')]/ancestor::ul//div[contains(@class,'row')]/div[contains(@class,'extras')]/div[2]"));
        extras = Integer.parseInt(extra.getText().toString().split("\\(")[0].trim());
        return extras;
    }




}
