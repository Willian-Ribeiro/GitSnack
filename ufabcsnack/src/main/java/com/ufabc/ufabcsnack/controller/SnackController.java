package com.ufabc.ufabcsnack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

	// redireciona para a pagina de cadastro
	// salvar user no bd
	@RequestMapping("/cadastro")
	public ModelAndView cadastro()
	{
		return new ModelAndView("cadastro");
	}


	// abre pagina de cadastro de usuario
	@RequestMapping(value = {"/", "/index"})
	public ModelAndView execute() {

		ModelAndView mv = new ModelAndView("index");

		mv.addObject("userList", udao.findAll());

		return mv;
	}

	// salvar user no bd
	@RequestMapping("/salvar")
	public ModelAndView salvar(@RequestParam("password") String password,
			@RequestParam("tipo") boolean tipo)
	{
		// coverto o tipo de boolean para int
		int tipoInt = tipo? 1 : 0; 
		SnackUser user = new SnackUser();
		user.setPassword(password);
		user.setTipo(tipoInt);
		udao.save(user);
		
		ModelAndView mv = new ModelAndView("usuariocriado");
		mv.addObject("user", user);

		return mv;
	}

	// recebo os parametros digitados pelo usuario e os atualizo no BD
	@RequestMapping("/edit/{id}")
	public ModelAndView editar(@PathVariable Long id)
	{
		System.out.println("O valor recebido foi: " + id);

		SnackUser temp = udao.getOne(id);

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
		SnackUser temp = udao.getOne(id);

		ModelAndView mv = new ModelAndView("remove");
		mv.addObject("user", temp);

		udao.deleteById(id);
		return mv;
	}

}
