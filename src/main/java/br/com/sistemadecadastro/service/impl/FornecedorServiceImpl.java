package br.com.sistemadecadastro.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sistemadecadastro.dao.FornecedorDao;
import br.com.sistemadecadastro.domain.Fornecedor;
import br.com.sistemadecadastro.service.FornecedorService;

@Service
@Transactional(readOnly = true)
public class FornecedorServiceImpl implements FornecedorService{

	@Autowired
	private FornecedorDao dao;
	
	@Transactional(readOnly = false)
	@Override
	public void salvar(Fornecedor fornecedor) {
		dao.save(fornecedor);
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Fornecedor fornecedor) {
		dao.update(fornecedor);
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	public Fornecedor buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Override
	public List<Fornecedor> buscarTodos() {
		
		return dao.findAll();
	}

	@Override
	public List<Fornecedor> buscarPorNome(String nome) {
		
		return dao.findByNome(nome);
	}

	
	@Override
    public List<Fornecedor> buscarPorDatas(LocalDate entrada, LocalDate saida) {
	    if (entrada != null && saida != null) {	    	
            return dao.findByDataEntradaDataSaida(entrada, saida);
        } else if (entrada != null) {        	
	        return dao.findByDataEntrada(entrada);
        } else if (saida != null) {        	
	        return dao.findByDataSaida(saida);
        } else {
        	return new ArrayList<>();
        }
    }

}

