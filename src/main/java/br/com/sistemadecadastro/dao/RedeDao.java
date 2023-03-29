package br.com.sistemadecadastro.dao;

import br.com.sistemadecadastro.domain.Ministerio;
import br.com.sistemadecadastro.domain.Rede;

import java.util.List;

public interface RedeDao{
        void save(Rede rede);

        void update(Rede rede);

        void delete(Long id);

        Rede findById(Long id);

        List<Rede> findAll();
}
