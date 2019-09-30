package sorveteria.controller;

import java.util.List;	

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import sorveteria.bll.interfaces.ISaborEJB;
import sorveteria.bll.util.Mensagem;
import sorveteria.bll.util.TipoMensagem;
import sorveteria.dal.entidade.Sabor;

@Named
@RequestScoped
public class SaborController {

	private Sabor sabor;
	
	@EJB
	private ISaborEJB saborEJB;
	
	@Inject
	private FacesContext context;
	
	public SaborController() {
		this.sabor = new Sabor();
	}
	
	public void salvar() {
		
		Mensagem msg = saborEJB.salvar(sabor);
		
		if(msg.getTipo() == TipoMensagem.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(),null) );
			
			this.sabor = new Sabor();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(),null) );
		}
		
	}

	public List<Sabor> todos(){
		return saborEJB.listar();
	}
	
	public void editar(Sabor sabor) {
		this.sabor = sabor;
	}
	
	
	public void excluir(Short idSabor) {
		
		Mensagem msg = saborEJB.excluir(idSabor);
		
		if(msg.getTipo() == TipoMensagem.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(),null) );
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(),null) );
		}
		
		
	}

	
	
	
	public Sabor getSabor() {
		return sabor;
	}

	public void setOpcional(Sabor sabor) {
		this.sabor = sabor;
	}
	
	
	
}
