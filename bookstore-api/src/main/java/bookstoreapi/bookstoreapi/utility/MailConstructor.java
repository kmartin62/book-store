package bookstoreapi.bookstoreapi.utility;

import bookstoreapi.bookstoreapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

/**
 * Created by @kmartin62
 */
@Component
public class MailConstructor {

    @Autowired
    private Environment env;

    public SimpleMailMessage constructEmail(User user, String password) {
        String message = "Login with username " + user.getUsername() + " and password " + password;

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(user.getEmail());
        email.setSubject("Password and username");
        email.setText(message);
        email.setFrom(env.getProperty("support.email"));

        return email;
    }
}
