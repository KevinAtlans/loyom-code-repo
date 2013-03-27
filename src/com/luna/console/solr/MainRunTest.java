package com.luna.console.solr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;

public class MainRunTest {

    public static SolrServer commonsHttpSolrServer() {

        String url = "http://localhost:8983/solr";
        SolrServer server = new HttpSolrServer(url);
        return server;
    }

    public static SolrServer getSolrServer() {

        // 对象实例可以重复使用
        return commonsHttpSolrServer();
    }

    public static void main(String[] arg0) throws SolrServerException, IOException {

        SolrServer server = getSolrServer();
        // 清空之前建立的索引数据
        server.deleteByQuery("*:*");
        // 创建一个文档
        SolrInputDocument doc1 = new SolrInputDocument();
        doc1.addField("id", "id1", 1.0f);
        doc1.addField("name", "doc1", 1.0f);
        doc1.addField("price", 10);
        // 创建另外一个文档
        SolrInputDocument doc2 = new SolrInputDocument();
        doc2.addField("id", "id2", 1.0f);
        doc2.addField("name", "doc2", 1.0f);
        doc2.addField("price", 20);
        // 创建文档集合
        Collection<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
        docs.add(doc1);
        docs.add(doc2);
        // 将文档添加到 Solr 中
        server.add(docs);
        // 提交
        server.commit();
    }
}
