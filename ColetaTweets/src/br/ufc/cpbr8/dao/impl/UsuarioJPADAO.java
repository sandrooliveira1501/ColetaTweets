package br.ufc.cpbr8.dao.impl;

import java.util.List;

import br.ufc.cpbr8.dao.UsuarioDAO;
import br.ufc.cpbr8.model.Tweet;
import br.ufc.cpbr8.model.Usuario;

public class UsuarioJPADAO extends GenericJPADAO<Usuario> implements UsuarioDAO{

	public UsuarioJPADAO() {
		super();
		this.persistentClass = Usuario.class;
	}

	@Override
	public boolean verificaUsuario(Usuario usuario) {
		try{
			Usuario usuarioVerificado = em.find(Usuario.class, usuario.getId());
			if(usuarioVerificado != null)
				return true;
		}catch(Exception e){
			return false;
		}
		
		return false;
	}
	


}
