package bookstoreapi.bookstoreapi.controller;

import bookstoreapi.bookstoreapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/**
 * Created by @kmartin62
 */
@RestController
public class LoginController {

    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/token")
    public Map<String, String> token(HttpSession session, HttpServletRequest httpServletRequest) {
        System.out.println(httpServletRequest.getRemoteHost());

        String remoteHost = httpServletRequest.getRemoteHost();
        int portNumber = httpServletRequest.getRemotePort();

        System.out.println(remoteHost + ":" + portNumber);
        System.out.println(httpServletRequest.getRemoteAddr());

        return Collections.singletonMap("token", session.getId());
    }
}
