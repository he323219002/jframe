package com.jframe.base;

import java.io.Serial;

/**
 * @Author: Jimmy He
 * @Date: 2023/5/28 22:02
 * @Description: PageQuery类
 */
public abstract class PageQuery extends Query {

    @Serial
    private static final long serialVersionUID = -1L;

    private int offset;

    private int size;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
