package com.vasanth.ecommerce_backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class ProductModel {

    @Id
    private String productId;

    private String name;
    private String brand;
    private String description;
    private String imageUrl;
    private double rating;
    private double price;
}



