package com.jframe.base;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Author: Jimmy He
 * @Date: 2023/5/28 22:00
 * @Description: Query类
 */
public abstract class Query implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    /**
     * 操作人id
     */
    private Long operatorId;

    /**
     * 操作人名称
     */
    private Long operatorName;

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Long getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(Long operatorName) {
        this.operatorName = operatorName;
    }
}
