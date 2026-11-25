package com.bank.app.controller.com.bank.app;


import com.bank.app.model.customerModel;
import com.bank.app.service.com.bank.app.service.customerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class customerController {

    private final customerService service;

    public customerController(customerService service) {
        this.service = service;
    }

    // Create
    @PostMapping
    public ResponseEntity<customerModel> createCustomer(@RequestBody customerModel cm) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createCustomer(cm));
    }

    // Get all
    @GetMapping
    public ResponseEntity<List<customerModel>> getAllCustomers() {
        return ResponseEntity.ok(service.getAllCustomer());
    }

    // Get by id
    @GetMapping("/{id}")
    public ResponseEntity<customerModel> getCustomerById(@PathVariable("id") Long customerId) {
        return ResponseEntity.ok(service.getCustomersById(customerId));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCustomer(@RequestBody customerModel cm,
                                                 @PathVariable("id") Long customerId) {
        return ResponseEntity.ok(service.updateCustomer(cm, customerId));
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long customerId) {
        return ResponseEntity.ok(service.deleteCustomer(customerId));
    }
}
