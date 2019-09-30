package sorveteria.bll.interfaces;

import java.util.List;

import sorveteria.dal.entidade.Produto;
import sorveteria.bll.util.Mensagem;

public interface IProdutoEJB {

	public Mensagem salvar(Produto produto);
	public Mensagem excluir(Integer idProduto);
	public List<Produto> listar();
	public Produto obter(Integer idProduto);
	
}
