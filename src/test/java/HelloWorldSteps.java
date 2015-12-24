import com.google.gson.Gson;
import cucumber.api.java8.En;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class HelloWorldSteps implements En {

    public static final String HOME_PAGE_ADDRESS = "http://localhost:4567";
    public static WebDriver driver = new HtmlUnitDriver();

    private String userName;

    public HelloWorldSteps(){
        Given("^a user \"([^\"]*)\"$", (String userName) -> {
            this.userName = userName;
        });
        When("the user logs into the application", () -> {
            driver.get(HOME_PAGE_ADDRESS + ("?user=" + userName));
        });
        Then("^the user should receive a \"([^\"]*)\"$", (String expected) -> {
            String response = new Gson().fromJson(driver.getPageSource(), String.class);
            assertThat(response, is(equalTo(expected)));
        });
    }

}
