package com.personalblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personalblog.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
