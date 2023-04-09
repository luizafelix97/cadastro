package br.com.sistemadecadastro.service;

import br.com.sistemadecadastro.domain.Membros;

import java.time.LocalDate;
import java.util.List;



public interface MembroService {

    void salvar(Membros membros);

    void editar(Membros membros);

    void excluir(Long id);

    Membros buscarPorId(Long id);

    List<Membros> buscarTodos();

	List<Membros> buscarPorNome(String nome);

	List<Membros> buscarPorCargo(Long id);
	
	List<Membros> buscarPorDatas(LocalDate entrada, LocalDate saida);
}
