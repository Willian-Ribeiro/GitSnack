package com.ufabc.ufabcsnack.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ufabc.ufabcsnack.model.entity.Seller;

@Repository
public interface SellerDAO extends JpaRepository<Seller, Long>{

	//****************Queries de Consulta*********************
/*
	// Recupera todos os Vendedores ativos no momento
	@Query ("Select S.Seller from Seller S Where S.Active = 1");
	public List<Seller> ListAllActive();

	// Recupera os produtos da Loja de um determinado Vendedor
	@Query ("Select S.ProductPrice, S.ProductQty, P.ID, P.StoreID, P.ProductName, P.ProductDesc from Store S Join Product P On S.ID = P.StoreID Where S.SellerID = (%:ID%) ");
	public List<FullProduct> ListFullStore(@Param("ID") String ID );

	// Recupera Todos os produtos vendidos no momento
	@Query ("Select S.ProductPrice, S.ProductQty, P.ID, P.StoreID, P.ProductName, P.ProductDesc from Store S Join Product P On S.ID = P.StoreID Where S.SellerID = %% ");
	public List<FullProduct> ListAllProducts();
*/
	//****************Queries de Inserção*********************

}
