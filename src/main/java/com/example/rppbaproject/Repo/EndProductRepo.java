package com.example.rppbaproject.Repo;


import com.example.rppbaproject.Domain.EndProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EndProductRepo extends JpaRepository<EndProduct, Long> {

}
