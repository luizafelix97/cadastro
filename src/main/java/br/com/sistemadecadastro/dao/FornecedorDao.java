package br.com.sistemadecadastro.dao;

import java.time.LocalDate;
import java.util.List;

import br.com.sistemadecadastro.domain.Fornecedor;
import java.time.LocalDate;
import java.util.List;

public interface FornecedorDao {
	void save(Fornecedor fornecedor);

    void update(Fornecedor fornecedor);

    void delete(Long id);

    Fornecedor findById(Long id);

    List<Fornecedor> findAll();
    
    List<Fornecedor> findByNome(String nome);

	List<Fornecedor> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida);

	List<Fornecedor> findByDataEntrada(LocalDate entrada);

	List<Fornecedor> findByDataSaida(LocalDate saida);

}
