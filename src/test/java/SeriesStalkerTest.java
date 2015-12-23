import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SeriesStalkerTest {

    @Mock User user;

    @Test
    public void respond_with_hello_world_when_a_user_logs_in(){
        SeriesStalker seriesStalker = new SeriesStalker();
        String response = seriesStalker.login(user);
        assertThat(response, is(equalTo("Hello World!")));
    }
}