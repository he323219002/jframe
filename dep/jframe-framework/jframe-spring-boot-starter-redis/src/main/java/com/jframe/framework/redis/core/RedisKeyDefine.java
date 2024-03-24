package com.jframe.framework.redis.core;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.Duration;

/**
 * @Author: Jimmy He
 * @Date: 2024/3/24 16:19
 * @Description: TODO 描述
 */
@Data
public class RedisKeyDefine {

    @Getter
    @AllArgsConstructor
    public enum KeyTypeEnum {

        STRING("String"),
        LIST("List"),
        HASH("Hash"),
        SET("Set"),
        Z_SET("Sorted Set"),
        STREAM("Stream"),
        PUBSUB("Pub/Sub");

        /**
         * 类型
         */
        @JsonValue
        private final String type;
    }

    @Getter
    @AllArgsConstructor
    public enum TimeoutTypeEnum {

        FOREVER(1), // 永不超时
        DYNAMIC(2), // 动态超时
        FIXED(3); // 固定超时

        /**
         * 类型
         */
        @JsonValue
        private final Integer type;

    }

    /**
     * Key 模板
     */
    private final String keyTemplate;
    /**
     * Key 类型的枚举
     */
    private final KeyTypeEnum keyType;

    /**
     * 超时类型
     */
    private final TimeoutTypeEnum timeoutType;
    /**
     * 过期时间
     */
    private final Duration timeout;
    /**
     * 备注
     */
    private final String memo;
}
