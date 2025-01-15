package com.example.product.service.controller;
import com.example.product.service.model.BookModel;
import com.example.product.service.repository.productRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class bookController {

    private final productRepository productRepository;

    public bookController(productRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/getAll")
    public List<BookModel> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/add")
    public BookModel addProduct(@RequestBody BookModel product) {
        return productRepository.save(product);
    }

    @GetMapping("/{id}")
    public BookModel getProductById(@PathVariable Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }
    // ProductController (Product Service - Modified)
    @GetMapping("/{id}/check-availability")
    public boolean checkProductAvailability(@PathVariable Long id, @RequestParam int quantity) {
        BookModel product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return product.getQuantity() >= quantity;
    }
}
