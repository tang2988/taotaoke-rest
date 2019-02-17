package com.taotaoke.rest.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taotaoke.mapper.TbContentMapper;
import com.taotaoke.pojo.TbContent;
import com.taotaoke.pojo.TbContentExample;
import com.taotaoke.pojo.TbContentExample.Criteria;
import com.taotaoke.rest.service.ContentService;


@Service
public class ContentServiceImpl implements ContentService {

	@Resource
	TbContentMapper contentMapper;
	
	public List<TbContent> getContentListByCategoryId(Long categoryId) {
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		
		 List<TbContent> list = contentMapper.selectByExample(example);
		return list;
	}

}
