package br.com.hsiphones.iphoneswapcenterbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class ClientDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id;

    @Size(min = 1, max = 255, message = "Name length must be a maximum of 50 characters")
    @NotBlank(message = "Name of Client cannot be null")
    private String name;

    @Size(max = 30, message = "CPF/CNPJ length must be a maximum of 30 characters")
    @NotBlank(message = "CPF/CNPJ of Client cannot be null")
    private String cpfCnpj;

    @Size(max = 15, message = "Phone length must be a maximum of 15 characters")
    @NotBlank(message = "Phone of Client cannot be null")
    private String phone;

    @Size(max = 100, message = "Email length must be a maximum of 100 characters")
    @NotBlank(message = "E-mail of Client cannot be null")
    private String email;

    @NotNull(message = "CreateAt of Client cannot be null")
    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    @NotNull(message = "User cannot be null")
    private UserDTO user;

    private UserDTO userUpdate;

    @NotNull(message = "Address cannot be null")
    private AddressDTO address;

    @NotNull(message = "Company cannot be null")
    private CompanyDTO company;
}
