package com.ufabc.ufabcsnack.model.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufabc.ufabcsnack.model.entity.Store;

@Repository
public interface StoreDAO extends JpaRepository<Store, Long>{

}
