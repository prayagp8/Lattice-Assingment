package com.la.modal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Patient {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "name should not be null")
    private String name;

    @NotNull
    @Size(min = 10,message = "address should be at least 10 characters")
    private String address;

    @NotNull
    @Email(message = "Email must be valid")
    private String email;

    @NotNull
    @Size(min = 10,message = "minimum phone number digit should be 10")
    private String phoneNumber;

    @NotNull
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,15}$",message = "password must contain one upper character, one lower character and a number. Max length 15 and min length 8")
    private String password;

    @NotNull(message = "Patient photo must not be null")
    private String patientPhoto;

    @ManyToOne
    @JsonIgnore
    private Psychiatrist psychiatrist;
}
