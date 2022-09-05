package lexicon.jdbc;

import lexicon.jdbc.dao.ProductDAOImplementation;
import lexicon.jdbc.dao.ShoppingCartDAO;
import lexicon.jdbc.dao.ShoppingCartDAOImplementation;
import lexicon.jdbc.dao.ShoppingCartItemDAOImplementation;
import lexicon.jdbc.model.Product;
import lexicon.jdbc.model.ShoppingCart;
import lexicon.jdbc.model.ShoppingCartItem;

import java.time.LocalDateTime;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Product vaccumCleaner=new Product(4,"Robot Vaccum Cleaner",4000);
        ProductDAOImplementation productDAOImplementation=new ProductDAOImplementation();
        Product mac=new Product(1,"Mac laptop",12000);
        Product washingMachine=new Product(3,"Washing Machine",20000);
        //System.out.println(macInsert.save(vaccumCleaner));
        System.out.println(productDAOImplementation.findById(1).isPresent());
        productDAOImplementation.findAll().forEach(System.out::println);
        productDAOImplementation.findByName("Iphone").forEach(System.out::println);
        productDAOImplementation.findByPriceBetween(4000,12000).forEach(System.out::println);
        Product dummy=new Product(5,"Chineese product",200);
        productDAOImplementation.save(dummy);
        System.out.println("Before Delete");
        productDAOImplementation.findAll().forEach(System.out::println);
        productDAOImplementation.delete(5);
        System.out.println("After Delete");
        productDAOImplementation.findAll().forEach(System.out::println);

        System.out.println("Shoping cart");
        ShoppingCartDAOImplementation shoppingCartDAOImplementation=new ShoppingCartDAOImplementation();
       ShoppingCart washingMaching=new ShoppingCart(1, LocalDateTime.now(),"Added into wish List","Hagstensgatan 3A","Anusha",true);
       // ShoppingCartDAOImplementation shoppingCartDAOImplementation=new ShoppingCartDAOImplementation();
        //shoppingCartDAOImplementation.save(washingMaching);

        ShoppingCart headPhone=new ShoppingCart(2,LocalDateTime.now(),"Added into cart","Huskvarna","Sony",true);
      //  shoppingCartDAOImplementation.save(headPhone);

        ShoppingCart unicorn=new ShoppingCart(3,LocalDateTime.now(),"ordered","Jönköping","Unicorn frock",true);
       // shoppingCartDAOImplementation.save(unicorn);
        System.out.println(shoppingCartDAOImplementation.findById(1).isPresent());

        shoppingCartDAOImplementation.findAll().forEach(System.out::println);

        System.out.println(shoppingCartDAOImplementation.findByOrderStatus("Added into wish List"));
        shoppingCartDAOImplementation.findByReference("Unicorn frock").forEach(System.out::println);
        System.out.println("Before deletion:::::::::::::");
        shoppingCartDAOImplementation.findAll().forEach(System.out::println);
        shoppingCartDAOImplementation.delete(2);
        System.out.println("After deletion:::::::::::::::");
        shoppingCartDAOImplementation.findAll().forEach(System.out::println);

        ShoppingCartItem shoppingCartItem=new ShoppingCartItem(1,1000,10000,vaccumCleaner.getId(),washingMaching.getId());
        ShoppingCartItem shoppingCartItem1=new ShoppingCartItem(2,2000,12000,mac.getId(),washingMaching.getId());
        ShoppingCartItemDAOImplementation shoppingCartItemDAOImplementation=new ShoppingCartItemDAOImplementation();
     //   shoppingCartItemDAOImplementation.save(shoppingCartItem);
       // shoppingCartItemDAOImplementation.save(shoppingCartItem1);

        System.out.println("Shopping cart Item--------------------------");
        System.out.println(shoppingCartItemDAOImplementation.findById(1));


        shoppingCartItemDAOImplementation.findAll().forEach(System.out::println);
     //   System.out.println(shoppingCartItemDAOImplementation);
        System.out.println(shoppingCartItemDAOImplementation.findByCartId(1));
        System.out.println(shoppingCartItemDAOImplementation.findByProductId(1));
        ShoppingCartItem shoppingCartItem3=new ShoppingCartItem(3,0,0,mac.getId(), washingMaching.getId());
        ShoppingCartItem shoppingCartItem4=new ShoppingCartItem(4,1,1,mac.getId(),unicorn.getId());
        ShoppingCartItem shoppingCartItem5=new ShoppingCartItem(5,2,2,mac.getId(),headPhone.getId());
     //   System.out.println(shoppingCartItemDAOImplementation.save(shoppingCartItem3));
       // System.out.println(shoppingCartItemDAOImplementation.save(shoppingCartItem4));
      //  System.out.println(shoppingCartItemDAOImplementation.save(shoppingCartItem5));
        System.out.println("Before deletion______________________________");
        shoppingCartItemDAOImplementation.findAll().forEach(System.out::println);
       System.out.println("After deleteion_____________________");
        shoppingCartItemDAOImplementation.delete(3);
        shoppingCartItemDAOImplementation.findAll().forEach(System.out::println);

    }
}
