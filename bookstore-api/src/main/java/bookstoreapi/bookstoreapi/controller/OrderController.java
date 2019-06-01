package bookstoreapi.bookstoreapi.controller;

import bookstoreapi.bookstoreapi.model.Order;
import bookstoreapi.bookstoreapi.model.User;
import bookstoreapi.bookstoreapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

/**
 * Created by @kmartin62
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getOrderList")
    public List<Order> getOrderList(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        List<Order> orderList = user.getOrderList();

        return orderList;
    }
}
