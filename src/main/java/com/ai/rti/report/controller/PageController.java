package com.ai.rti.report.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class PageController {

	@RequestMapping("home")
	public String goHome() {
		return "home";
	}

	@RequestMapping("go")
	public @ResponseBody Map<String, Object> getEchartsLineData(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap.put("key", "nuksdkasd");
		return retMap;
	}
}
