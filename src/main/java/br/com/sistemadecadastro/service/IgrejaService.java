package br.com.sistemadecadastro.service;

import br.com.sistemadecadastro.domain.Igreja;
import br.com.sistemadecadastro.domain.Ministerio;

import java.util.List;

public interface IgrejaService {
    void salvar(Igreja igreja);

    void editar(Igreja igreja);

    void excluir(Long id);

    Igreja buscarPorId(Long id);

    List<Igreja> buscarTodos();
}
