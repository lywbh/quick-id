package com.lyw.quickid.config;

import com.lyw.quickid.core.QuickId;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "quick-id", name = "sharding-id")
@EnableConfigurationProperties(GeneratorProperties.class)
public class QuickIdAutoConfiguration {

    private GeneratorProperties properties;

    public QuickIdAutoConfiguration(GeneratorProperties properties) {
        this.properties = properties;
    }

    @Bean("quickIdConfig")
    public QuickIdConfig quickIdConfig() {
        return new QuickIdConfig(properties.getShardingBits(), properties.getSeqBits());
    }

    @Bean("quickId")
    public QuickId quickId(QuickIdConfig config) {
        if (properties.getShardingBits() + properties.getSeqBits() > 22) {
            throw new IllegalArgumentException("too long for the total sum of sharding-bits and seq-bits");
        }
        long shardingId = properties.getShardingId();
        long shardingMax = config.SHARDING_MAX();
        if (shardingId > shardingMax || shardingId < 0) {
            throw new IllegalArgumentException("illegal sharding-id, required 0 to " + shardingMax + ", actually " + shardingId);
        }
        return new QuickId(shardingId);
    }

}
