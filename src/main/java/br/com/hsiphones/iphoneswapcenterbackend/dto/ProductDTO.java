package br.com.hsiphones.iphoneswapcenterbackend.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id;

    @Size(max = 255, message = "Maximum size for the Name of Product is 255 characters")
    @NotBlank(message = "Name of Product cannot be null")
    private String name;

    @NotNull(message = "Stock of Product cannot be null")
    private Integer stock;

    @Digits(integer = 12, fraction = 2, message = "Maximum digits for the Unit Price is 12 characters")
    @NotNull(message = "Price Unit of Product cannot be null")
    private BigDecimal priceUnit;

    @Size(max = 255, message = "Maximum size for the Description of Product is 255 characters")
    @NotBlank(message = "Description of Product cannot be null")
    private String description;

    @NotNull(message = "Status of Product cannot be null")
    private Boolean status;

    @Size(max = 50, message = "Maximum size for the Brand of Product is 50 characters")
    private String brand;

    @NotNull(message = "CreateAt of Product cannot be null")
    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    @NotNull(message = "User of Product cannot be null")
    private UserDTO user;

    private UserDTO userUpdate;

    @NotNull(message = "Company of Product cannot be null")
    private CompanyDTO company;
}
