package sorveteria.dal.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.TypedQuery;

import sorveteria.dal.dao.interfaces.IFornecedorDAO;
import sorveteria.dal.entidade.Fornecedor;
import sorveteria.dal.generics.JPAGenericDAO;

@RequestScoped
public class FornecedorDAO
		extends JPAGenericDAO<Fornecedor, Short>
		implements IFornecedorDAO {

	@Override
	public List<Fornecedor> findByFornecedor(String nomeFornecedor) {
		
		TypedQuery<Fornecedor> query =
					em.createQuery("select f from Fornecedor as f where f.marca.descricao = :nomeFornecedor order by f.marca.descricao",Fornecedor.class);
		
		query.setParameter("nomeFornecedor", nomeFornecedor);
		
		return query.getResultList();
	}

	
}
