package com.ufabc.ufabcsnack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ufabc.ufabcsnack.model.dao.SellerDAO;
import com.ufabc.ufabcsnack.model.dao.UserDAO;
import com.ufabc.ufabcsnack.model.entity.SnackUser;

@Controller
public class SnackController {
	
	@Autowired
	SellerDAO sdao;
	
	@Autowired
	UserDAO udao;
	
	// abre pagina de cadastro de usuario
	@RequestMapping("/cadastro")
	public ModelAndView execute() {

		ModelAndView mv = new ModelAndView("cadastro");
		return mv;
	}
	
	// salvar user no bd
	@RequestMapping("/save")
	public ModelAndView testaPost(@RequestParam("password") String password,
			@RequestParam("tipo") int tipo)
	{
		System.out.println("Os parametros recebidos foram:" 
				+"\n Password: " + password
				+"\n tipo: " + tipo);
		
		SnackUser user = new SnackUser();
		user.setPassword(password);
		user.setTipo(tipo);
		udao.save(user);
		
		ModelAndView mv = new ModelAndView("confirmacao");
		return mv;
	}

}
