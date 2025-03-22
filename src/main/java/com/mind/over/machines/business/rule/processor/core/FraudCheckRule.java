package com.mind.over.machines.business.rule.processor.core;

import com.mind.over.machines.business.rule.processor.exception.BusinessRuleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class FraudCheckRule implements BusinessRule {
    private static final Logger logger = LoggerFactory.getLogger(FraudCheckRule.class);
    private final Random random = new Random();

    @Override
    public void execute(String customerId) throws  BusinessRuleException{
        if (random.nextBoolean()) { // Simulate 50% chance of failure
            throw new BusinessRuleException("Potential fraud detected for customer ID: " + customerId);
        }
        logger.info("✅ FraudCheckRule executed successfully for customer ID: {}", customerId);
    }

    @Override
    public String getRuleName() {
        return "FraudCheckRule";
    }
}