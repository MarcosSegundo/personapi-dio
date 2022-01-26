package com.dio.personapi.dto.request;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
public class PersonDTO {

    @NotEmpty
    @Size(min = 2, max = 55)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 55)
    private String lastName;

    @NotEmpty
    @CPF
    private String cpf;

    private String birthDate;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;
}
