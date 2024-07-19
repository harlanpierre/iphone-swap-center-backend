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
@Table(name = "client")
public class Client implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @Column(nullable = false, length = 255)
    @Size(min = 1, max = 255, message = "Name length must be a maximum of 50 characters")
    @NotBlank(message = "Name of Client cannot be null")
    private String name;

    @Column(name = "cpf_cnpj", nullable = false, length = 30)
    @Size(max = 30, message = "CPF/CNPJ length must be a maximum of 30 characters")
    @NotBlank(message = "CPF/CNPJ of Client cannot be null")
    private String cpfCnpj;

    @Column(length = 15, nullable = false)
    @Size(max = 15, message = "Phone length must be a maximum of 15 characters")
    @NotBlank(message = "Phone of Client cannot be null")
    private String phone;

    @Column(length = 100)
    @Size(max = 100, message = "Email length must be a maximum of 100 characters")
    @NotBlank(message = "E-mail of Client cannot be null")
    private String email;

    @Column(name = "create_at", nullable = false)
    @NotNull(message = "CreateAt of Client cannot be null")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "User cannot be null")
    private User user;

    @ManyToOne
    @JoinColumn(name = "user_update_id", referencedColumnName = "id")
    private User userUpdate;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @NotNull(message = "Address cannot be null")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    @NotNull(message = "Company cannot be null")
    private Company company;
}
