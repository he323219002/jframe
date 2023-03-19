package com.jframe.basic.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.jframe.basic.dto.CustomerAddCmd;
import com.jframe.basic.dto.CustomerListByNameQry;
import com.jframe.basic.dto.data.CustomerDTO;

public interface CustomerServiceI {

    Response addCustomer(CustomerAddCmd customerAddCmd);

    MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry);
}
