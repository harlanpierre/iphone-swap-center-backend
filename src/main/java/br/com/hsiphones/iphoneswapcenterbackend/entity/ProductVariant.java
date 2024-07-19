package br.com.hsiphones.iphoneswapcenterbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "product_variant")
public class ProductVariant implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @Column(length = 20)
    @Size(max = 20, message = "Maximum size for the Color of ProductVariant is 20 characters")
    private String color;

    @Column(length = 50)
    @Size(max = 50, message = "Maximum size for the Serie of ProductVariant is 50 characters")
    private String serie;

    @Column(length = 20)
    @Size(max = 20, message = "Maximum size for the Imei of ProductVariant is 20 characters")
    private String imei;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Product of ProductVariant cannot be null")
    private Product product;
}
