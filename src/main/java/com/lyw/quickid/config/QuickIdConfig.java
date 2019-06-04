package com.lyw.quickid.config;

public class QuickIdConfig {

    public QuickIdConfig(long SHARDING_BITS, long SEQ_BITS) {
        this.SHARDING_BITS = SHARDING_BITS;
        this.SEQ_BITS = SEQ_BITS;
    }

    private long SHARDING_BITS;
    private long SEQ_BITS;

    /**
     * 分片ID位数
     */
    public long SHARDING_BITS() {
        return SHARDING_BITS;
    }

    /**
     * 实例内部序号位数
     */
    public long SEQ_BITS() {
        return SEQ_BITS;
    }

    /**
     * 分片ID最大值
     */
    public long SHARDING_MAX() {
        return (1L << SHARDING_BITS) - 1;
    }

    /**
     * 实例内部序号最大值
     */
    public long SEQ_MAX() {
        return (1L << SEQ_BITS) - 1;
    }

}
