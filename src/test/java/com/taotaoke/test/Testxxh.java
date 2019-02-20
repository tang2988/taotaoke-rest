package com.taotaoke.test;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class Testxxh {

	@Test
	public void addsolr() throws Exception {

		// 创建一个连接

		SolrServer server = new HttpSolrServer("http://39.108.209.252:8080/solr");
		// 创建document对象
		SolrInputDocument document = new SolrInputDocument();

		document.addField("item_title", "谢雄辉帅哥");
		document.addField("id", "test01");
		// 把document写入索引库

		server.add(document);

		// 提交
		server.commit();

	}

	@Test
	public void deletedocument() throws Exception {

		//创建一个连接
		SolrServer server = new HttpSolrServer("http://39.108.209.252:8080/solr");
		server.deleteById("test01");
		server.commit();
	}

}
