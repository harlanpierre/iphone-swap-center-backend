package br.com.hsiphones.iphoneswapcenterbackend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductSellerDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull(message = "ProductId of ProductSeller cannot be null")
    private UUID productId;

    @NotNull(message = "SellerId of ProductSeller cannot be null")
    private UUID sellerId;

    @NotNull(message = "Quantity of ProductSeller cannot be null")
    private Integer quantity;

    @NotNull(message = "Date Sale of ProductSeller cannot be null")
    private LocalDateTime dateSale;

}
