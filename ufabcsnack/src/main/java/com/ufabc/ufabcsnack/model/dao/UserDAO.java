package com.ufabc.ufabcsnack.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ufabc.ufabcsnack.model.entity.SnackUser;

@Repository
public interface UserDAO extends JpaRepository<SnackUser, Long>{

}
