package sorveteria.bll.interfaces;

import sorveteria.dal.entidade.MetodoPagamento;

import java.util.List;

import sorveteria.bll.util.Mensagem;

public interface IPagamentoEJB {
	public Mensagem salvar(MetodoPagamento pagamento);
	public Mensagem excluir(Short idPagamento);
	public List<MetodoPagamento> listar();
}
