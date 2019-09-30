package sorveteria.bll.interfaces;

import java.util.List;
import sorveteria.dal.entidade.Pessoa;

public interface IPessoaEJB {
	public List<Pessoa> listar();
}
