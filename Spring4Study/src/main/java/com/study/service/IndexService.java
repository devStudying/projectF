package com.study.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class IndexService {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexService.class);
	
	public String getDesc() {
		logger.debug("getDesc() is excuted!");
		
		return "Gradle + Spring MVC Hello World Example";
	}
	
	public String getTitle(String name) {
		logger.debug("getTilte() is executed! $name : {}", name);
		
		if(StringUtils.isEmpty(name)) {
			return "Hello World";
		}
		else {
			return "Hello "+name;
		}
	}
}
