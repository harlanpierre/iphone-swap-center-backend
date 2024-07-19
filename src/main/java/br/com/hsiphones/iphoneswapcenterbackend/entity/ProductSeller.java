package br.com.hsiphones.iphoneswapcenterbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "product_seller")
public class ProductSeller implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ProductSellerId id;

    @Column(nullable = false)
    @NotNull(message = "Quantity of ProductSeller cannot be null")
    private Integer quantity;

    @Column(name = "date_sale", nullable = false)
    @NotNull(message = "Date Sale of ProductSeller cannot be null")
    private LocalDateTime dateSale;

    @Embeddable
    @Getter
    @Setter
    public static class ProductSellerId implements Serializable {

        @Serial
        private static final long serialVersionUID = 2L;

        @Column(name = "product_id", nullable = false)
        @NotNull(message = "ProductId of ProductSeller cannot be null")
        private UUID productId;

        @Column(name = "seller_id", nullable = false)
        @NotNull(message = "SellerId of ProductSeller cannot be null")
        private UUID sellerId;

        public ProductSellerId() {
        }

        public ProductSellerId(UUID productId, UUID sellerId) {
            this.productId = productId;
            this.sellerId = sellerId;
        }
    }
}
