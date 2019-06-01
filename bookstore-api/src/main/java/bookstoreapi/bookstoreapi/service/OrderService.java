package bookstoreapi.bookstoreapi.service;

import bookstoreapi.bookstoreapi.model.*;

/**
 * Created by @kmartin62
 */
public interface OrderService {

    Order createOrder(
            ShoppingCart shoppingCart,
            ShippingAddress shippingAddress,
            BillingAddress billingAddress,
            Payment payment,
            String shippingMethod,
            User user
    );
}
