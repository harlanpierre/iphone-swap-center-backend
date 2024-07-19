package br.com.hsiphones.iphoneswapcenterbackend.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "company")
public class Company implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @Column(nullable = false, length = 255)
    @Size(max = 255, message = "Maximum size for the Name of Company is 255 characters")
    @NotBlank(message = "Name of Company cannot be null")
    private String name;

    @Column(name = "cpf_cnpj", nullable = false, length = 30)
    @Size(max = 30, message = "Maximum size for the CPF/CNPJ of Company is 30 characters")
    @NotBlank(message = "CPF/CNPJ of Company cannot be null")
    private String cpfCnpj;

    @Column(length = 15, nullable = false)
    @Size(max = 15, message = "Maximum size for the Phone of Company is 15 characters")
    @NotBlank(message = "Phone of Company cannot be null")
    private String phone;

    @Column(length = 100, nullable = false)
    @Size(max = 100, message = "Maximum size for the E-mail of Company is 100 characters")
    @NotBlank(message = "E-mail of Company cannot be null")
    private String email;

    @Column(name = "create_at", nullable = false)
    @NotNull(message = "CreateAt of Company cannot be null")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Address of Company cannot be null")
    private Address address;

}
