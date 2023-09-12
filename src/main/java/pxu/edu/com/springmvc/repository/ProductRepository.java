package pxu.edu.com.springmvc.repository;

import org.springframework.stereotype.Repository;

import pxu.edu.com.springmvc.models.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> list = new ArrayList<Product>(Arrays.asList(
            new Product(1, "IPhone 14 promax", 5000000),
            new Product(2, "IPhone xs", 1610000),
            new Product(3, "oppo neo 7", 2000000),
            new Product(4, "samsung  22 utra", 1900000)
    ));

    public List<Product> getAll() {
        return list;
    }

    public Product getById(int id) {
        Product product = new Product();
        for (Product p : list) {
            if (p.getId() == id) {
                product = p;
                break;
            }
        }
        return product;
    }

    public void update(Product input) {
        Product product = getById(input.getId());
        int index = list.indexOf(product);
        list.set(index, input);
    }

    public void insert(Product input) {
        list.add(input);
    }

    public void delete(int id) {
        Product product = getById(id);
        list.remove(product);
    }
}
