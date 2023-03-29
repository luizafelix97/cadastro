package br.com.sistemadecadastro.dao;

import br.com.sistemadecadastro.domain.Ministerio;

import java.util.List;



public interface MinisterioDao {

    void save(Ministerio ministerio);

    void update(Ministerio ministerio);

    void delete(Long id);

    Ministerio findById(Long id);

    List<Ministerio> findAll();
}
