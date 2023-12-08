package helpers;

import static io.restassured.RestAssured.given;

// curl -u "igormaximov_6M5WhC:dHoaqoM5875HEcmjCodp" -X GET "https://api.browserstack.com/app-automate/sessions/b6dcc4e5df2ecad6da6dfa54e25e4439d155a4d5.json" /sessions/0359d759d2aaa4f46401dac46bd281b6d9b24943.json"
public class Browserstack {

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic("igormaximov_6M5WhC", "dHoaqoM5875HEcmjCodp")
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}