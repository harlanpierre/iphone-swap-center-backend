package br.com.hsiphones.iphoneswapcenterbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "address")
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @Column(nullable = false)
    @Size(max = 10, message = "Maximum size for the Cep of Address is 10 characters")
    @NotBlank(message = "Cep of Address cannot be null")
    private String cep;

    @Column(length = 100)
    @Size(max = 100, message = "Address length must be a maximum of 100 characters")
    private String address;

    @Column(length = 50)
    @Size(max = 50, message = "City length must be a maximum of 50 characters")
    private String city;

    @Column(length = 2)
    @Size(max = 2, message = "State length must be a maximum of 2 characters")
    private String state;

    @Column(length = 50)
    @Size(max = 50, message = "District length must be a maximum of 50 characters")
    private String district;
}
