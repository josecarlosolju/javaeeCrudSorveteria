package sorveteria.bll;

import java.util.List;	

import javax.ejb.Stateless;
import javax.inject.Inject;

import sorveteria.dal.dao.interfaces.IMarcaDAO;
import sorveteria.dal.entidade.Marca;
import sorveteria.bll.interfaces.IMarcaEJB;
import sorveteria.bll.util.Mensagem;
import sorveteria.bll.util.TipoMensagem;

@Stateless
public class MarcaEJB implements IMarcaEJB{

	@Inject
	private IMarcaDAO marcaDAO;
	
	@Override
	public Mensagem salvar(Marca marca) {
		
		try {
			
			//abre a conexão
			marcaDAO.insertOrUpdate(marca);
			
			return new Mensagem("Salvo com sucesso.",
					TipoMensagem.sucesso);
			
		}catch(Exception ex) {
			
			return new Mensagem("Erro inesperado: " 
					+ ex.getMessage(), TipoMensagem.erro);
			
		}finally {
			//fecha a conexão
		}
	}

	@Override
	public Mensagem excluir(Short idMarca) {
		
		try {
			
			Marca marca = marcaDAO.findById(idMarca);
			
			if(marca == null) {
				throw new Exception("Marca já foi excluída.");
			}
			
			if(marca.getFornecedor().size() > 0) {
				throw new Exception("Essa marca possui fornecedores vinculados");
			}
			
			marcaDAO.delete(marca);
			
			return new Mensagem("Marca excluída.", TipoMensagem.sucesso);
		}catch(Exception ex) {
			return new Mensagem("Erro inesperado: "
					+ ex.getMessage(), TipoMensagem.erro);
		}
		
	}

	@Override
	public List<Marca> listar() {
		return marcaDAO.findAll();
	}

}
