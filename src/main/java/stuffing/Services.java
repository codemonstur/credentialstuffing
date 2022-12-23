package stuffing;

import stuffing.services.*;

import java.io.IOException;
import java.util.List;

public enum Services {;

    public interface Service {
        boolean login(String username, String password) throws IOException;
    }

    public static List<Service> services() {
        return List.of(Amazon::login, Dropbox::login, Facebook::login, GitHub::login, Instagram::login,
            LinkedIn::login, Pinterest::login, Reddit::login, TikTok::login, Twitter::login, YouTube::login);
    }

}
