package com.dilara.TryMe_App.entity;

import com.dilara.TryMe_App.utility.enums.Gender;
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
@Table(name = "tbl_product")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    private int stockQuantity;
    private String imageUrl;
    private int discount;
    private double rating;
    private boolean availability;

    @Enumerated
    private Gender gender;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductFeatures> features;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductImages> images;
    @Embedded
    private BaseEntity baseEntity;

}
