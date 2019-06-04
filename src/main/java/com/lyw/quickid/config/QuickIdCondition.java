package com.lyw.quickid.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class QuickIdCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String shardingId = conditionContext.getEnvironment().getProperty("quick-id.sharding-id");
        if (shardingId == null) {
            return false;
        }
        try {
            Long.valueOf(shardingId);
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }

}
