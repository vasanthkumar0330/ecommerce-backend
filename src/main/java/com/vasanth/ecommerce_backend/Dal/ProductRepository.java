package com.vasanth.ecommerce_backend.Dal;

import com.vasanth.ecommerce_backend.Model.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<ProductModel, String> {










}
