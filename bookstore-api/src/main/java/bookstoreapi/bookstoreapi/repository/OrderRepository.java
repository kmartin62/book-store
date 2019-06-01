package bookstoreapi.bookstoreapi.repository;

import bookstoreapi.bookstoreapi.model.Order;
import bookstoreapi.bookstoreapi.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by @kmartin62
 */
public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByUser(User user);
}
