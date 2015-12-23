import cucumber.api.PendingException;
import cucumber.api.java8.En;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class HelloWorldSteps implements En {

    private User user;
    private String response;

    public HelloWorldSteps(){
        Given("a User", () -> {
            user =  new User();
        });
        When("the User logs into the application", () -> {
            SeriesStalker seriesStalker = new SeriesStalker();
            response = seriesStalker.login(user);
        });
        Then("^the User should receive a \"([^\"]*)\"$", (String expected) -> {
            assertThat(response, is(equalTo(expected)));
        });
    }
}
