package com.example.iceshop.service;

import com.example.iceshop.model.Supplier;
import com.example.iceshop.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    private final SupplierRepository repository;

    public SupplierService(SupplierRepository repository) {
        this.repository = repository;
    }

    public Supplier save(Supplier supplier) {
        return repository.save(supplier);
    }

    public List<Supplier> getSupplierList() {
        return repository.findAll();
    }
}
