package br.ufc.cpbr8.dao.impl;

import br.ufc.cpbr8.dao.BuscaDAO;
import br.ufc.cpbr8.model.Busca;

public class BuscaJPADAO extends GenericJPADAO<Busca> implements BuscaDAO{

	public BuscaJPADAO() {
		super();
		this.persistentClass = Busca.class;
	}
	
}
