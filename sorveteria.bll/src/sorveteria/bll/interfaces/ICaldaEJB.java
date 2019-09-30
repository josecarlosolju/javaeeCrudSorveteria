package sorveteria.bll.interfaces;

import java.util.List;		

import sorveteria.dal.entidade.Calda;
import sorveteria.bll.util.Mensagem;

public interface ICaldaEJB {

	public Mensagem salvar(Calda calda);
	public Mensagem excluir(Short idCalda);
	public List<Calda> listar();
	
}
