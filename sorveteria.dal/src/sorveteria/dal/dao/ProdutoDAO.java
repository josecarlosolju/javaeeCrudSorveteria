package sorveteria.dal.dao;


import javax.enterprise.context.RequestScoped;

import sorveteria.dal.dao.interfaces.IProdutoDAO;
import sorveteria.dal.entidade.Produto;
import sorveteria.dal.generics.JPAGenericDAO;

@RequestScoped
public class ProdutoDAO 
	extends JPAGenericDAO<Produto, Integer>
	implements IProdutoDAO{


	
}
