package br.com.sistemadecadastro.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemadecadastro.domain.Intencao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sistemadecadastro.dao.IntencaoDao;
import br.com.sistemadecadastro.service.IntencaoService;

@Service
@Transactional(readOnly = true)
public class IntencaoServiceImpl implements IntencaoService {

	@Autowired
	private IntencaoDao dao;
	
	@Transactional(readOnly = false)
	@Override
	public void salvar(Intencao intencao) {
		dao.save(intencao);
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Intencao intencao) {
		dao.update(intencao);
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	public Intencao buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Override
	public List<Intencao> buscarTodos() {
		
		return dao.findAll();
	}


}

