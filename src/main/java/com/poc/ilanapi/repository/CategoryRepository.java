package com.poc.ilanapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.ilanapi.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
