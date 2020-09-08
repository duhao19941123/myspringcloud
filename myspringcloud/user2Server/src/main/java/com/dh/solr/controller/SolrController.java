package com.dh.solr.controller;

import com.dh.solr.entity.ILog;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("solr")
public class SolrController {

    @Autowired
    private SolrClient solrClient;

    @GetMapping("test")
    @RequestMapping("test")
    public List<ILog> test(String content , int pageNo , int pageSize ){
        SolrQuery query = new SolrQuery();
        query.setQuery("content:*" + content + "*" + " and content:*" + content + "*");
        query.setStart((pageNo - 1) * pageSize);
        query.setRows(pageSize);
        query.setSort("logId" , SolrQuery.ORDER.desc);
        QueryResponse response = null;
        SolrDocumentList documentList = null;
        List<ILog> list = new ArrayList<>();
        try {
            response = solrClient.query(query);
            documentList = response.getResults();
            if (!documentList.isEmpty()) {
                for (SolrDocument document:documentList) {
                    ILog  iLog= new ILog();
                    String logId = (String) document.get("logId");
                    iLog.setLogId(Long.valueOf(logId));
                    iLog.setContent((String) document.get("content"));
                    list.add(iLog);
                }
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}

