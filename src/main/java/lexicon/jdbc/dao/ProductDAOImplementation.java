package lexicon.jdbc.dao;

import lexicon.jdbc.db.MySQLConnection;
import lexicon.jdbc.model.Product;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDAOImplementation implements  ProductDAO{

    @Override
    public Product save(Product product) {
        String insertQuery="insert into product values(?,?,?)";
        try{
            Connection connection=MySQLConnection.myConnection();
            PreparedStatement statement=connection.prepareStatement(insertQuery);
            statement.setInt(1,product.getId());
            statement.setString(2,product.getName());
            statement.setBigDecimal(3,new BigDecimal(product.getPrice()));
            int i=statement.executeUpdate();
          //  System.out.println(i);


        }catch(SQLException e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Optional<Product> findById(int id) {
        Optional<Product> byId=Optional.empty();
        String findIdByQuery="select * from product where id=?";
        Product product=new Product();
        try{
            Connection connection=MySQLConnection.myConnection();
            PreparedStatement statement= connection.prepareStatement(findIdByQuery);
            statement.setInt(1,id);
            ResultSet resultSet=statement.executeQuery();

            while(resultSet.next()){
                byId=Optional.of(new Product(resultSet.getInt(1),
                                 resultSet.getString(2),
                                 resultSet.getDouble(3)));

            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return byId;
    }

    @Override
    public List<Product> findAll() {
        List<Product> findAllResult=new ArrayList<>();
        Product product=new Product();
        String findAllQuery="select * from product";
        try{
            Connection connection=MySQLConnection.myConnection();
            PreparedStatement statement=connection.prepareStatement(findAllQuery);
            ResultSet resultSet=statement.executeQuery();

            while(resultSet.next()){
                findAllResult.add(new Product(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3)
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return findAllResult;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> findByNameResult=new ArrayList<>();
        Product product=new Product();
        String findByNameQuery="select * from product where name=?";
        try{
            Connection connection=MySQLConnection.myConnection();
            PreparedStatement statement=connection.prepareStatement(findByNameQuery);
            statement.setString(1,name);
            ResultSet resultSet=statement.executeQuery();

            while(resultSet.next()){
                findByNameResult.add(new Product(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3)));

            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return findByNameResult;
    }

    @Override
    public List<Product> findByPriceBetween(double low, double high) {
        List<Product> findByPriceResult=new ArrayList<>();
        Product product=new Product();
        String findByPriceQuery="select * from product where price >= ? and price<=?";
        try{
            Connection connection=MySQLConnection.myConnection();
            PreparedStatement statement=connection.prepareStatement(findByPriceQuery);
            statement.setDouble(1,low);
            statement.setDouble(2,high);
            ResultSet resultSet=statement.executeQuery();

            while(resultSet.next()){
                findByPriceResult.add(new Product(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3)));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return findByPriceResult;
    }

    @Override
    public void delete(int id) {
        String deleteQuery="delete from product where id=?";
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
