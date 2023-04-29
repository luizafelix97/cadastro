package br.com.sistemadecadastro.service.impl;

import br.com.sistemadecadastro.dao.IgrejaDao;
import br.com.sistemadecadastro.domain.Igreja;
import br.com.sistemadecadastro.domain.Ministerio;
import br.com.sistemadecadastro.service.IgrejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IgrejaServiceImpl implements IgrejaService {

    @Autowired
    private IgrejaDao dao;

    @Transactional(readOnly = false)
    @Override
    public void salvar(Igreja igreja) {
        dao.save(igreja);
    }

    @Transactional(readOnly = false)
    @Override
    public void editar(Igreja igreja) {
        dao.update(igreja);
    }

    @Transactional(readOnly = false)
    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Igreja buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Igreja> buscarTodos() {
        return dao.findAll();
    }
}
