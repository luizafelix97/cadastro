	package br.com.sistemadecadastro.domain;

	import javax.persistence.*;
	import javax.validation.constraints.*;

	@SuppressWarnings("serial")
	@Entity
	@Table(name = "INTENCOES")
	public class Intencao extends AbstractEntity<Long> {

		@NotBlank
		@Size(max = 255, min = 3)
		@Column(nullable = false, unique = true)
		private String nome;


		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

	}


