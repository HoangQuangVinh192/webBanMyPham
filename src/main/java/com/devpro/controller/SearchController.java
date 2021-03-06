package com.devpro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.entities.Product;
import com.devpro.services.ProductService;

@Controller
public class SearchController extends BaseController{
	@Autowired 
	ProductService productService;
	
	@RequestMapping(value = { "/search" })
	public String viewHomePage(ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {
        String keyword = request.getParameter("keyword");
		List<Product> products = productService.listAll(keyword);
        model.addAttribute("products", products);
		return "front-end/search";
	}
}
