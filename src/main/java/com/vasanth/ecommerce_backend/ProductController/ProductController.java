package com.vasanth.ecommerce_backend.ProductController;

import com.vasanth.ecommerce_backend.Model.ProductModel;
import com.vasanth.ecommerce_backend.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }



    @PostMapping("/post")
    public ResponseEntity<ProductModel> addProduct(@RequestBody ProductModel productModel) {
        return new ResponseEntity<>(productService.addProduct(productModel), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        try {
            productService.deleteProductById(id);
            return ResponseEntity.ok("Deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Product not found");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> getProductById(@PathVariable String id) {
        ProductModel productModel = productService.getProductById(id);
        return ResponseEntity.ok(productModel);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProductModel> updateProduct(
            @PathVariable String id,
            @RequestBody ProductModel productModel) {

        ProductModel updatedProduct = productService.putProductById(id, productModel);
        return ResponseEntity.ok(updatedProduct);
    }

    @GetMapping
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }








}
