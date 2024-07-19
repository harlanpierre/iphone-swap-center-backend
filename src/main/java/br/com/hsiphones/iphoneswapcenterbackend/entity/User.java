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
@Table(name = "user")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @Column(nullable = false, length = 255)
    @Size(max = 255, message = "Maximum size for the Name of User is 255 characters")
    @NotBlank(message = "Name of User cannot be null")
    private String name;

    @Column(name = "cpf_cnpj", nullable = false, length = 30)
    @Size(max = 30, message = "Maximum size for the Cpf/Cnpj of User is 30 characters")
    @NotBlank(message = "Cpf/Cnpj of User cannot be null")
    private String cpfCnpj;

    @Column(nullable = false)
    @NotNull(message = "Status of User cannot be null")
    private Boolean status;

    @Column(length = 15, nullable = false)
    @Size(max = 15, message = "Maximum size for the Phone of User is 15 characters")
    @NotBlank(message = "Phone of User cannot be null")
    private String phone;

    @Column(length = 100, nullable = false)
    @Size(max = 100, message = "Maximum size for the E-mail of User is 100 characters")
    @NotBlank(message = "E-mail of User cannot be null")
    private String email;

    @Column(name = "create_at", nullable = false)
    @NotNull(message = "CreateAt of User cannot be null")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Address of User cannot be null")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Company of User cannot be null")
    private Company company;
}
