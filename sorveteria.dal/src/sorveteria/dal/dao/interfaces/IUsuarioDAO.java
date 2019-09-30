package sorveteria.dal.dao.interfaces;

import sorveteria.dal.entidade.*;
import sorveteria.dal.generics.IGenericDAO;

public interface IUsuarioDAO 
	extends IGenericDAO<Usuario, Integer> {

	
	public Usuario porLoginSenha(String login, String senha);
	
}
