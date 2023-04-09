package br.com.sistemadecadastro.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemadecadastro.dao.MembroDao;
import br.com.sistemadecadastro.domain.Membros;
import br.com.sistemadecadastro.service.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional(readOnly = true)
public class MembroServiceImpl implements MembroService {
	
	@Autowired
	private MembroDao dao;

	@Transactional(readOnly = false)
	@Override
	public void salvar(Membros membros) {
		dao.save(membros);
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Membros membros) {
		dao.update(membros);
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	public Membros buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Override
	public List<Membros> buscarTodos() {
		
		return dao.findAll();
	}

	@Override
	public List<Membros> buscarPorNome(String nome) {
		
		return dao.findByNome(nome);
	}

	@Override
	public List<Membros> buscarPorCargo(Long id) {
		
		return dao.findByCargoId(id);
	}

	@Override
    public List<Membros> buscarPorDatas(LocalDate entrada, LocalDate saida) {
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
