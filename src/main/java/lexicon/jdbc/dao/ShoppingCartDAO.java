package lexicon.jdbc.dao;

import lexicon.jdbc.model.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartDAO {
    ShoppingCart save(ShoppingCart cart);
    Optional<ShoppingCart> findById(int id);
    List<ShoppingCart> findAll();
    List<ShoppingCart> findByOrderStatus(String status);
    List<ShoppingCart> findByReference(String customer);
    void delete(int id);
}
