import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SeriesStalkerTest {

    private static final String USERNAME = "username";

    @Test
    public void respond_with_hello_world_when_a_user_logs_in(){
        String response = SeriesStalker.login(USERNAME);
        assertThat(response, is(equalTo("Hello " + USERNAME + "!")));
    }
}