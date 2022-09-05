package lexicon.jdbc.dao;

import lexicon.jdbc.model.Product;
import lexicon.jdbc.model.ShoppingCart;
import lexicon.jdbc.model.ShoppingCartItem;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartItemDAO {
    ShoppingCartItem save(ShoppingCartItem cartItem);
    Optional<ShoppingCartItem> findById(int id);
    List<ShoppingCartItem> findAll();
    List<ShoppingCartItem> findByCartId(int cartId);
    List<ShoppingCartItem> findByProductId(int productId);
    void delete(int id);

}
