package com.aditya.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aditya.entity.Product;
import com.aditya.repo.ProductRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ProductLogic {
    
    @Autowired
    private ProductRepo productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    
    public Product updateProduct(Long id, Product updatedProduct) {
        // Check if the product exists
        Optional<Product> existingProductOptional = productRepository.findById(id);
        if (existingProductOptional.isPresent()) {
        	
        	
        
            Product existingProduct = existingProductOptional.get();

           
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
           
            return productRepository.save(existingProduct);
        } else {
            
            return null; 
        }
    
    
   
    }

}

	

	
	
	


