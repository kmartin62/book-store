package bookstoreapi.bookstoreapi.service;

import bookstoreapi.bookstoreapi.model.UserPayment;

import java.util.Optional;

/**
 * Created by @kmartin62
 */
public interface UserPaymentService {
    Optional<UserPayment> findById(Long id);

    void removeById(Long id);
}
