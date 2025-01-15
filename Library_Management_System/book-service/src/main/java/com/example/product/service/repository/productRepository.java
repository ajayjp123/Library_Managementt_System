package com.example.product.service.repository;
import com.example.product.service.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<BookModel, Long> {
}