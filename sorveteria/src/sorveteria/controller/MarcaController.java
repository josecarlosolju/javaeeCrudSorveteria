package sorveteria.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import sorveteria.bll.interfaces.IMarcaEJB;
import sorveteria.bll.util.Mensagem;
import sorveteria.bll.util.TipoMensagem;
import sorveteria.dal.entidade.Marca;

@Named
@RequestScoped
public class MarcaController {

	private Marca marca;
	
	@EJB
	private IMarcaEJB marcaEJB;
	
	@Inject
	private FacesContext context;
	
	public MarcaController() {
		this.marca = new Marca();
	}
	
	public void salvar() {
		
		Mensagem msg = marcaEJB.salvar(marca);
		
		if(msg.getTipo() == TipoMensagem.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(),null) );
			
			this.marca = new Marca();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(),null) );
		}
		
	}

	public List<Marca> todos(){
		return marcaEJB.listar();
	}
	
	public void editar(Marca marca) {
		this.marca = marca;
	}
	
	
	public void excluir(Short idMarca) {
		
		Mensagem msg = marcaEJB.excluir(idMarca);
		
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

	
	
	
	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	
	
}
