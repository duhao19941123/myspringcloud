package com.dh.drools.controller;

import com.dh.drools.dao.DroolsMapper;
import com.dh.drools.entity.DroolsEntity;
import com.dh.drools.entity.EntityRule;
import com.dh.drools.entity.RuleEngine;
import com.dh.drools.entity.RuleEngineImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("test")
public class DroolsController {


    @Autowired
    private DroolsMapper droolsMapper;

    @RequestMapping("test")
    public void test(){
        RuleEngine engineImpl =new RuleEngineImpl();
        engineImpl.init();
        final EntityRule entityRule= new EntityRule();
        entityRule.setCurrentmoney(350d);
        entityRule.setUsername("Candy");
        entityRule.setAccount(true);
        entityRule.setTotailaddmoney(350d);
        entityRule.setAddtime(7);
        engineImpl.execute(entityRule);
    }

    @RequestMapping("update")
    public void update() throws IOException {
        try {
            FileOutputStream fos=new FileOutputStream(Thread.currentThread().getContextClassLoader().getResource("templates/drools_rule.drl").getFile());
            BufferedOutputStream bos=new BufferedOutputStream(fos);
            List<DroolsEntity> droolsEntities =  droolsMapper.getList();
            StringBuffer content = new StringBuffer("");
            droolsEntities.stream().forEach(droolsEntity -> content.append(droolsEntity.getContent()));
            String str = content.toString().replaceAll("\\\\r\\\\n" , "\r\n");
            bos.write(str.getBytes(),0,str.getBytes().length);
            bos.flush();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
