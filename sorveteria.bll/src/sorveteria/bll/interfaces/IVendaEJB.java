package sorveteria.bll.interfaces;

import java.util.Date;	
import java.util.List;

import sorveteria.bll.relatorio.GraficoLinha;
import sorveteria.bll.util.Mensagem;
import sorveteria.dal.entidade.Venda;

public interface IVendaEJB {
	public Mensagem salvar(Venda venda);
	public List<Venda> listar(Date data);
	List<GraficoLinha> listar(int ano);
}
