package com.meli.obterdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter @Setter
public class SubjectDTO {

    @NotNull(message = "O nome do assunto não pode ficar vazio.")
    @Pattern(regexp = "[A-Z]\\w.+", message = "O nome do assunto deve começar com letra maiúscula.")
    @Size(max = 30, message = "O comprimento não pode exceder 30 caracteres.")
    String name;

    @NotNull(message = "A nota não pode estar vazia.")
    @Size(min = 0, max = 10, message = "A nota não pode ser inferior a 0 ou maior que 10")
    Double score;
}
