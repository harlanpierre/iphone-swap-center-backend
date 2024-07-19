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
public class CompanyDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id;

    @Size(max = 255, message = "Maximum size for the Name of Company is 255 characters")
    @NotBlank(message = "Name of Company cannot be null")
    private String name;

    @Size(max = 30, message = "Maximum size for the CPF/CNPJ of Company is 30 characters")
    @NotBlank(message = "CPF/CNPJ of Company cannot be null")
    private String cpfCnpj;

    @Size(max = 15, message = "Maximum size for the Phone of Company is 15 characters")
    @NotBlank(message = "Phone of Company cannot be null")
    private String phone;

    @Size(max = 100, message = "Maximum size for the E-mail of Company is 100 characters")
    @NotBlank(message = "E-mail of Company cannot be null")
    private String email;

    @NotNull(message = "CreateAt of Company cannot be null")
    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    @NotNull(message = "Address of Company cannot be null")
    private AddressDTO address;

}
