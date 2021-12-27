package com.example.simplecurdsystem.basedangular.repository;

import com.example.simplecurdsystem.basedangular.domain.EmployeeInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeInformation,String> {

    Optional<EmployeeInformation> findAllById(String id);
}
