package bookstoreapi.bookstoreapi.service;

import bookstoreapi.bookstoreapi.model.UserShipping;

import java.util.Optional;

/**
 * Created by @kmartin62
 */
public interface UserShippingService {
    Optional<UserShipping> findById(Long id);

    void removeById(Long id);
}
