package com.study.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.study.service.IndexService;

@Controller
public class IndexController {
	
	private final Logger logger = LoggerFactory.getLogger(IndexController.class);
	private final IndexService indexService;

	@Autowired
	public IndexController(IndexService indexService) {
		this.indexService = indexService;
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {
		logger.debug("index() is executed!");

		model.put("title", indexService.getTitle(""));
		model.put("msg", indexService.getDesc());
		
		return "index";
	}
	
	@RequestMapping(value="/index/{name:.+}", method=RequestMethod.GET)
	public ModelAndView index(@PathVariable("name") String name) {
		logger.debug("hello() is executed - $name {}", name);
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("index");
		
		mv.addObject("title", indexService.getTitle(name));
		mv.addObject("msg", indexService.getDesc());
		
		return mv;
	}
}
