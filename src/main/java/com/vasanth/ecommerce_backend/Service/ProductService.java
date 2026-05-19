package com.vasanth.ecommerce_backend.Service;

import com.vasanth.ecommerce_backend.Dal.ProductRepository;
import com.vasanth.ecommerce_backend.Model.ProductModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final  ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public ProductModel addProduct(ProductModel product) {
        productRepository.save(product);
        return product;
    }

    public ProductModel getProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public void deleteProductById(String id) {
        ProductModel product = productRepository.findById(id).orElse(null);
        if (product != null) {
            productRepository.deleteById(id);
        }
    }

    public ProductModel putProductById(String id, ProductModel productModel) {
        ProductModel existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        existingProduct.setName(productModel.getName());
        existingProduct.setBrand(productModel.getBrand());
        existingProduct.setDescription(productModel.getDescription());
        existingProduct.setImageUrl(productModel.getImageUrl());
        existingProduct.setRating(productModel.getRating());
        existingProduct.setPrice(productModel.getPrice());

        return productRepository.save(existingProduct);
    }

    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }




}
