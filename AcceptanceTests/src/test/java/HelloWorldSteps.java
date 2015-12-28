import com.google.gson.Gson;
import cucumber.api.java8.En;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HelloWorldSteps implements En {

    public String url = System.getProperty("url");
    public static WebDriver driver = new HtmlUnitDriver();

    private String userName;

    public HelloWorldSteps(){
        Given("^a user \"([^\"]*)\"$", (String userName) -> {
            this.userName = userName;
        });
        When("the user logs into the application", () -> {
            driver.get(url + ("?user=" + userName));
        });
        Then("^the user should receive a \"([^\"]*)\"$", (String expected) -> {
            String response = new Gson().fromJson(driver.getPageSource(), String.class);
            MatcherAssert.assertThat(response, Is.is(IsEqual.equalTo(expected)));
        });
    }

}
