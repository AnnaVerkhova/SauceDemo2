package mavenTest;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import io.qameta.allure.TmsLinks;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Retry;

public class ExternalPropertyTest {

   // @Test(retryAnalyzer = Retry.class)
    @Test(description = "Тестирование параметров которые передаются через Maven.")
    @Issue(value = "DIN-5")
    @TmsLinks({
            @TmsLink(value = "DIN-1"),
            @TmsLink(value = "DIN-2"),
    })

    public void browserPropertyTest() {
        //String externalProperty = System.getenv("browser");
        String externalProperty = System.getProperty("browser");
        Assert.assertEquals(externalProperty, "CHROME");
    }
}
