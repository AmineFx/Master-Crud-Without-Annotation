package com.bank.app.service.com.bank.app.service;

import com.bank.app.model.customerModel;

import java.util.List;

public interface customerService {
    List<customerModel> getAllCustomer();

    customerModel createCustomer(customerModel customer);

    customerModel getCustomersById(Long customerId);

    String updateCustomer(customerModel customer, Long customerId);

    String deleteCustomer(Long customerId);
}
