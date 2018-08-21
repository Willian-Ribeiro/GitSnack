package com.ufabc.ufabcsnack.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufabc.ufabcsnack.model.entity.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long>{

}
