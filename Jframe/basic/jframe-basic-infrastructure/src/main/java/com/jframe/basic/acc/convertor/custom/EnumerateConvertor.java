package com.jframe.basic.acc.convertor.custom;

import com.jframe.basic.acc.domain.enumerate.AccountStatusEnum;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

/**
 * @Author: Jimmy He
 * @Date: 2023/5/14 23:08
 * @Description: TODO 描述
 */
@Component
public class EnumerateConvertor {

    @Named("accountStatusConvertToCode")
    public Integer accountStatusConvert(AccountStatusEnum status){
        return status.code();
    }

    @Named("codeConvertToAccountStatus")
    public AccountStatusEnum accountStatusConvert(Integer code){
        return AccountStatusEnum.getByCode(code);
    }
}
