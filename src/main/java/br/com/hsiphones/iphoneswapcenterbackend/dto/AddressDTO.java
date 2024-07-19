package br.com.hsiphones.iphoneswapcenterbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id;

    @Size(max = 10, message = "Maximum size for the Cep of Address is 10 characters")
    @NotBlank(message = "Cep of Address cannot be null")
    private String cep;

    @Size(max = 100, message = "Address length must be a maximum of 100 characters")
    private String address;

    @Size(max = 50, message = "City length must be a maximum of 50 characters")
    private String city;

    @Size(max = 2, message = "State length must be a maximum of 2 characters")
    private String state;

    @Size(max = 50, message = "District length must be a maximum of 50 characters")
    private String district;
}
