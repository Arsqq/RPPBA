package com.example.rppbaproject.Repo;


import com.example.rppbaproject.Domain.Raw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RawRepo extends JpaRepository<Raw, Long> {
    Raw findById(Integer id);
    Raw deleteById(Integer id);
}
