package sorveteria.dal.dao;

import java.util.Date;	
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import sorveteria.dal.dao.interfaces.IVendaDAO;
import sorveteria.dal.entidade.Venda;
import sorveteria.dal.generics.JPAGenericDAO;

@RequestScoped
public class VendaDAO extends JPAGenericDAO<Venda, Integer>
	implements IVendaDAO{


    public List<Venda> listar(Date data) {
        TypedQuery<Venda> query = em.createQuery("select v from Venda v where v.data = :data", Venda.class);
        query.setParameter("data", data, TemporalType.DATE);
        List<Venda> vendas = query.getResultList();
        return vendas;
    }
    
    public List<?> listar(int ano) {

        Query query = super.em.createQuery("select EXTRACT(MONTH from v.venda.data) as y,SUM(v.preco) from VendaProduto v "
                + "where EXTRACT(YEAR from v.venda.data) =:ano group by y");

        query.setParameter("ano", ano);

 

        return query.getResultList();
    }

}
