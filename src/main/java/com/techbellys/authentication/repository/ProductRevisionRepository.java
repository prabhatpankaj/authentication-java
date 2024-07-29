package com.techbellys.authentication.repository;

import com.techbellys.authentication.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface ProductRevisionRepository extends JpaRepository<Product, Integer> , RevisionRepository<Product, Integer, Integer> {
}
