package com.taotaoke.rest.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taotaoke.mapper.TbItemCatMapper;
import com.taotaoke.pojo.TbItemCat;
import com.taotaoke.pojo.TbItemCatExample;
import com.taotaoke.pojo.TbItemCatExample.Criteria;
import com.taotaoke.rest.pojo.CatNode;
import com.taotaoke.rest.pojo.CatResult;
import com.taotaoke.rest.service.itemCatService;

@Service
public class itemCatServiceImpl implements itemCatService {

	@Resource
	TbItemCatMapper catMapper;

	public CatResult getItemCatlist() {

		CatResult catResult = new CatResult();
		// 查询分类列表

		catResult.setData(getCatList(0));
		return catResult;
	}

	/**
	 * 查询分类列表
	 * 
	 * @return
	 */
	public List<?> getCatList(long parentId) {
		// 创建查询条件
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = catMapper.selectByExample(example);
		List resultlist = new ArrayList<>();
		int count = 0;
		// 向list中添加节点
		for (TbItemCat tbItemCat : list) {
			// 判断是否为父节点
			if (tbItemCat.getIsParent()) {
				CatNode catNode = new CatNode();
				if (parentId == 0) {
					catNode.setName(
							"<a href='/products/" + tbItemCat.getId() + ".html'>" + tbItemCat.getName() + "</a>");
				} else {
					catNode.setName(tbItemCat.getName());
				}
				catNode.setUrl("/products/" + tbItemCat.getId() + ".html");
				catNode.setItem(getCatList(tbItemCat.getId()));

				resultlist.add(catNode);
				count++;
				if (count >= 14 && parentId == 0) {
					break;
				}
				// 如果是叶子节点
			} else {
				resultlist.add("/products/" + tbItemCat.getId() + ".html|" + tbItemCat.getName());
			}
		}
		return resultlist;
	}

}
