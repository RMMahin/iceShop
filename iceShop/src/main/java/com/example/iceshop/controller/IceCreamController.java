package com.example.iceshop.controller;

import com.example.iceshop.model.IceCream;
import com.example.iceshop.service.IceCreamService;
import com.example.iceshop.service.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IceCreamController {
    private final IceCreamService service;
    private final SupplierService supplierService;

    public IceCreamController(IceCreamService service,
                              SupplierService supplierService) {
        this.service = service;
        this.supplierService = supplierService;
    }

    @GetMapping("/add-ice-cream")
    public String createIceCream(@RequestParam(name = "id", required = false) Long id, Model model) {
        if (id != null) {
            IceCream iceCream = service.getIceCreamById(id);
            model.addAttribute("iceCream", iceCream);
        } else {
            model.addAttribute("iceCream", new IceCream());
        }
        model.addAttribute("supplierList", supplierService.getSupplierList());
        return "ice-cream/ice-cream-entry";
    }

    @PostMapping("/add-ice-cream")
    public String createIceCream(@ModelAttribute IceCream iceCream) {
        iceCream = service.createIceCream(iceCream);
        return "redirect:/add-ice-cream?id=" + iceCream.getId();
    }

    @GetMapping("/get-list")
    public String iceCreamList(@RequestParam(name = "key", required = false) String key, Model model) {
        List<IceCream> iceCreamList = service.getIceCreamList(key);
        model.addAttribute("iceCreamList", iceCreamList);
        return "ice-cream/ice-cream-list";
    }
}
