package br.com.sistemadecadastro.dao.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.sistemadecadastro.dao.AbstractDao;
import br.com.sistemadecadastro.dao.FornecedorDao;

import br.com.sistemadecadastro.domain.Fornecedor;


@Repository
public class FornecedorDaoImpl  extends AbstractDao<Fornecedor, Long> implements FornecedorDao {

public List<Fornecedor> findByNome(String nome) {
		
		return createQuery("select f from Fornecedor f where f.nome like concat('%',?1,'%') ", nome);
	}


	@Override
	public List<Fornecedor> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida) {
		String jpql = new StringBuilder("select f from Fornecedor f ")
				.append("where f.dataEntrada >= ?1 and f.dataSaida <= ?2 ")
				.append("order by f.dataEntrada asc")
				.toString();
		return createQuery(jpql, entrada, saida);
	}

	@Override
	public List<Fornecedor> findByDataEntrada(LocalDate entrada) {
		String jpql = new StringBuilder("select f from Fornecedor f ")
				.append("where f.dataEntrada = ?1 ")
				.append("order by f.dataEntrada asc")
				.toString();
		return createQuery(jpql, entrada);
	}

	@Override
	public List<Fornecedor> findByDataSaida(LocalDate saida) {
		String jpql = new StringBuilder("select f from Fornecedor f ")
				.append("where f.dataSaida = ?1 ")
				.append("order by f.dataEntrada asc")
				.toString();
		return createQuery(jpql, saida);
	}

}
