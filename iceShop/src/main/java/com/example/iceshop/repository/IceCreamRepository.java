package com.example.iceshop.repository;

import com.example.iceshop.model.IceCream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IceCreamRepository extends JpaRepository<IceCream, Long> {

    @Query(value = "SELECT * FROM ice_cream WHERE LOWER(name) like LOWER(CONCAT('%', :key, '%'))", nativeQuery = true)
    List<IceCream> getIceCreamList(String key);
}
