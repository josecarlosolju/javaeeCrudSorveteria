package sorveteria.bll.interfaces;

import java.util.List;	

import sorveteria.dal.entidade.Marca;
import sorveteria.bll.util.Mensagem;

public interface IMarcaEJB {

	public Mensagem salvar(Marca marca);
	public Mensagem excluir(Short idMarca);
	public List<Marca> listar();
	
}
