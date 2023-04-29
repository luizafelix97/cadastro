package br.com.sistemadecadastro.service;

import java.util.List;

import br.com.sistemadecadastro.domain.Intencao;


public interface IntencaoService {

    void salvar(Intencao intencao);

    void editar(Intencao intencao);

    void excluir(Long id);

    Intencao buscarPorId(Long id);

    List<Intencao> buscarTodos();

}

