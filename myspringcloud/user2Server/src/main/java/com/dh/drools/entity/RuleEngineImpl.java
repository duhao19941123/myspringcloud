package com.dh.drools.entity;

import org.drools.RuleBase;
import org.drools.StatefulSession;
import org.drools.compiler.DroolsParserException;
import org.drools.compiler.PackageBuilder;
import org.drools.spi.Activation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class RuleEngineImpl implements RuleEngine {
    private RuleBase ruleBase;

    /*
     * (non-Javadoc)
     * @see com.core.drools.RuleEngine#init()
     */
    @Override
    public void init() {
        /** Sets the system time format. */
        System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm:ss");
        /** Get the base factory. */
        ruleBase = SingleRuleFactory.getRuleBase();
        try {
            /** Get the rule files has bean read. */
            PackageBuilder backageBuilder = getPackageBuilderFile();
            /** Add the package to the 'RuleBase'. */
            ruleBase.addPackages(backageBuilder.getPackages());
        } catch (DroolsParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * (non-Javadoc)
     * @see com.core.drools.RuleEngine#refresh()
     */
    @Override
    public void refresh() {
        ruleBase = SingleRuleFactory.getRuleBase();
        org.drools.rule.Package[] packages = ruleBase.getPackages();
        for(org.drools.rule.Package items :packages){
            ruleBase.removePackage(items.getName());
        }
        init();
    }

    /*
     * (non-Javadoc)
     * @see com.core.drools.RuleEngine#execute(com.core.drools.EntityRule)
     */
    @Override
    public void execute(final EntityRule entityRule) {
        if(null == ruleBase.getPackages() || 0 == ruleBase.getPackages().length) {
            return;
        }

        StatefulSession statefulSession = ruleBase.newStatefulSession();
        statefulSession.insert(entityRule);
        statefulSession.fireAllRules(new org.drools.spi.AgendaFilter() {
            public boolean accept(Activation activation) {
                return !activation.getRule().getName().contains("_test");
            }
        });
        statefulSession.dispose();
    }

    /**
     * Read the rule files.
     * @return
     * @throws Exception
     */
    private PackageBuilder getPackageBuilderFile()throws Exception {
        /** Get the rule files. */
        List<String> drlFilePath = getRuleFile();
        /** Sets the file to 'readers'. */
        List<Reader> readers = loadRuleFile(drlFilePath);
        /** To create the 'backageBuilder'. */
        PackageBuilder backageBuilder = new PackageBuilder();
        for (Reader r : readers) {
            backageBuilder.addPackageFromDrl(r);
        }
        /** Check if the script has a problem. */
        if(backageBuilder.hasErrors()) {
            throw new Exception(backageBuilder.getErrors().toString());
        }
        return backageBuilder;
    }

    /**
     * Load the script files.
     * @param drlFilePath
     * @return
     * @throws FileNotFoundException
     */
    private List<Reader> loadRuleFile(List<String> drlFilePath)
            throws FileNotFoundException {
        if (null == drlFilePath || 0 == drlFilePath.size()) {
            return null;
        }
        List<Reader> readers = new ArrayList<Reader>();
        for (String ruleFilePath : drlFilePath) {
            readers.add(new FileReader(new File(ruleFilePath)));
        }
        return readers;
    }

    /**
     * Get the rule files.
     * @return
     */
    private List<String> getRuleFile(){
        List<String> drlFilePath = new ArrayList<String>();
        String path= Thread.currentThread().getContextClassLoader().getResource("templates/drools_rule.drl").getPath();
        drlFilePath.add(path);
        return drlFilePath;
    }

}
