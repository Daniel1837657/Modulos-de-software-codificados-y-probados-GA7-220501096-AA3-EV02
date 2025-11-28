package com.inventory.app.service;

import com.inventory.app.model.Product;
import java.util.List;

public interface ProductService {

    Product save(Product product);

    Product update(Long id, Product product);

    List<Product> list();

    Product find(Long id);

    void delete(Long id);

    Product adjustStock(Long id, int quantity);
}
