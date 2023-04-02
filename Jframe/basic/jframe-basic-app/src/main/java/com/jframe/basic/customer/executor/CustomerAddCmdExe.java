
package com.jframe.basic.customer.executor;

import com.alibaba.cola.dto.Response;

import com.jframe.basic.dto.CustomerAddCmd;
import com.jframe.basic.dto.data.ErrorCode;
import org.springframework.stereotype.Component;


@Component
public class CustomerAddCmdExe{

    public Response execute(CustomerAddCmd cmd) {
        //The flow of usecase is defined here.
        //The core ablility should be implemented in Domain. or sink to Domian gradually
//        if(cmd.getCustomerDTO().getCompanyName().equals("ConflictCompanyName")){
//            throw new BizException(ErrorCode.B_CUSTOMER_companyNameConflict.getErrCode(), "公司名冲突");
//        }
        return Response.buildSuccess();
    }

}
