package sorveteria.controller;

import java.util.List;	

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import sorveteria.bll.interfaces.IPagamentoEJB;
import sorveteria.bll.util.Mensagem;
import sorveteria.bll.util.TipoMensagem;
import sorveteria.dal.entidade.MetodoPagamento;

@Named
@RequestScoped
public class PagamentoController {

	private MetodoPagamento pagamento;
	
	@EJB
	private IPagamentoEJB pagamentoEJB;
	
	@Inject
	private FacesContext context;
	
	public PagamentoController() {
		this.pagamento = new MetodoPagamento();
	}
	
	public void salvar() {
		
		Mensagem msg = pagamentoEJB.salvar(pagamento);
		
		if(msg.getTipo() == TipoMensagem.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(),null) );
			
			this.pagamento = new MetodoPagamento();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(),null) );
		}
		
	}

	public List<MetodoPagamento> todos(){
		return pagamentoEJB.listar();
	}
	
	public void editar(MetodoPagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	
	public void excluir(Short idPagamento) {
		
		Mensagem msg = pagamentoEJB.excluir(idPagamento);
		
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

	public MetodoPagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(MetodoPagamento pagamento) {
		this.pagamento = pagamento;
	}

	
	
	
}
