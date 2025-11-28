package com.inventory.app.service.impl;

import com.inventory.app.model.Product;
import com.inventory.app.repository.ProductRepository;
import com.inventory.app.service.ProductService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public Product save(Product product) {
        return repo.save(product);
    }

    @Override
    public Product update(Long id, Product newData) {
        return repo.findById(id).map(p -> {
            p.setName(newData.getName());
            p.setStock(newData.getStock());
            p.setMinStock(newData.getMinStock());
            p.setCost(newData.getCost());
            p.setSalePrice(newData.getSalePrice());
            return repo.save(p);
        }).orElse(null);
    }

    @Override
    public List<Product> list() {
        return repo.findAll();
    }

    @Override
    public Product find(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Product adjustStock(Long id, int quantity) {
        return repo.findById(id).map(product -> {
            int newStock = product.getStock() + quantity;

            if (newStock < 0)
                throw new IllegalArgumentException("Stock insuficiente");

            product.setStock(newStock);
            return repo.save(product);
        }).orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
    }
}
