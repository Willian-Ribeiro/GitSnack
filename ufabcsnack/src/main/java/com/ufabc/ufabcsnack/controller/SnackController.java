package com.ufabc.ufabcsnack.controller;

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
import com.ufabc.ufabcsnack.model.entity.Seller;
import com.ufabc.ufabcsnack.model.entity.SnackUser;

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

	
	// metodos para user
	
	
	// redireciona para a pagina de cadastro
	@RequestMapping("/cadastro")
	public ModelAndView cadastro()
	{
		return new ModelAndView("cadastro");
	}


	// abre pagina de cadastro de usuario
	@RequestMapping(value = {"/", "/index"})
	public ModelAndView execute() {

		ModelAndView mv = new ModelAndView("index");

		mv.addObject("userList", userDAO.findAll());

		return mv;
	}

	// salvar user no bd
	@RequestMapping("/salvar")
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

	// recebo os parametros digitados pelo usuario e os atualizo no BD
	@RequestMapping("/edit/{id}")
	public ModelAndView editar(@PathVariable Long id)
	{
		SnackUser temp = userDAO.getOne(id);

		ModelAndView mv = new ModelAndView("editar");
		mv.addObject("conta", temp);
		return mv;
	}

	// recebo id da conta e a removo do bd
	@RequestMapping("/remove/{id}")
	public ModelAndView remove(@PathVariable Long id)
	{
		System.out.println("O valor recebido foi: " + id);

		// recupero a conta a se remover atraves do id
		SnackUser temp = userDAO.getOne(id);

		ModelAndView mv = new ModelAndView("remove");
		mv.addObject("user", temp);

		userDAO.deleteById(id);
		return mv;
	}
	
	
	// ##############################################~|Product|~#####################################################
	

	// abre pagina de cadastro de usuario
	@RequestMapping(value = {"/", "/index"})
	public ModelAndView findAllProducts() {

		ModelAndView mv = new ModelAndView("index");

		mv.addObject("productsList", productDAO.findAll());

		return mv;
	}


	// ##############################################~|FullProduct|~#####################################################
	
	
	
	// ##############################################~|Seller|~#####################################################
	
		// abre pagina de cadastro de usuario
		@RequestMapping(value = {"/", "/index"})
		public ModelAndView findAllSellers() {

			ModelAndView mv = new ModelAndView("index");

			mv.addObject("sellerList", sellerDAO.findAll());

			return mv;
		}
		

		@RequestMapping(value = {"/add"}, method = RequestMethod.GET)
		public @ResponseBody
		Seller add(HttpServletRequest request, HttpServletResponse response)
				throws Exception {

			Seller seller = new Seller();

			seller.setSellerDesc("Seller Desc");
			seller.setSellerName("Seller Name");
			seller.setPositionX((float) 11.1);
			seller.setPositionY((float) 22.2);
			seller.setStatus(33);

			return seller;
		}
		
		
		
	
	
	// ##############################################~|Store|~#####################################################
	
	
	
	
}
