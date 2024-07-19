package br.com.hsiphones.iphoneswapcenterbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id;

    @Size(max = 255, message = "Maximum size for the Name of User is 255 characters")
    @NotBlank(message = "Name of User cannot be null")
    private String name;

    @Size(max = 30, message = "Maximum size for the Cpf/Cnpj of User is 30 characters")
    @NotBlank(message = "Cpf/Cnpj of User cannot be null")
    private String cpfCnpj;

    @NotNull(message = "Status of User cannot be null")
    private Boolean status;

    @Size(max = 15, message = "Maximum size for the Phone of User is 15 characters")
    @NotBlank(message = "Phone of User cannot be null")
    private String phone;

    @Size(max = 100, message = "Maximum size for the E-mail of User is 100 characters")
    @NotBlank(message = "E-mail of User cannot be null")
    private String email;

    @NotNull(message = "CreateAt of User cannot be null")
    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    @NotNull(message = "Address of User cannot be null")
    private AddressDTO address;

    @NotNull(message = "Company of User cannot be null")
    private CompanyDTO company;
}
