	package br.com.sistemadecadastro.domain;

	import java.time.LocalDate;

	import javax.persistence.*;
	import javax.validation.Valid;
	import javax.validation.constraints.*;

	import org.springframework.format.annotation.DateTimeFormat;
	import org.springframework.format.annotation.DateTimeFormat.ISO;

	@SuppressWarnings("serial")
	@Entity
	@Table(name = "FORNECEDORES")
	public class Fornecedor extends AbstractEntity<Long> {

		@NotBlank
		@Size(max = 255, min = 3)
		@Column(nullable = false, unique = true)
		private String nome;
		
				
		@NotNull
		@PastOrPresent(message = "{PastOrPresent.funcionario.dataEntrada}")
		@DateTimeFormat(iso = ISO.DATE, pattern = "")
		@Column(name= "data_entrada", nullable = false, columnDefinition = "DATE")
		private LocalDate dataEntrada;
		
		@DateTimeFormat(iso = ISO.DATE)
		@Column(name = "data_saida", columnDefinition = "DATE")
		private LocalDate dataSaida;
		
		@Valid
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "endereco_id_fk")
		private Endereco endereco;
		

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public LocalDate getDataEntrada() {
			return dataEntrada;
		}

		public void setDataEntrada(LocalDate dataEntrada) {
			this.dataEntrada = dataEntrada;
		}

		public LocalDate getDataSaida() {
			return dataSaida;
		}

		public void setDataSaida(LocalDate dataSaida) {
			this.dataSaida = dataSaida;
		}

		public Endereco getEndereco() {
			return endereco;
		}

		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}

	}


