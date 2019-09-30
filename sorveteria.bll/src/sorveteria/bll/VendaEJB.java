package sorveteria.bll;

import java.util.ArrayList;	
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;


import sorveteria.bll.interfaces.IVendaEJB;
import sorveteria.bll.relatorio.GraficoLinha;
import sorveteria.bll.util.Mensagem;
import sorveteria.bll.util.TipoMensagem;
import sorveteria.dal.dao.interfaces.IVendaDAO;
import sorveteria.dal.entidade.Venda;
import sorveteria.dal.entidade.VendaProduto;

@Stateless
public class VendaEJB implements IVendaEJB{

	@Inject
	private IVendaDAO vendaDAO;
	
    @Override
    public Mensagem salvar(Venda venda) {
        try {
            for (VendaProduto vp : venda.getVendaProdutos()) {
                vp.setVenda(venda);
            }

            vendaDAO.insertOrUpdate(venda);
            return new Mensagem("Venda salva.",
					TipoMensagem.sucesso);
        } catch (Exception ex) {
        	return new Mensagem(ex.getMessage(), TipoMensagem.erro);
        }
    }

    public List<Venda> listar(Date data) {
        return vendaDAO.listar(data);
    }
    
    
    public List<GraficoLinha> listar(int ano) {

        List<GraficoLinha> vendas = new ArrayList<>();

		List<?> list =  vendaDAO.listar(ano);
		
		for (Object object : list) {
			Object[] objects = (Object[])object;
			vendas.add(new GraficoLinha((Integer) objects[0], (Double) objects[1]));
		}

        return vendas;
    }

}
