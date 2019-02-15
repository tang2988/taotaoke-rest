package com.taotaoke.rest.controller;

import javax.annotation.Resource;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotaoke.rest.pojo.CatResult;
import com.taotaoke.rest.service.itemCatService;

@Controller
public class ItemCatController {

	@Resource
	public itemCatService catService;

	@RequestMapping("/itemcat/list")
	@ResponseBody
	public Object getitemCatlist(String callback) {

		CatResult catResult = catService.getItemCatlist();
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(catResult);
		mappingJacksonValue.setJsonpFunction(callback);
		return mappingJacksonValue;

	}
}
