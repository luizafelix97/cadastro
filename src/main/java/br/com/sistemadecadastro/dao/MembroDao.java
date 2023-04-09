package br.com.sistemadecadastro.dao;

import br.com.sistemadecadastro.domain.Membros;

import java.time.LocalDate;
import java.util.List;


public interface MembroDao {
    
	void save(Membros membros);

    void update(Membros membros);

    void delete(Long id);

    Membros findById(Long id);

    List<Membros> findAll();
    
    List<Membros> findByNome(String nome);

	List<Membros> findByCargoId(Long id);

	List<Membros> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida);

	List<Membros> findByDataEntrada(LocalDate entrada);

	List<Membros> findByDataSaida(LocalDate saida);
}
