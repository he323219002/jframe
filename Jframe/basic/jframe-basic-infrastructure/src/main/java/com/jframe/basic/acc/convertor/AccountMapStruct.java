package com.jframe.basic.acc.convertor;

import com.jframe.basic.acc.dto.data.AccountDto;
import com.jframe.basic.acc.domain.entity.Account;
import com.jframe.basic.acc.gatewayimpl.database.dataobject.AccountDbo;
import org.mapstruct.Mapper;

/**
* @author jimmy
* @since 2023-04-27
*/
@Mapper(componentModel = "spring")
public interface AccountMapStruct {

    Account toEntity(AccountDto dto);

    AccountDbo toDbo(Account entity);
}
