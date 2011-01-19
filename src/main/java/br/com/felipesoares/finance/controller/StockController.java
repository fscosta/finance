package br.com.felipesoares.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.felipesoares.finance.dao.StockDao;

@Controller
public class StockController {

	@Autowired
	StockDao stockDao;
	
	@RequestMapping("list.do")
	public ModelMap list() {
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("stockList", stockDao.findAll());
		return modelMap;
	}
	
	@RequestMapping("show.do")
	public ModelMap show(@RequestParam(required = true) String code) {
		return new ModelMap("stock", stockDao.findById(code));
	}
	
}
