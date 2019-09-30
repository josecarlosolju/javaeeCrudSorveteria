package sorveteria.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import sorveteria.bll.interfaces.ICaldaEJB;
import sorveteria.bll.util.Mensagem;
import sorveteria.bll.util.TipoMensagem;
import sorveteria.dal.entidade.Calda;

@Named
@RequestScoped
public class CaldaController {

	private Calda calda;
	
	@EJB
	private ICaldaEJB caldaEJB;
	
	@Inject
	private FacesContext context;
	
	public CaldaController() {
		this.calda = new Calda();
	}
	
	public void salvar() {
		
		Mensagem msg = caldaEJB.salvar(calda);
		
		if(msg.getTipo() == TipoMensagem.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(),null) );
			
			this.calda = new Calda();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(),null) );
		}
		
	}

	public List<Calda> todos(){
		return caldaEJB.listar();
	}
	
	public void editar(Calda calda) {
		this.calda = calda;
	}
	
	
	public void excluir(Short idCalda) {
		
		Mensagem msg = caldaEJB.excluir(idCalda);
		
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

	
	
	
	public Calda getCalda() {
		return calda;
	}

	public void setCalda(Calda calda) {
		this.calda = calda;
	}
	
	
	
}
