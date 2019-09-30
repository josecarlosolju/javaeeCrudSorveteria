package sorveteria.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import sorveteria.bll.interfaces.IFornecedorEJB;
import sorveteria.bll.util.Mensagem;
import sorveteria.bll.util.TipoMensagem;
import sorveteria.dal.entidade.Fornecedor;

@Named
@RequestScoped
public class FornecedorController {

	private Fornecedor fornecedor;
	
	@EJB
	private IFornecedorEJB fornecedorEJB;
	
	@Inject
	private FacesContext context;
	
	public FornecedorController() {
		this.fornecedor = new Fornecedor();
	}
	
	public void salvar() {
		
		Mensagem msg = fornecedorEJB.salvar(fornecedor);
		
		if(msg.getTipo() == TipoMensagem.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(),null) );
			
			this.fornecedor = new Fornecedor();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(),null) );
		}
		
		
	}

	public List<Fornecedor> todos(){
		return fornecedorEJB.listar();
	}
	
	public void editar(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	
	public void excluir(Short idFornecedor) {
		
		Mensagem msg = fornecedorEJB.excluir(idFornecedor);
		
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

	
	
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	
	
}
