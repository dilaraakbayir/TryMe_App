package com.dilara.TryMe_App.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_model")
@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String description;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ElementCollection
    private List<Product> products;

    @Embedded
    private BaseEntity baseEntity;

}
