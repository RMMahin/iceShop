package com.example.iceshop.service;

import com.example.iceshop.model.IceCream;
import com.example.iceshop.repository.IceCreamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IceCreamService {
    private final IceCreamRepository repository;

    public IceCreamService(IceCreamRepository repository) {
        this.repository = repository;
    }

    public IceCream createIceCream(IceCream iceCream) {
        return repository.save(iceCream);
    }

    public IceCream getIceCreamById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<IceCream> getIceCreamList(String key) {
        return repository.getIceCreamList(key);
    }
}
