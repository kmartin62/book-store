package bookstoreapi.bookstoreapi.controller;

import bookstoreapi.bookstoreapi.model.User;
import bookstoreapi.bookstoreapi.model.UserShipping;
import bookstoreapi.bookstoreapi.service.UserService;
import bookstoreapi.bookstoreapi.service.UserShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

/**
 * Created by @kmartin62
 */
@RestController
@RequestMapping("/shipping")
public class ShippingController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserShippingService userShippingService;

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public ResponseEntity addNewUserShippingPost(
            @RequestBody UserShipping userShipping, Principal principal
    ) {
        User user = userService.findByUsername(principal.getName());
        userService.updateUserShipping(userShipping, user);

        return new ResponseEntity("Shipping Added(Updated) Successfully!", HttpStatus.OK);
    }

    @RequestMapping("/getUserShippingList")
    public List<UserShipping> getUserShippingList(
            Principal principal
    ){
        User user = userService.findByUsername(principal.getName());
        List<UserShipping> userShippingList = user.getUserShippingList();

        return userShippingList;
    }

    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public ResponseEntity removeUserShippingPost(
            @RequestBody String id,
            Principal principal
    ) {
        userShippingService.removeById(Long.parseLong(id));
        return new ResponseEntity("Shipping Removed Successfully!", HttpStatus.OK);
    }

    @RequestMapping(value="/setDefault", method=RequestMethod.POST)
    public ResponseEntity setDefaultUserShippingPost(
            @RequestBody String id, Principal principal
    ){
        User user = userService.findByUsername(principal.getName());
        userService.setUserDefaultShipping(Long.parseLong(id), user);

        return new ResponseEntity("Set Default Shipping Successfully!", HttpStatus.OK);
    }
}
