package sorveteria.dal.dao;

import javax.enterprise.context.RequestScoped;	

import sorveteria.dal.dao.interfaces.IPessoaDAO;
import sorveteria.dal.entidade.Pessoa;
import sorveteria.dal.generics.JPAGenericDAO;

@RequestScoped
public class PessoaDAO 
	extends JPAGenericDAO<Pessoa, Integer>
	implements IPessoaDAO{


	
}