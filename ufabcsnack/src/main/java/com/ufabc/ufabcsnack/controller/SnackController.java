package com.ufabc.ufabcsnack.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ufabc.ufabcsnack.model.dao.FullProductDAO;
import com.ufabc.ufabcsnack.model.dao.ProductDAO;
import com.ufabc.ufabcsnack.model.dao.SellerDAO;
import com.ufabc.ufabcsnack.model.dao.StoreDAO;
import com.ufabc.ufabcsnack.model.dao.UserDAO;
import com.ufabc.ufabcsnack.model.entity.FullProduct;
import com.ufabc.ufabcsnack.model.entity.Product;
import com.ufabc.ufabcsnack.model.entity.Seller;
import com.ufabc.ufabcsnack.model.entity.SnackUser;
import com.ufabc.ufabcsnack.model.entity.Store;

@Controller
public class SnackController {


	// instanciacao dos 5 DAOs
	@Autowired
	SellerDAO sellerDAO;

	@Autowired
	UserDAO userDAO;

	@Autowired
	FullProductDAO fullproductDAO;

	@Autowired
	ProductDAO productDAO;

	@Autowired
	StoreDAO storeDAO;




	// redireciona para a pagina de cadastro
	@RequestMapping(value = {"", "/index"})
	public ModelAndView execute() {
		return new ModelAndView("index");
	}



	// metodos para user

	// redireciona para a pagina de cadastro de user
	@RequestMapping("/cadastro_SnackUser")
	public ModelAndView cadastroSnackUser()
	{
		return new ModelAndView("cadastroSnackUser");
	}


	// abre pagina comtodos os usuarios e que podem ser editados
	@RequestMapping(value = {"/snackUser"})
	public ModelAndView snackUser() {

		ModelAndView mv = new ModelAndView("snackUser");

		mv.addObject("userList", userDAO.findAll());

		return mv;
	}

	// salvar user no bd
	@RequestMapping("/salvarUser")
	public ModelAndView salvarUser(@RequestParam("password") String password,
			@RequestParam("tipo") boolean tipo)
	{
		// coverto o tipo de boolean para int
		int tipoInt = tipo? 1 : 0; 
		SnackUser user = new SnackUser();
		user.setPassword(password);
		user.setTipo(tipoInt);
		userDAO.save(user);

		ModelAndView mv = new ModelAndView("confirmacao");
		//mv.addObject("user", user);

		return mv;
	}

