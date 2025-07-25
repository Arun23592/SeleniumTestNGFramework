package automation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class automateIPLPointsTable {

    @Test
    public void netRunRate(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.iplt20.com/points-table/men/2024");
        driver.manage().window().maximize();

        List<WebElement> rows = driver.findElements(By.xpath("//tbody[@id='pointsdata']//tr"));

        System.out.println("Teams with NRR between 0 and 1");
        for (WebElement row : rows){
            List<WebElement> columns = row.findElements(By.xpath("//h2[@class='ih-pt-cont mb-0 ng-binding']"));
                if(columns.size() >= 8){
                    System.out.println("Raw team name cell text: " + columns.get(1).getText());
                    // Assuming the team name is in the first column and NRR is in the 8th column
                    // Adjust the index if the structure of the table changes
                    // Clean up the team name by removing extra spaces
                    // and trimming it


                    String teamName = columns.get(0).getText().replace("\\s+", " ").trim();
                    String nrrText = columns.get(7).getText().trim();
                    try {
                        double nrr = Double.parseDouble(nrrText);
                        if (nrr > 0 && nrr < 1){
                            System.out.println(teamName+ " -> NRR: " + nrr);
                        }
                    }catch (NumberFormatException e){
                        System.out.println("Could not parse NRR for team: "+ teamName + " | NRR: " + nrrText);
                    }
                }
        }

    }
}
