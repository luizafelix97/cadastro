package br.com.sistemadecadastro.service;

import br.com.sistemadecadastro.domain.Ministerio;
import br.com.sistemadecadastro.domain.Rede;

import java.util.List;

public interface RedeService {
    void salvar(Rede rede);

    void editar(Rede rede);

    void excluir(Long id);

    Rede buscarPorId(Long id);

    List<Rede> buscarTodos();

    boolean redeTemCargos(Long id);
}
