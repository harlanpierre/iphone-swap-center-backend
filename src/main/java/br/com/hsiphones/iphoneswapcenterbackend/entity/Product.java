package br.com.hsiphones.iphoneswapcenterbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @Column(nullable = false, length = 255)
    @Size(max = 255, message = "Maximum size for the Name of Product is 255 characters")
    @NotBlank(message = "Name of Product cannot be null")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Stock of Product cannot be null")
    private Integer stock;

    @Column(nullable = false)
    @Digits(integer = 12, fraction = 2, message = "Maximum digits for the Unit Price is 12 characters")
    @NotNull(message = "Price Unit of Product cannot be null")
    private BigDecimal priceUnit;

    @Column(length = 255)
    @Size(max = 255, message = "Maximum size for the Description of Product is 255 characters")
    @NotBlank(message = "Description of Product cannot be null")
    private String description;

    @Column(nullable = false)
    @NotNull(message = "Status of Product cannot be null")
    private Boolean status;

    @Column(length = 50)
    @Size(max = 50, message = "Maximum size for the Brand of Product is 50 characters")
    private String brand;

    @Column(name = "create_at", nullable = false)
    @NotNull(message = "CreateAt of Product cannot be null")
    private LocalDateTime createAt;

    @Column(name = "update_ate")
    private LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "User of Product cannot be null")
    private User user;

    @ManyToOne
    @JoinColumn(name = "user_update_id", referencedColumnName = "id")
    private User userUpdate;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Company of Product cannot be null")
    private Company company;
}
