package com.example.iceshop.controller;

import com.example.iceshop.model.Supplier;
import com.example.iceshop.service.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SupplierController {
    private final SupplierService service;

    public SupplierController(SupplierService service) {
        this.service = service;
    }

    @GetMapping("/supplier")
    public String supplier(Model model) {
        model.addAttribute("supplier", new Supplier());
        return "supplier/supplier-entry";
    }

    @PostMapping("/supplier")
    public String addSupplier(@ModelAttribute Supplier supplier) {
        supplier = service.save(supplier);
        return "redirect:/supplier";
    }
}
