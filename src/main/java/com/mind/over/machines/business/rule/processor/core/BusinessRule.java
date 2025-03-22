package com.mind.over.machines.business.rule.processor.core;


import com.mind.over.machines.business.rule.processor.exception.BusinessRuleException;

public interface BusinessRule {
    void execute(String customerId) throws BusinessRuleException;
    String getRuleName();
}
