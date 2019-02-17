package com.taotaoke.rest.service;

import java.util.List;

import com.taotaoke.pojo.TbContent;

public interface ContentService {
	
	List<TbContent> getContentListByCategoryId(Long categoryId);

}
