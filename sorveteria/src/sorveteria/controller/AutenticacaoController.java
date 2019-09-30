package sorveteria.controller;

import javax.inject.*;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.*;
import javax.faces.context.FacesContext;

import sorveteria.bll.interfaces.IUsuarioEJB;
import sorveteria.bll.util.Mensagem;
import sorveteria.bll.util.TipoMensagem;
import sorveteria.dal.entidade.*;
import sorveteria.util.FacesUtil;

@Named
@SessionScoped
public class AutenticacaoController implements Serializable {

	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private boolean usuarioAutenticado;
	private boolean cadastroPage;
	
	@EJB
	private IUsuarioEJB usuarioEJB;
	
	@Inject
	private FacesUtil facesUtil;
	
	@Inject
	private FacesContext facesContext;
	
	public AutenticacaoController() {
		this.usuario = new Usuario();
	}
	
	public void autenticar() throws IOException {
		
		Mensagem mensagem = usuarioEJB.autenticar(usuario);
		
		if(mensagem.getTipo() == TipoMensagem.erro) {
			facesUtil.addMessage(mensagem);
		}else {
			usuarioAutenticado = true;
			facesContext
				.getExternalContext()
				.redirect("index.xhtml");
		}
	}
	
	public void sair() throws IOException{
		this.usuario = new Usuario();
		this.usuarioAutenticado = false;
		String path = facesContext.getExternalContext().getRequestContextPath();
		facesContext.getExternalContext().redirect(path + "/login.xhtml");
	}
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isUsuarioAutenticado() {
		return usuarioAutenticado;
	}

	public void setUsuarioAutenticado(boolean usuarioAutenticado) {
		this.usuarioAutenticado = usuarioAutenticado;
	}

	public boolean isCadastroPage() {
		return cadastroPage;
	}

	public void setCadastroPage(boolean cadastroPage) {
		this.cadastroPage = cadastroPage;
	}

	
	
	
	
	
}
