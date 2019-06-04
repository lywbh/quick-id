package com.lyw.quickid.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "quick-id")
public class GeneratorProperties {

    /**
     * 机器分片ID（必须配置）
     */
    private long shardingId = -1;

    /**
     * 分片ID位数（可选，默认11位）
     */
    private long shardingBits = 11L;

    /**
     * 实例内部序号位数（可选，默认11位）
     */
    private long seqBits = 11L;

    public long getShardingId() {
        return shardingId;
    }

    public void setShardingId(long shardingId) {
        this.shardingId = shardingId;
    }

    public long getShardingBits() {
        return shardingBits;
    }

    public void setShardingBits(long shardingBits) {
        this.shardingBits = shardingBits;
    }

    public long getSeqBits() {
        return seqBits;
    }

    public void setSeqBits(long seqBits) {
        this.seqBits = seqBits;
    }

}
