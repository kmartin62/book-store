package bookstoreapi.bookstoreapi.controller;

import bookstoreapi.bookstoreapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/**
 * Created by @kmartin62
 */
@CrossOrigin({"*"})
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

    @RequestMapping("/checkSession")
    public ResponseEntity checkSession(){
        return new ResponseEntity("Session Active!", HttpStatus.OK);
    }

    @RequestMapping(value = "/logoff", method = RequestMethod.POST)
    public ResponseEntity logout(){
        SecurityContextHolder.clearContext();
        return new ResponseEntity("Logout successful!", HttpStatus.OK);
    }

}
