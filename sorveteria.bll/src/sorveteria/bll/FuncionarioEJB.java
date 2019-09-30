package sorveteria.bll;

import java.util.*;	

import sorveteria.dal.dao.interfaces.*;
import sorveteria.dal.entidade.*;
import sorveteria.bll.interfaces.*;
import sorveteria.bll.util.Mensagem;
import sorveteria.bll.util.SHA1;
import sorveteria.bll.util.TipoMensagem;

import javax.ejb.*;
import javax.inject.*;

@Stateless
public class FuncionarioEJB implements IFuncionarioEJB {

	@Inject
	private IFuncionarioDAO funcionarioDAO;
	
	@Override
	public Mensagem salvar(Funcionario funcionario) {

		try {
			
			String cpfSemMascara = funcionario.getCpfMascara()
				.replace(".", "")
				.replace("-", "");
			
			funcionario.setCpf(Long.parseLong(cpfSemMascara));
			
			Usuario usuario = funcionario.getUsuario();
			usuario.setFuncionario(funcionario);
			
			String senha = SHA1.encryptPassword(usuario.getSenha());
			usuario.setSenha(senha);
			
			funcionarioDAO.insertOrUpdate(funcionario);
			
			return new Mensagem("Funcion�rio salvo.",
					TipoMensagem.sucesso);
			
		}catch (Exception e) {
			return new Mensagem(e.getMessage(), TipoMensagem.erro);
		}
		
	}

	@Override
	public Mensagem excluir(Integer idPessoa) {
		
		try {
			
			Funcionario funcionario = funcionarioDAO.findById(idPessoa);
			
			if(funcionario == null) {
				return new Mensagem("Funcion�rio n�o existe.",
						TipoMensagem.erro);
			}
			
			if(funcionario.getLocacoes().size() > 0) {
				return new Mensagem("Funcion�rio j� realizou loca��es.",
						TipoMensagem.erro);
			}
			
			funcionarioDAO.delete(funcionario);
			
			return new Mensagem("Funcion�rio exclu�do",
					TipoMensagem.sucesso);
			
		}catch(Exception ex) {
			return new Mensagem(ex.getMessage(),
					TipoMensagem.erro);
			
		}
		
	}

	@Override
	public List<Funcionario> listar() {
		return funcionarioDAO.findAll();
	}

}
