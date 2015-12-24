import com.google.gson.Gson;

import static spark.Spark.get;

public class SeriesStalker {

    public static void main(String[] args) {
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
}
