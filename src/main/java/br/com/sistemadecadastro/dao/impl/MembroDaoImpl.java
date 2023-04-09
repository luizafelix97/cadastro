package br.com.sistemadecadastro.dao.impl;

import java.time.LocalDate;
import java.util.List;

import br.com.sistemadecadastro.dao.AbstractDao;
import br.com.sistemadecadastro.dao.MembroDao;
import br.com.sistemadecadastro.domain.Membros;
import org.springframework.stereotype.Repository;



@Repository
public class MembroDaoImpl extends AbstractDao<Membros, Long> implements MembroDao {

	public List<Membros> findByNome(String nome) {
		
		return createQuery("select f from Membro f where f.nome like concat('%',?1,'%') ", nome);
	}

	@Override
	public List<Membros> findByCargoId(Long id) {
		
		return createQuery("select f from Membro f where f.cargo.id = ?1", id);
	}

	@Override
	public List<Membros> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida) {
		String jpql = new StringBuilder("select f from Membro f ")
				.append("where f.dataEntrada >= ?1 and f.dataSaida <= ?2 ")
				.append("order by f.dataEntrada asc")
				.toString();
		return createQuery(jpql, entrada, saida);
	}

	@Override
	public List<Membros> findByDataEntrada(LocalDate entrada) {
		String jpql = new StringBuilder("select f from Membro f ")
				.append("where f.dataEntrada = ?1 ")
				.append("order by f.dataEntrada asc")
				.toString();
		return createQuery(jpql, entrada);
	}

	@Override
	public List<Membros> findByDataSaida(LocalDate saida) {
		String jpql = new StringBuilder("select f from Membro f ")
				.append("where f.dataSaida = ?1 ")
				.append("order by f.dataEntrada asc")
				.toString();
		return createQuery(jpql, saida);
	}	
	
}
