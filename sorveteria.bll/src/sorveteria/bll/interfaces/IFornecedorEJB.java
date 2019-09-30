package sorveteria.bll.interfaces;

import java.util.List;	

import sorveteria.dal.entidade.Fornecedor;
import sorveteria.bll.util.Mensagem;

public interface IFornecedorEJB {

	public Mensagem salvar(Fornecedor fornecedor);
	public Mensagem excluir(Short idFornecedor);
	public List<Fornecedor> listar();
}
