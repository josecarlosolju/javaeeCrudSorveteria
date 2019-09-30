package sorveteria.bll;

import java.util.List;	

import javax.ejb.Stateless;
import javax.inject.Inject;

import sorveteria.dal.dao.interfaces.ISaborDAO;
import sorveteria.dal.entidade.Sabor;
import sorveteria.bll.interfaces.ISaborEJB;
import sorveteria.bll.util.Mensagem;
import sorveteria.bll.util.TipoMensagem;;

@Stateless
public class SaborEJB implements ISaborEJB{

	@Inject
	private ISaborDAO saborDAO;
	
	@Override
	public Mensagem salvar(Sabor sabor) {
		
		try {
			
			saborDAO.insertOrUpdate(sabor);
			
			return new Mensagem("Salvo com sucesso.",
					TipoMensagem.sucesso);
			
		}catch(Exception ex) {
			
			return new Mensagem("Erro inesperado: " 
					+ ex.getMessage(), TipoMensagem.erro);
		}
	}

	@Override
	public Mensagem excluir(Short idSabor) {
		
		try {
			
			Sabor sabor = saborDAO.findById(idSabor);
			
			if(sabor == null) {
				throw new Exception("Sabor já foi excluída.");
			}
			
			if(sabor.getProdutos().size() > 0) {
				throw new Exception("Essa sabor possui produtos vinculados");
			}
			
			saborDAO.delete(sabor);
			
			return new Mensagem("Sabor Excluída.", TipoMensagem.sucesso);
		}catch(Exception ex) {
			return new Mensagem("Erro inesperado: "
					+ ex.getMessage(), TipoMensagem.erro);
		}
		
	}

	@Override
	public List<Sabor> listar() {
		return saborDAO.findAll();
	}

}
