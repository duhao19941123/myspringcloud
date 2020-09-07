package com.dh.drools.entity;

import org.drools.RuleBase;
import org.drools.RuleBaseFactory;

public class SingleRuleFactory {
    private static RuleBase ruleBase;

    /**
     * Get the base factory.
     * @return
     */
    public static RuleBase getRuleBase(){
        return null != ruleBase ? ruleBase : RuleBaseFactory.newRuleBase();
    }
}
