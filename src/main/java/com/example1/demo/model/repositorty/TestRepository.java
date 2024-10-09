package com.example1.demo.model.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example1.demo.model.domain.TestDB;

@Repository
public interface TestRepository extends JpaRepository<TestDB, Long> {
    // Find all TestDB entities by a name
        static TestDB findByName(String name) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'findByName'");
        }
}