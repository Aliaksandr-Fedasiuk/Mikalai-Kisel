package org.shop;


import org.shop.api.ProductService;
import org.shop.api.UserService;
import org.shop.data.Product;
import org.shop.data.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * The ShopLauncher class.
 */
public class ShopLauncher {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/org/shop/spring/main-context.xml");

        UserService userService = applicationContext.getBean(UserService.class);
        List<User> users = userService.getUsers();

        for (User user : users) {
            System.out.println(user);
        }

        ProductService productService = (ProductService) applicationContext.getBean("productServiceImpl");
        List<Product> products = productService.getProducts();

        for (Product product : products) {
            System.out.println(product);
        }
    }
}
