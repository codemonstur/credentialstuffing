package stuffing.services;

import java.io.IOException;

import static httpclient.URLEncodedForm.newFormBody;
import static java.nio.charset.StandardCharsets.UTF_8;
import static stuffing.util.Utils.newHttpCall;

public class Alibaba {

    public static void main(final String... args) throws IOException {
        login("test@test.com", "test");
    }
    public static boolean login(final String username, final String password) throws IOException {

        // The website does some form of weird encoding of the password before sending it to the server. It is
        // not clear what it actually does.

        final var response = newHttpCall()
            .uri("https://login.alibaba.com")
            .post("/newlogin/login.do")
            .body(newFormBody()
                .add("loginId", username)
                .add("password", password)
                .add("scene", "pc")
                .add("lang", "en_US")
                .add("isIframe", "false")
                .add("banThirdCookie", "undefined")
                .add("bx-sys", "ua-l:us__um-l:us__js:https://assets.alicdn.com/g/")
                .add("bx-umidtoken", "T2gAJyvWTyaSAgFgTSfqPx9X_2iQfBJxmL0444vOtIesrlfJhAbbKg7qBKCBPkYsiOk=")
                .add("bx-ua", "228!FI6TpVYJRRo l bs9ftcg/GTQgXDKTYfVD6mCPZL94VVlhwKKwFUJ5 irVuXXqxl72gTnlZHUu EwGfC7MOOJjlVednqL8OWwDTd3ZGOLhU8rhM wVpnjFAcFVscPROvyqU4iuHFYBAVdLPqX dmLAycdIOVORZFnQmOuuLOWPnXybLmMXfU1zdlFp7yRC/lZUIPClZImAUzTGqcRzGzAlRlK17yRKUlVTRcClJIm/IzTGqcGRGDAlURv17hUCMZRRImFlmImYRlT2qPulYcAVU5LM7YUC/ZRRUbKl1Im/ZzRUAFRV1gAZRR107IuK/ZorIcuZEWbKXSgtPoIue8BMqcfqW3WRFuCwOtDCG b/Ici5QvVHm0oLqcK5WrdP8eiM3stqSJX5QMiIHG6S46COict5EVdcueFH3nKqIJXg2cF53v6HpeMM3cf5ErtzL/GDS4xygl/vzzOqbAel/xPxznvauTPZ7X9CFjNdc/obks1SsiuWTAnGmODCxvwx5bgfbGT6Bbotpk4Pj0/KEt7IDWBJJpQ4QSmw N8HhCh4AOkFLyRvIwSsDKZ8lTmS1 sXMHsDyMsjjQHoX4w1Uvy4Wkb6IJX9aWwM9FmNszstQHEucGa7PQZd4b98/HMU9ZV2cP4sdjV9md2kO6WnDZquc1LbfSP7leRj0eW9He37qm8PYgzAkEPLn/040h2YBuLW3bjU R2hZaP6GMbfKw4oR Rbond5H3ERDqN dHdfGQymB9vLtPjy4PHwQuFZ7nbYzk90wHHwDIOJWL5Ywp5tH9rFkp7IKEU  C FVZXIajbI7st0pN3CagW007xtX1HjXv8lxzvBtmJYXDeffCpbkgWSjAdspD2AHIKlXTH0siuGRX5ljBrVtR4wHmry5S7nyzM8LYSTgLuDCHfYejeeFYc1ShTl5IZMtRaw//QolDwNq7XGTnFckGQ4cTG7TdI3fNWQtu0Yb9yBI0cdpA9Mq2WQm2YzbKsy0FZwEiboRQklgvzeEgfNlJ1ZaFGnBebWYulyWKD3Rk5nnU1mLwQLklaCC6nLn1X2Xy/H0o9taSbrZJ77cngc5qUeS4Kt8IBM7aM A1zG UqQufgM8ZkFu9ioowazYDha43ijpp794WBXpgF6lRVUOeuKT/Q0wzqkI7VC6av68MxWhETc2g1QYgg9Y3seg3oeuQQiYyrp RwhME7tH5eVCkSAu4gTZPXxHSldkFDoJvHWB/MtZi7Io2seq5b/OOLgCdCKn8a9P6ldJvzHeVekXlvpat6gZLXkwff5xs7X8pjYZJ1DYADk0fASXkOh1vp HFvHQhlinDV/TdbJJGmU23f/qsJesE3bUq3Rm5ymrensDGg/ue2nMIgxVFzS7qnCF972I9nw07IYX 7X1n3hdpS js6kjrSj/TKIoYZUqnYH64/7LMmbuaqi a1Bm1 HMGqYA0 h3NINQH3UfLp ODtBHg5y t 0kpIsVuFSQ9LLRbRAHYwzANdVOMBTJX01vWDQxtyEpefELEhwFpaZ/A")
            )
            .execute().response();

        System.out.println(response.statusCode());
        System.out.println(response.headers());
        System.out.println(new String(response.body()));

        return false;
    }


}