	// editar user no bd
	@RequestMapping("/editarUser")
	public ModelAndView editarUser(@RequestParam("id") long id, @RequestParam("password") String password,
			@RequestParam("tipo") String tipo)
	{
		// coverto o tipo de boolean para int
		SnackUser user = new SnackUser();
		user.setPassword(password);
		user.setTipo(Integer.parseInt(tipo));
		user.setID(id);
		userDAO.save(user);

		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

	// recebo id da conta e a removo do bd
	@RequestMapping("/remove_user/{id}")
	public ModelAndView removeUser(@PathVariable Long id)
	{
		// recupero a conta a se remover atraves do id
		//SnackUser temp = userDAO.getOne(id);

		ModelAndView mv = new ModelAndView("index");
		//mv.addObject("user", temp);

		userDAO.deleteById(id);
		return mv;
	} 

	/*// recebo os parametros digitados pelo usuario e os atualizo no BD
	@RequestMapping("/edit/{id}")
	public ModelAndView editar(@PathVariable Long id)
	{
		SnackUser temp = userDAO.getOne(id);

		ModelAndView mv = new ModelAndView("editar");
		mv.addObject("conta", temp);
		return mv;
	} */



	// ##############################################~|Product|~#####################################################




	// redireciona para a pagina de cadastro de product
	@RequestMapping("/cadastro_product")
	public ModelAndView cadastroProduct()
	{
		return new ModelAndView("cadastro_product");
	}


	// abre pagina de cadastro de produtos
	@RequestMapping(value = {"/product"})
	public ModelAndView findAllProducts() {

		ModelAndView mv = new ModelAndView("product");

		mv.addObject("productList", productDAO.findAll());
		return mv;
	}

	// retorna lista de produtos
	@RequestMapping(value = {"/productList"})
	public List<Product> productList() {
		// retorna lista de produtos
		return productDAO.findAll();
	}


	// salvar product no bd
	@RequestMapping("/salvarProduct")
	public ModelAndView salvaroProduct(@RequestParam("productName") String productName,
			@RequestParam("productDesc") String productDesc)
	{
		Product pdt = new Product();
		pdt.setProductName(productName);
		pdt.setProductDesc(productDesc);
		productDAO.save(pdt);

		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

	// editar product no bd
	@RequestMapping("/editarProduct")
	public ModelAndView editarProduct(@RequestParam("id") long id, @RequestParam("productName") String productName,
			@RequestParam("productDesc") String productDesc)
	{
		Product pdt = new Product();
		pdt.setProductName(productName);
		pdt.setProductDesc(productDesc);
		pdt.setID(id);
		productDAO.save(pdt);

		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

	// recebo id da conta e a removo do bd
	@RequestMapping("/remove_product/{id}")
	public ModelAndView removeProduct(@PathVariable Long id)
	{
		ModelAndView mv = new ModelAndView("index");
		productDAO.deleteById(id);
		return mv;
	} 


	// ##############################################~|FullProduct|~#####################################################


	// redireciona para a pagina de cadastro de product
	@RequestMapping("/cadastro_fullproduct")
	public ModelAndView cadastroFullProduct()
	{
		return new ModelAndView("cadastro_fullproduct");
	}


	// abre pagina de cadastro de produtos
	@RequestMapping(value = {"/fullproduct"})
	public ModelAndView findAllFullProducts() {

		ModelAndView mv = new ModelAndView("fullproduct");

		mv.addObject("fullproductList", fullproductDAO.findAll());
		return mv;
	}

	// retorna lista de produtos
	@RequestMapping(value = {"/fullproductList"})
	public List<FullProduct> fullProductList() {
		// retorna lista de produtos
		return fullproductDAO.findAll();
	}


	// salvar fullproduct no bd
	@RequestMapping("/salvarFullProduct")
	public ModelAndView salvarFullProduct(@RequestParam("productQty") int productQty,
			@RequestParam("productPrice") Float productPrice)
	{
		FullProduct fp = new FullProduct();
		fp.setProductPrice(productQty);
		fp.setProductPrice(productPrice);
		fullproductDAO.save(fp);

		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

	// editar fullproduct no bd
	@RequestMapping("/editarFullProduct")
	public ModelAndView editarFullProduct(@RequestParam("id") long id, @RequestParam("productPrice") int productQty,
			@RequestParam("productDesc") Float productPrice)
	{
		FullProduct fp = new FullProduct();
		fp.setProductPrice(productQty);
		fp.setProductPrice(productPrice);
		fp.setID(id);
		fullproductDAO.save(fp);

		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

	// recebo id da conta e a removo do bd
	@RequestMapping("/remove_fullproduct/{id}")
	public ModelAndView removeFullProduct(@PathVariable Long id)
	{
		ModelAndView mv = new ModelAndView("index");
		fullproductDAO.deleteById(id);
		return mv;
	} 

	// ##############################################~|Seller|~#####################################################

	// redireciona para a pagina de cadastro de product
	@RequestMapping("/cadastro_seller")
	public ModelAndView cadastroSeller()
	{
		return new ModelAndView("cadastro_seller");
	}


	// abre pagina de cadastro de produtos
	@RequestMapping(value = {"/seller"})
	public ModelAndView findAllSellers() {

		ModelAndView mv = new ModelAndView("seller");

		mv.addObject("sellerList", sellerDAO.findAll());
		return mv;
	}

	// retorna lista de produtos
	@RequestMapping(value = {"/sellerList"})
	public List<Seller> sellerList() {
		// retorna lista de produtos
		return sellerDAO.findAll();
	}

	// salvar seller no bd
	@RequestMapping("/salvarSeller")
	public ModelAndView salvarSeller(@RequestParam("sellerDesc") String sellerDesc,
			@RequestParam("sellerName") String sellerName, @RequestParam("positionX") float positionX,
			@RequestParam("positionY") float positionY, @RequestParam("status") int status)
	{
		Seller sel = new Seller();
		sel.setSellerDesc(sellerDesc);
		sel.setSellerName(sellerName);
		sel.setPositionX(positionX);
		sel.setPositionY(positionY);
		sel.setStatus(status);
		sellerDAO.save(sel);

		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

	// editar seller no bd
	@RequestMapping("/editarSeller")
	public ModelAndView editarSeller(@RequestParam("id") long id, @RequestParam("sellerDesc") String sellerDesc,
			@RequestParam("sellerName") String sellerName, @RequestParam("positionX") float positionX,
			@RequestParam("positionY") float positionY, @RequestParam("status") int status)
	{
		Seller sel = new Seller();
		sel.setID(id);
		sel.setSellerDesc(sellerDesc);
		sel.setSellerName(sellerName);
		sel.setPositionX(positionX);
		sel.setPositionY(positionY);
		sel.setStatus(status);
		sellerDAO.save(sel);

		return  new ModelAndView("index");
	}

	// recebo id da conta e a removo do bd
	@RequestMapping("/remove_seller/{id}")
	public ModelAndView removeSeller(@PathVariable Long id)
	{
		ModelAndView mv = new ModelAndView("index");
		sellerDAO.deleteById(id);
		return mv;
	} 




	// ##############################################~|Store|~#####################################################

	
	
	

	// redireciona para a pagina de cadastro de store
	@RequestMapping("/cadastro_store")
	public ModelAndView cadastroStore()
	{
		return new ModelAndView("cadastro_store");
	}


	// abre pagina de cadastro de store
	@RequestMapping(value = {"/store"})
	public ModelAndView findAllStores() {

		ModelAndView mv = new ModelAndView("store");

		mv.addObject("storeList", storeDAO.findAll());
		return mv;
	}

	// retorna lista de stores
	@RequestMapping(value = {"/storeList"})
	public List<Store> storeList() {
		// retorna lista de produtos
		return storeDAO.findAll();
	}


	// salvar store no bd
	@RequestMapping("/salvarStore")
	public ModelAndView salvarProduct(@RequestParam("sellerID") String sellerID,
			@RequestParam("productPrice") Float productPrice, @RequestParam("productQty") Integer productQty,
			@RequestParam("productID") Integer productID)
	{
		Store store = new Store();
		store.setSellerID(sellerID);
		store.setProductPrice(productPrice);
		store.setProductQty(productQty);
		store.setProductID(productID);
		storeDAO.save(store);

		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

	// editar user no bd
	@RequestMapping("/editarStore")
	public ModelAndView editarStore(@RequestParam("id") long id, @RequestParam("sellerID") String sellerID,
			@RequestParam("productPrice") Float productPrice, @RequestParam("productQty") Integer productQty,
			@RequestParam("productID") Integer productID)
	{
		Store store = new Store();
		store.setSellerID(sellerID);
		store.setProductPrice(productPrice);
		store.setProductQty(productQty);
		store.setProductID(productID);
		store.setID(id);
		storeDAO.save(store);

		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

	// recebo id da conta e a removo do bd
	@RequestMapping("/remove_store/{id}")
	public ModelAndView removeStore(@PathVariable Long id)
	{
		ModelAndView mv = new ModelAndView("index");
		storeDAO.deleteById(id);
		return mv;
	}

}
