package com.dio.personapi.dto.put;

import com.dio.personapi.dto.post.PhonePostDTO;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
public class PersonPutDTO {

    private Long id;

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
    private List<PhonePostDTO> phones;
}
