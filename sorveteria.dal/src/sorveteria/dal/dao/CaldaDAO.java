package sorveteria.dal.dao;


import javax.enterprise.context.RequestScoped;

import sorveteria.dal.dao.interfaces.ICaldaDAO;
import sorveteria.dal.entidade.Calda;
import sorveteria.dal.generics.JPAGenericDAO;

@RequestScoped
public class CaldaDAO 
	extends JPAGenericDAO<Calda, Short>
	implements ICaldaDAO{


	
}
