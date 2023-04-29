package br.com.sistemadecadastro.dao.impl;

import br.com.sistemadecadastro.dao.AbstractDao;
import br.com.sistemadecadastro.dao.IgrejaDao;
import br.com.sistemadecadastro.domain.Igreja;
import org.springframework.stereotype.Repository;

@Repository
public class IgrejaDaoImpl extends AbstractDao<Igreja, Long> implements IgrejaDao {

}
