package br.com.sistemadecadastro.service;

import java.time.LocalDate;
import java.util.List;

import br.com.sistemadecadastro.domain.Fornecedor;



public interface FornecedorService {

    void salvar(Fornecedor fornecedor);

    void editar(Fornecedor fornecedor);

    void excluir(Long id);

    Fornecedor buscarPorId(Long id);

    List<Fornecedor> buscarTodos();

	List<Fornecedor> buscarPorNome(String nome);

	List<Fornecedor> buscarPorDatas(LocalDate entrada, LocalDate saida);
}

