package com.example.mcdse105.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.mcdse105.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE lower(p.name) LIKE lower(concat('%', :name, '%'))")
    public List<Product> findByNameContainingIgnoreCase(String name);

}
