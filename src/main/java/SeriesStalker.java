import com.google.gson.Gson;

import static spark.Spark.get;
import static spark.SparkBase.port;

public class SeriesStalker {

    public static final int HEROKU_DEFAULT_PORT = 4567;
    public static final String PORT = "PORT";

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        Gson gson = new Gson();
        get("/",
            (request, response) -> {
                response.type("application/json");
                return login(request.queryParams("user"));
            },
            gson::toJson
        );
    }

    public static String login(String user) {
        return "Hello " + user + "!";
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get(PORT) != null) {
            return Integer.parseInt(processBuilder.environment().get(PORT));
        }
        return HEROKU_DEFAULT_PORT;
    }
}
