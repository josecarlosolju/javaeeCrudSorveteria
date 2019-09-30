package sorveteria.bll.interfaces;

import java.util.List;	

import sorveteria.dal.entidade.Sabor;
import sorveteria.bll.util.Mensagem;

public interface ISaborEJB {

	public Mensagem salvar(Sabor sabor);
	public Mensagem excluir(Short idSabor);
	public List<Sabor> listar();
	
}
