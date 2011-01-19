package br.com.felipesoares.finance.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.felipesoares.finance.dao.RankingDao;
import br.com.felipesoares.finance.dao.StockAttributeTypeDao;
import br.com.felipesoares.finance.domain.Filter;
import br.com.felipesoares.finance.domain.Ranking;
import br.com.felipesoares.finance.domain.SortingRule;
import br.com.felipesoares.finance.domain.StockAttributeType;
import br.com.felipesoares.finance.service.RankingService;

@Controller
public class RankingController {

	@Autowired
	protected RankingService rankingService;
	
	@Autowired
	protected RankingDao rankingDao;
	
	@Autowired
	protected StockAttributeTypeDao stockAttributeTypeDao;
	
	@RequestMapping("list.do")
	public ModelMap list() {
		return new ModelMap("rankings", rankingDao.findAll());
	}

	@RequestMapping("show.do")
	public ModelMap show(@RequestParam(required = true) Long id) {
		return new ModelMap("ranking", rankingDao.findById(id));
	}
	
	@RequestMapping("create.do")
	public ModelMap create(@RequestParam(required = false) Long id) {
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("sort", new SortingRule(new StockAttributeType()));
		modelMap.addAttribute("filter", new Filter(new StockAttributeType()));

		Map<String,String> stockAttributes = new HashMap<String, String>();

		for (StockAttributeType attribute : stockAttributeTypeDao.findAll())
			stockAttributes.put(attribute.getId(), attribute.getLabel());
		
		modelMap.addAttribute("stockAttributes", stockAttributes);
		return modelMap;
	}
	
	@RequestMapping("edit.do")
	public ModelMap edit(@RequestParam(required = false) Long id) {
		ModelMap modelMap = new ModelMap();
		
		if (id != null)
			modelMap.addAttribute("ranking", rankingDao.findById(id));
		
		modelMap.addAttribute("stockAttributes", stockAttributeTypeDao.findAll());
		return modelMap;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "save.do")
	public String save(Ranking ranking, BindingResult bindingResult) {
		
		if (ranking.getId() != null)
			ranking = rankingDao.findById(ranking.getId()); 
		else {
			ranking = new Ranking();
			ranking.setDate(new Date());
		}
		
		ranking.setTitle(ranking.getTitle());
		rankingDao.save(ranking);
		return "redirect:show.do?id=" + ranking.getId();
	}
	
	@RequestMapping("delete.do")
	public String delete(@RequestParam(required = true) Long id) {
		Ranking ranking = rankingDao.findById(id);
		rankingDao.delete(ranking);
		return "redirect:list.do";
	}
	
	@RequestMapping("refresh.do")
	public String refresh(@RequestParam Long id) {
		rankingService.refresh(id);
		return "redirect:show.do?id=" + id;
	}
	
}
