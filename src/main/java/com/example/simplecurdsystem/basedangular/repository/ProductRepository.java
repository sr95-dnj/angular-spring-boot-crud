package com.example.simplecurdsystem.basedangular.repository;

import com.example.simplecurdsystem.basedangular.domain.EmployeeInformation;
import com.example.simplecurdsystem.basedangular.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {

    Optional<Product> findAllById(String id);
}
