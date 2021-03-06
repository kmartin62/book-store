package bookstoreapi.bookstoreapi.controller;

import bookstoreapi.bookstoreapi.model.Book;
import bookstoreapi.bookstoreapi.model.CartItem;
import bookstoreapi.bookstoreapi.model.ShoppingCart;
import bookstoreapi.bookstoreapi.model.User;
import bookstoreapi.bookstoreapi.service.BookService;
import bookstoreapi.bookstoreapi.service.CartItemService;
import bookstoreapi.bookstoreapi.service.ShoppingCartService;
import bookstoreapi.bookstoreapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Created by @kmartin62
 */
@RestController
@RequestMapping("/cart")
public class ShoppingCartController {
    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping("/add")
    public ResponseEntity addItem (
            @RequestBody HashMap<String, String> mapper, Principal principal
    ){
        String bookId = (String) mapper.get("bookId");
        String qty = (String) mapper.get("qty");

        User user = userService.findByUsername(principal.getName());
        Optional<Book> book = bookService.findById(Long.parseLong(bookId));

        if(Integer.parseInt(qty) > book.get().getInStockNumber()) {
            return new ResponseEntity("Not Enough Stock!", HttpStatus.BAD_REQUEST);
        }

        CartItem cartItem = cartItemService.addBookToCartItem(book.get(), user, Integer.parseInt(qty));

        return new ResponseEntity("Book Added Successfully!", HttpStatus.OK);
    }

    @RequestMapping("/getCartItemList")
    public List<CartItem> getCartItemList(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        ShoppingCart shoppingCart = user.getShoppingCart();

        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

        shoppingCartService.updateShoppingCart(shoppingCart);

        return cartItemList;
    }

    @RequestMapping("/getShoppingCart")
    public ShoppingCart getShoppingCart(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        ShoppingCart shoppingCart = user.getShoppingCart();

        shoppingCartService.updateShoppingCart(shoppingCart);

        return shoppingCart;
    }

    @RequestMapping("/removeItem")
    public ResponseEntity removeItem(@RequestBody String id) {
        cartItemService.removeCartItem(cartItemService.findById(Long.parseLong(id)).get());

        return new ResponseEntity("Cart Item Removed Successfully!", HttpStatus.OK);
    }

    @RequestMapping("/updateCartItem")
    public ResponseEntity updateCartItem(
            @RequestBody HashMap<String, String> mapper
    ){
        String cartItemId = mapper.get("cartItemId");
        String qty = mapper.get("qty");

        Optional<CartItem> cartItem = cartItemService.findById(Long.parseLong(cartItemId));
        cartItem.get().setQty(Integer.parseInt(qty));

        cartItemService.updateCartItem(cartItem.get());

        return new ResponseEntity("Cart Item Updated Successfully!", HttpStatus.OK);
    }

}