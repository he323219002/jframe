package com.jframe.basic.acc.convertor;

import com.jframe.basic.acc.convertor.custom.EnumerateConvertor;
import com.jframe.basic.acc.dto.AccountTestQry;
import com.jframe.basic.acc.dto.cmd.AccountAdminCreateCmd;
import com.jframe.basic.acc.dto.data.AccountDto;
import com.jframe.basic.acc.domain.entity.Account;
import com.jframe.basic.acc.gatewayimpl.database.dataobject.AccountDbo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author jimmy
 * @since 2023-04-27
 */
@Mapper(componentModel = "spring", uses = EnumerateConvertor.class)
public interface AccountMapStruct {

    Account toEntity(AccountTestQry qry);

    Account toEntity(AccountAdminCreateCmd cmd);

    Account toEntity(AccountDbo dbo);

    @Mapping(source = "status", target = "status", qualifiedByName = "codeConvertToAccountStatus")
    Account toEntity(AccountDto dto);

    AccountDbo toDbo(Account entity);
}
