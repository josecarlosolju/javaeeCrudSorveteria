package sorveteria.bll;

import java.util.List;	

import javax.ejb.Stateless;
import javax.inject.Inject;

import sorveteria.dal.dao.interfaces.ICaldaDAO;
import sorveteria.dal.entidade.Calda;
import sorveteria.bll.interfaces.ICaldaEJB;
import sorveteria.bll.util.Mensagem;
import sorveteria.bll.util.TipoMensagem;

@Stateless
public class CaldaEJB implements ICaldaEJB{

	@Inject
	private ICaldaDAO caldaDAO;
	
	@Override
	public Mensagem salvar(Calda calda) {
		
		try {
			
			caldaDAO.insertOrUpdate(calda);
			
			return new Mensagem("Salvo com sucesso.",
					TipoMensagem.sucesso);
			
		}catch(Exception ex) {
			
			return new Mensagem("Erro inesperado: " 
					+ ex.getMessage(), TipoMensagem.erro);
			
		}
	}

	@Override
	public Mensagem excluir(Short idCalda) {
		
		try {
			
			Calda calda = caldaDAO.findById(idCalda);
			
			if(calda == null) {
				throw new Exception("Calda já foi excluída.");
			}
			
			if(calda.getProdutos().size() > 0) {
				throw new Exception("Essa calda possui produtos vinculados");
			}
			
			caldaDAO.delete(calda);
			
			return new Mensagem("Calda excluída.", TipoMensagem.sucesso);
		}catch(Exception ex) {
			return new Mensagem("Erro inesperado: "
					+ ex.getMessage(), TipoMensagem.erro);
		}
		
	}

	@Override
	public List<Calda> listar() {
		return caldaDAO.findAll();
	}

}
