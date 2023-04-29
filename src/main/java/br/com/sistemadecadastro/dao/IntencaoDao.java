package br.com.sistemadecadastro.dao;

import br.com.sistemadecadastro.domain.Intencao;

import java.util.List;

public interface IntencaoDao {
	void save(Intencao intencao);

    void update(Intencao intencao);

    void delete(Long id);

    Intencao findById(Long id);

    List<Intencao> findAll();

}
