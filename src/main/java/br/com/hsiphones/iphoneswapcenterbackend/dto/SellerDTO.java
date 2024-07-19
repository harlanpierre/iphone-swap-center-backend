package br.com.hsiphones.iphoneswapcenterbackend.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class SellerDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id;

    @Digits(integer = 12, fraction = 2, message = "Maximum digits for the Value Liquid is 12 characters")
    @NotNull(message = "Value Liquid of Seller cannot be null")
    private BigDecimal valueLiquid;

    @Digits(integer = 12, fraction = 2, message = "Maximum digits for the Value Gross is 12 characters")
    @NotNull(message = "Value Gross of Seller cannot be null")
    private BigDecimal valueGross;

    @Digits(integer = 12, fraction = 2, message = "Maximum digits for the Discount is 12 characters")
    private BigDecimal discount;

    @Digits(integer = 12, fraction = 2, message = "Maximum digits for the Percent Disc is 12 characters")
    private BigDecimal percentDisc;

    @NotNull(message = "CreateAt of Seller cannot be null")
    private LocalDateTime createAt;

    @NotNull(message = "User of Seller cannot be null")
    private UserDTO user;

    @NotNull(message = "Client of Seller cannot be null")
    private ClientDTO client;

    @NotNull(message = "Company of Seller cannot be null")
    private CompanyDTO company;
}
