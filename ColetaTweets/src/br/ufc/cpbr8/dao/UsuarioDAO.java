package br.ufc.cpbr8.dao;

import java.util.List;
import br.ufc.cpbr8.model.Tweet;
import br.ufc.cpbr8.model.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario>{
	
	public boolean verificaUsuario(Usuario usuario);

}
