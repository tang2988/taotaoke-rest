package com.taotaoke.rest.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotaoke.common.pojo.TaotaoResult;
import com.taotaoke.common.util.ExceptionUtil;
import com.taotaoke.pojo.TbContent;
import com.taotaoke.rest.service.ContentService;

@Controller 
@RequestMapping("content")
public class ContentController {

	@Resource
	ContentService contentService;
	
	@RequestMapping("/list/{contentgoryId}")
	@ResponseBody
	public TaotaoResult getContentList(@PathVariable Long contentgoryId){
		try {
			 List<TbContent> list = contentService.getContentListByCategoryId(contentgoryId);
			return TaotaoResult.ok(list);
		} catch (Exception e) {
			
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
	}
}


