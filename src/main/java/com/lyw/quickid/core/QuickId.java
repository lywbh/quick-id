package com.lyw.quickid.core;

import com.lyw.quickid.config.QuickIdConfig;

import javax.annotation.Resource;

public class QuickId {

    @Resource
    private QuickIdConfig quickIdConfig;

    private long lastTimestamp;

    private long shardingId;

    private long sequenceId;

    public QuickId(long shardingId) {
        this.lastTimestamp = 0L;
        this.shardingId = shardingId;
        this.sequenceId = 0L;
    }

    /**
     * 生成ID：41bit时间戳+分片+序号
     */
    public synchronized long next() {
        long timestamp = System.currentTimeMillis();
        if (timestamp > lastTimestamp) {
            sequenceId = 0L;
            lastTimestamp = timestamp;
        } else if (timestamp == lastTimestamp) {
            if (sequenceId >= quickIdConfig.SEQ_MAX()) {
                throw new IllegalStateException("sequence id is full, max value is" + quickIdConfig.SEQ_MAX());
            }
            sequenceId++;
        } else {
            throw new IllegalStateException("timestamp error");
        }
        return (timestamp << (quickIdConfig.SHARDING_BITS() + quickIdConfig.SEQ_BITS()))
                | (shardingId << quickIdConfig.SEQ_BITS())
                | sequenceId;
    }

}
