package com.example.product_manager.services;

import com.example.product_manager.models.Product;
import com.example.product_manager.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    @Autowired
    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getAll(){
        return repo.findAll();
    }

    public void saveProduct(Product product){
        repo.save(product);
    }

    public Product getId(Long id){
        return repo.getById(id);
    }

    public void deleteById(Long id){
        repo.deleteById(id);
    }
}
