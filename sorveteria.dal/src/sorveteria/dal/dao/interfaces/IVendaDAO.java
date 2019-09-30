package sorveteria.dal.dao.interfaces;

import java.util.Date;	
import java.util.List;

import sorveteria.dal.entidade.Venda;
import sorveteria.dal.generics.IGenericDAO;

public interface IVendaDAO 
	extends IGenericDAO<Venda,Integer>{
	
	List<Venda> listar(Date data);
	List<?> listar(int ano);

}
