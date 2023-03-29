package br.com.sistemadecadastro.service.impl;

import java.util.List;

import br.com.sistemadecadastro.dao.MinisterioDao;
import br.com.sistemadecadastro.domain.Ministerio;
import br.com.sistemadecadastro.service.MinisterioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class MinisterioServiceImpl implements MinisterioService {
	
	@Autowired
	private MinisterioDao dao;

	@Transactional(readOnly = false)
	@Override
	public void salvar(Ministerio ministerio) {
		dao.save(ministerio);
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Ministerio ministerio) {
		dao.update(ministerio);
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Transactional(readOnly = true)
	@Override
	public Ministerio buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Ministerio> buscarTodos() {
		
		return dao.findAll();
	}

	@Override
	public boolean departamentoTemCargos(Long id) {
		if (buscarPorId(id).getCargos().isEmpty()) {
			return false;
		}
		return true;
	}

}
