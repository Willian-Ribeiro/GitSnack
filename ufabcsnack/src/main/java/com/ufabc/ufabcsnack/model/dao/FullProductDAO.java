package com.ufabc.ufabcsnack.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufabc.ufabcsnack.model.entity.FullProduct;

@Repository
public interface FullProductDAO extends JpaRepository<FullProduct, Long>{

}
