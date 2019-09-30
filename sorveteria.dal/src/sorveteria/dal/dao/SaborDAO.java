package sorveteria.dal.dao;

import javax.enterprise.context.RequestScoped;

import sorveteria.dal.dao.interfaces.ISaborDAO;
import sorveteria.dal.entidade.Sabor;
import sorveteria.dal.generics.JPAGenericDAO;

@RequestScoped
public class SaborDAO 
	extends JPAGenericDAO<Sabor, Short>
	implements ISaborDAO{


	
}
