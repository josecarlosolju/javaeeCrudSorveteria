package sorveteria.dal.dao;


import javax.enterprise.context.RequestScoped;

import sorveteria.dal.dao.interfaces.IMarcaDAO;
import sorveteria.dal.entidade.Marca;
import sorveteria.dal.generics.JPAGenericDAO;

@RequestScoped
public class MarcaDAO 
	extends JPAGenericDAO<Marca, Short>
	implements IMarcaDAO{


	
}
