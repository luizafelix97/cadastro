package br.com.sistemadecadastro.dao.impl;

import java.time.LocalDate;
import java.util.List;

import br.com.sistemadecadastro.domain.Intencao;
import org.springframework.stereotype.Repository;

import br.com.sistemadecadastro.dao.AbstractDao;
import br.com.sistemadecadastro.dao.IntencaoDao;


@Repository
public class IntencaoDaoImpl extends AbstractDao<Intencao, Long> implements IntencaoDao {

}
