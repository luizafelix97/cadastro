package br.com.sistemadecadastro.dao;

import br.com.sistemadecadastro.domain.Igreja;

import java.util.List;

public interface IgrejaDao {
    void save(Igreja igreja);

    void update(Igreja igreja);

    void delete(Long id);

    Igreja findById(Long id);

    List<Igreja> findAll();
}
