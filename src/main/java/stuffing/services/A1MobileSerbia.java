package stuffing.services;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;

import static httpclient.URLEncodedForm.newFormBody;
import static java.net.http.HttpRequest.BodyPublishers.ofString;
import static java.nio.charset.StandardCharsets.UTF_8;
import static stuffing.util.Functions.escapeJson;

import static httpclient.URLEncodedForm.newFormBody;
import static stuffing.util.Utils.newHttpCall;

public class A1MobileSerbia {

    public static void main(final String... args) throws IOException {
        login("test", "test");
    }

    public static boolean login(final String username, final String password) throws IOException {

//        Response response = Jsoup.connect("https://a1.rs/privatni?login").execute();

        final var response = newHttpCall()
                .uri("https://asmp.a1.rs")
                .post("/asmp/ProcessLoginServlet")
                .body(newFormBody()
                    .add("userRequestURL", "https://a1.rs/moj_a1")
                    .add("service", "LoginLevel10")
                    .add("level", "30")
                    .add("SetMsisdn", "false")
                    .add("UserID", username)
                    .add("Password", password))
                .execute()
//                .verifyNotServerError()
//                .verifySuccess()
                .fetchBodyAsString(UTF_8);

        System.out.println(response);
        return !response.contains("Korisničko ime ili lozinka su neispravni. Pokušaj ponovo.");
    }

}
