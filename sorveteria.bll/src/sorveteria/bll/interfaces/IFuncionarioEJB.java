package sorveteria.bll.interfaces;

import java.util.*;	
import sorveteria.dal.entidade.*;
import sorveteria.bll.util.*;


public interface IFuncionarioEJB {

	public Mensagem salvar(Funcionario funcionario);
	public Mensagem excluir(Integer idPessoa);
	public List<Funcionario> listar();
	
}
