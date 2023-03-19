package com.jframe.basic.domain.customer.gateway;

import com.jframe.basic.domain.customer.Credit;

//Assume that the credit info is in another distributed Service
public interface CreditGateway {
    Credit getCredit(String customerId);
}
