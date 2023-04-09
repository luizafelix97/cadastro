package br.com.sistemadecadastro.service.impl;

import br.com.sistemadecadastro.dao.RedeDao;
import br.com.sistemadecadastro.domain.Rede;
import br.com.sistemadecadastro.service.RedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RedeServiceImpl implements RedeService {

    @Autowired
    RedeDao redeDao;
    @Transactional(readOnly = false)
    @Override
    public void salvar(Rede rede) {
        redeDao.save(rede);
    }

    @Override
    public void editar(Rede rede) {
        redeDao.update(rede);
    }

    @Override
    public void excluir(Long id) {
        redeDao.delete(id);
    }

    @Override
    public Rede buscarPorId(Long id) {
        return redeDao.findById(id);
    }

    @Override
    public List<Rede> buscarTodos() {
        return redeDao.findAll();
    }

    @Override
    public boolean redeTemCargos(Long id) {
        return false;
    }
}
