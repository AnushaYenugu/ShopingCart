package lexicon.jdbc.dao;

import lexicon.jdbc.db.MySQLConnection;
import lexicon.jdbc.model.ShoppingCart;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShoppingCartDAOImplementation implements ShoppingCartDAO{
    @Override
    public ShoppingCart save(ShoppingCart cart) {
           String saveCartQuery="insert into shopping_cart values(?,?,?,?,?) ";
        try{
            Connection connection= MySQLConnection.myConnection();
            PreparedStatement statement=connection.prepareStatement(saveCartQuery);
            statement.setInt(1,cart.getId());
            statement.setTimestamp(2, Timestamp.valueOf(cart.getLastUpdate()));
            statement.setString(3,cart.getOrderStatus());
            statement.setString(4,cart.getDeliveryAddress());
            statement.setString(5,cart.getCustomerReference());

            int i=statement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();

        }
        return cart;
    }

    @Override
    public Optional<ShoppingCart> findById(int id) {
        Optional<ShoppingCart> findByIdResult=Optional.empty();
        String findByIdQuery="select * from shopping_cart where id= ?";
        ShoppingCart shoppingCart=new ShoppingCart();
        try{
            Connection connection=MySQLConnection.myConnection();
            PreparedStatement statement=connection.prepareStatement(findByIdQuery);
            statement.setInt(1,id);
            ResultSet resultSet=statement.executeQuery();

            while(resultSet.next()){

                findByIdResult=Optional.of(new ShoppingCart(resultSet.getInt(1),
                        resultSet.getTimestamp(2).toLocalDateTime(),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getBoolean(6)
                        ));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return findByIdResult;
    }

    @Override
    public List<ShoppingCart> findAll() {
        List<ShoppingCart> findAllList=new ArrayList<>();
        String findAllQuery="select * from shopping_cart";
        try{
            Connection connection=MySQLConnection.myConnection();
            PreparedStatement statement=connection.prepareStatement(findAllQuery);
            ResultSet resultSet=statement.executeQuery();

            while(resultSet.next()){
                findAllList.add(new ShoppingCart(resultSet.getInt(1),
                        resultSet.getTimestamp(2).toLocalDateTime(),
                       resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getBoolean(6)));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return findAllList;
    }

    @Override
    public List<ShoppingCart> findByOrderStatus(String status) {
        List<ShoppingCart> findByOrderList=new ArrayList<>();
        String findByOrderQuery="select * from shopping_cart where order_status=?";
        try{
            Connection connection=MySQLConnection.myConnection();
            PreparedStatement statement=connection.prepareStatement(findByOrderQuery);
            statement.setString(1,status);
            ResultSet resultSet=statement.executeQuery();

            while(resultSet.next()){
                findByOrderList.add(new ShoppingCart(resultSet.getInt(1),
                        resultSet.getTimestamp(2).toLocalDateTime(),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getBoolean(6)));
            }

        }catch (SQLException e){
                e.printStackTrace();
        }

        return findByOrderList;
    }

    @Override
    public List<ShoppingCart> findByReference(String customer) {
        List<ShoppingCart> findByReferenceList=new ArrayList<>();
        String findByReferenceQuery="select * from shopping_cart where customer_reference=? ";
        try {
            Connection connection=MySQLConnection.myConnection();
            PreparedStatement statement=connection.prepareStatement(findByReferenceQuery);
            statement.setString(1,customer);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                findByReferenceList.add(new ShoppingCart(resultSet.getInt(1),
                        resultSet.getTimestamp(2).toLocalDateTime(),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getBoolean(6)));

            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return findByReferenceList;
    }

    @Override
    public void delete(int id) {
        String deleteQuery="delete from shopping_cart where id=?";
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
