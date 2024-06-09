package com.dilara.TryMe_App.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_customers")
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String surname;

    @Email
    private String email;

    @Column(length = 15)
    private String phone;

    @Size(min = 3, max = 32)
    private String password;

    @Size(min = 3, max = 32)
    private String rePassword;

    @Column(length = 500)
    private String address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<CustomerAndProductImage> customer_productImages;

    @ManyToMany
    @JoinTable(
            name = "customer_favorite_products",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> favoriteProducts;

    @Embedded
    private BaseEntity baseEntity;
}
