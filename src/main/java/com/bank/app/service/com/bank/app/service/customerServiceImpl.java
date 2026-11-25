package com.bank.app.service.com.bank.app.service;

import com.bank.app.model.customerModel;
import com.bank.app.repository.com.bank.app.repository.customerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class customerServiceImpl implements customerService {

    private final customerRepository customerRP;

    public customerServiceImpl(customerRepository customerRP) {
        this.customerRP = customerRP;
    }

    @Override
    public List<customerModel> getAllCustomer() {
        return customerRP.findAll();
    }

    @Override
    public customerModel createCustomer(customerModel cm) {
        return customerRP.save(cm);
    }

    @Override
    public customerModel getCustomersById(Long customerId) {
        return customerRP.findById(customerId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Customer not found with id " + customerId));
    }

    @Override
    public String updateCustomer(customerModel cm, Long customerId) {
        customerModel existing = customerRP.findById(customerId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Customer not found with id " + customerId));

        existing.setFirstName(cm.getFirstName());
        existing.setLastName(cm.getLastName());
        existing.setEmail(cm.getEmail());
        existing.setPhoneNumber(cm.getPhoneNumber());
        customerRP.save(existing);

        return "Customer updated successfully";
    }

    @Override
    public String deleteCustomer(Long customerId) {
        if (!customerRP.existsById(customerId)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Customer not found with id " + customerId);
        }
        customerRP.deleteById(customerId);
        return "Customer deleted successfully";
    }
}