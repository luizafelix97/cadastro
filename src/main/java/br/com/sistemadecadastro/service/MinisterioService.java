package br.com.sistemadecadastro.service;

import br.com.sistemadecadastro.domain.Ministerio;

import java.util.List;



public interface MinisterioService {

    void salvar(Ministerio ministerio);

    void editar(Ministerio ministerio);

    void excluir(Long id);

    Ministerio buscarPorId(Long id);
    
    List<Ministerio> buscarTodos();

	boolean ministerioTemCargos(Long id);
}
