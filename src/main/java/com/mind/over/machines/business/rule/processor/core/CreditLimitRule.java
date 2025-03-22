package com.mind.over.machines.business.rule.processor.core;

import com.mind.over.machines.business.rule.processor.exception.BusinessRuleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CreditLimitRule implements BusinessRule {
    private static final Logger logger = LoggerFactory.getLogger(CreditLimitRule.class);
    private final Random random = new Random();

    @Override
    public void execute(String customerId) throws BusinessRuleException{
        if (random.nextInt(10) > 7) { // Simulate failure for 30% of cases
            throw new BusinessRuleException("Credit limit exceeded for customer ID: " + customerId);
        }
        logger.info("✅ CreditLimitRule executed successfully for customer ID: {}", customerId);
    }

    @Override
    public String getRuleName() {
        return "CreditLimitRule";
    }
}