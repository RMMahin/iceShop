package com.example.iceshop.model;

import com.example.iceshop.common.AuditData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ice-cream")
public class IceCream extends AuditData {
    private String name;
    private Integer price;
    private Integer stock;
    private String color;

    @OneToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}
