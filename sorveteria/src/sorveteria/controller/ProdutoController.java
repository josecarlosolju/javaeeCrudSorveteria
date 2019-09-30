package sorveteria.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import sorveteria.bll.interfaces.IProdutoEJB;
import sorveteria.bll.util.Mensagem;
import sorveteria.bll.util.TipoMensagem;
import sorveteria.dal.entidade.Produto;

@Named
@RequestScoped
public class ProdutoController {

	private Produto produto;
	
	@EJB
	private IProdutoEJB produtoEJB;
	
	@Inject
	private FacesContext context;
	
	public ProdutoController() {
		this.produto = new Produto();
	}
	
	public void salvar() {
		
		Mensagem msg = produtoEJB.salvar(produto);
		
		if(msg.getTipo() == TipoMensagem.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(),null) );
			
			this.produto = new Produto();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(),null) );
		}
		
	}

	public List<Produto> todos(){
		return produtoEJB.listar();
	}
	
	public void editar(Produto produto) {
		this.produto = produto;
	}
	
	
	public void excluir(Integer idProduto) {
		
		Mensagem msg = produtoEJB.excluir(idProduto);
		
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

	
	
	
	public Produto getProduto() {
		return produto;
	}

	public void setAutomovel(Produto produto) {
		this.produto = produto;
	}
	
	
	
}
