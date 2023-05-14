package com.jframe.basic.acc.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author: Jimmy He
 * @Date: 2023/5/14 21:52
 * @Description: TODO 描述
 */
@Data
public class AccountTestQry {

    @NotNull
    private Long id;
}
