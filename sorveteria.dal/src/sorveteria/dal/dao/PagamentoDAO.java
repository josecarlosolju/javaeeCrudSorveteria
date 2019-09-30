package sorveteria.dal.dao;

import javax.enterprise.context.RequestScoped;	

import sorveteria.dal.dao.interfaces.IPagamentoDAO;
import sorveteria.dal.entidade.MetodoPagamento;
import sorveteria.dal.generics.JPAGenericDAO;

@RequestScoped
public class PagamentoDAO extends JPAGenericDAO<MetodoPagamento, Short>
implements IPagamentoDAO{

}
