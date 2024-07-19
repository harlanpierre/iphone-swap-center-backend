package br.com.hsiphones.iphoneswapcenterbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "seller")
public class Seller implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @Column(name = "value_liquid", nullable = false, precision = 12, scale = 2)
    @Digits(integer = 12, fraction = 2, message = "Maximum digits for the Value Liquid is 12 characters")
    @NotNull(message = "Value Liquid of Seller cannot be null")
    private BigDecimal valueLiquid;

    @Column(name = "value_gross", nullable = false, precision = 12, scale = 2)
    @Digits(integer = 12, fraction = 2, message = "Maximum digits for the Value Gross is 12 characters")
    @NotNull(message = "Value Gross of Seller cannot be null")
    private BigDecimal valueGross;

    @Column(precision = 12, scale = 2)
    @Digits(integer = 12, fraction = 2, message = "Maximum digits for the Discount is 12 characters")
    private BigDecimal discount;

    @Column(name = "percent_disc", precision = 12, scale = 2)
    @Digits(integer = 12, fraction = 2, message = "Maximum digits for the Percent Disc is 12 characters")
    private BigDecimal percentDisc;

    @Column(name = "create_at", nullable = false)
    @NotNull(message = "CreateAt of Seller cannot be null")
    private LocalDateTime createAt;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "User of Seller cannot be null")
    private User user;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Client of Seller cannot be null")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Company of Seller cannot be null")
    private Company company;
}
