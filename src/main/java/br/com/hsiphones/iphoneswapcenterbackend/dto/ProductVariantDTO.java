package br.com.hsiphones.iphoneswapcenterbackend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductVariantDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id;

    @Size(max = 20, message = "Maximum size for the Color of ProductVariant is 20 characters")
    private String color;

    @Size(max = 50, message = "Maximum size for the Serie of ProductVariant is 50 characters")
    private String serie;

    @Size(max = 20, message = "Maximum size for the Imei of ProductVariant is 20 characters")
    private String imei;

    @NotNull(message = "Product of ProductVariant cannot be null")
    private ProductDTO product;
}
