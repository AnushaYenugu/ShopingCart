package lexicon.jdbc.dao;

import lexicon.jdbc.db.MySQLConnection;
import lexicon.jdbc.model.Product;
import lexicon.jdbc.model.ShoppingCartItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShoppingCartItemDAOImplementation implements ShoppingCartItemDAO{
    @Override
    public ShoppingCartItem save(ShoppingCartItem cartItem) {
        String saveQuery="insert into shopping_cart_item (id,amount,total_price,product_id,shopping_cart_id) values(?,?,?,?,?)";
        ShoppingCartItem shoppingCartItem=new ShoppingCartItem();
        try{
            Connection connection= MySQLConnection.myConnection();
            PreparedStatement statement=connection.prepareStatement(saveQuery);
            statement.setInt(1,cartItem.getId());
            statement.setInt(2,cartItem.getAmount());
            statement.setDouble(3,cartItem.getTotalPrice());
            statement.setInt(4,cartItem.getProductId());
            statement.setInt(5,cartItem.getShoppingCartId());
            int i=statement.executeUpdate();

        }catch (SQLException e){
                e.printStackTrace();
        }
        return shoppingCartItem;
    }

    @Override
    public Optional<ShoppingCartItem> findById(int id) {
        Optional<ShoppingCartItem> findByIdOptional=Optional.empty();
        String findByIdQuery="select * from shopping_cart_item where id=?";
        try{
            Connection connection=MySQLConnection.myConnection();
            PreparedStatement statement=connection.prepareStatement(findByIdQuery);
            statement.setInt(1, id);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                findByIdOptional=Optional.of(new ShoppingCartItem(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getDouble(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5)
                          ));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return findByIdOptional;
    }

    @Override
    public List<ShoppingCartItem> findAll() {
        List<ShoppingCartItem> findAllList=new ArrayList<>();
        String findAllQuery="select * from shopping_cart_item";
        try{
            Connection connection=MySQLConnection.myConnection();
            PreparedStatement statement=connection.prepareStatement(findAllQuery);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                findAllList.add(new ShoppingCartItem(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getDouble(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return findAllList;
    }

    @Override
    public List<ShoppingCartItem> findByCartId(int cartId) {
        List<ShoppingCartItem> findByCartIdList=new ArrayList<>();
        String findByCartIdQuery="select * from shopping_cart_item where shopping_cart_id=?";
        try{

            Connection connection=MySQLConnection.myConnection();
            PreparedStatement statement=connection.prepareStatement(findByCartIdQuery);
            statement.setInt(1,cartId);
            ResultSet resultSet=statement.executeQuery();

            while(resultSet.next()){
                findByCartIdList.add(new ShoppingCartItem(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getDouble(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5)));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return findByCartIdList;
    }

    @Override
    public List<ShoppingCartItem> findByProductId(int productId) {
        List<ShoppingCartItem> findByProductIdList=new ArrayList<>();
        String findByProductIdQuery="select * from shopping_cart_item where product_id=? ";
        try{
            Connection connection=MySQLConnection.myConnection();
            PreparedStatement statement=connection.prepareStatement(findByProductIdQuery);
            statement.setInt(1,productId);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                findByProductIdList.add(new ShoppingCartItem(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getDouble(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5)));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return findByProductIdList;
    }

    @Override
    public void delete(int id) {
        String deleteQuery="delete from shopping_cart_item where id=?";
        try{

            Connection connection=MySQLConnection.myConnection();
            PreparedStatement statement=connection.prepareStatement(deleteQuery);
            statement.setInt(1,id);
            int i=statement.executeUpdate();

        }catch (SQLException e){
                e.printStackTrace();
        }

    }
}
