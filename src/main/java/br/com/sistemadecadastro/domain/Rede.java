package br.com.sistemadecadastro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "REDE")
public class Rede extends AbstractEntity<Long> {

    @NotBlank(message = "Informe um nome.")
    @Size(min = 3, max = 60, message = "O nome da rede deve ter entre {min} e {max} caracteres.")
    @Column(name = "nome", nullable = false, unique = true, length = 60)
    private String nome;

    public String getNome() {
        return nome;
    }

}
