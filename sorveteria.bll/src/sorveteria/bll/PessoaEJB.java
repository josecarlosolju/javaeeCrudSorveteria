package sorveteria.bll;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import sorveteria.bll.interfaces.IPessoaEJB;
import sorveteria.dal.dao.interfaces.IPessoaDAO;
import sorveteria.dal.entidade.Pessoa;

@Stateless
public class PessoaEJB implements IPessoaEJB{

	@Inject
	private IPessoaDAO pessoaDAO;
	
	@Override
	public List<Pessoa> listar() {
		return pessoaDAO.findAll();
	}

}
