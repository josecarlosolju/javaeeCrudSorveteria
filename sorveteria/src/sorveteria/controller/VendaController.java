package sorveteria.controller;

import java.io.Serializable;			
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import sorveteria.bll.interfaces.IProdutoEJB;
import sorveteria.bll.interfaces.IVendaEJB;
import sorveteria.bll.relatorio.GraficoLinha;
import sorveteria.bll.util.Mensagem;
import sorveteria.bll.util.TipoMensagem;
import sorveteria.dal.entidade.Venda;
import sorveteria.dal.entidade.VendaProduto;
import sorveteria.util.FacesUtil;

@Named
@javax.enterprise.context.SessionScoped
public class VendaController implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private IVendaEJB vendaEJB;
    @EJB
    private IProdutoEJB produtoEJB;
    
    @Inject
	private FacesUtil facesUtil;
	

    private Venda venda;
    private VendaProduto vendaProduto;
    private Integer ano;

    private LineChartModel graficoLinha;

    private List<Venda> vendas;

    public VendaController() {
        venda = new Venda();
        vendaProduto = new VendaProduto();
    }

    public void salvar() {

    	Mensagem mensagem = vendaEJB.salvar(venda);

        if (mensagem.getTipo() == TipoMensagem.sucesso) {
        	venda = new Venda();
            vendaProduto = new VendaProduto();
        }
        
        facesUtil.addMessage(mensagem);
    }

    public void listar() {
    	vendas = vendaEJB.listar(venda.getData());
    }


    public void adicionar() {

        if (venda.getVendaProdutos() == null) {
            venda.setVendaProdutos(new ArrayList<>());
        }

        for (VendaProduto l : venda.getVendaProdutos()) {
            if (Objects.equals(l.getProduto().getIdProduto(),vendaProduto.getProduto().getIdProduto())) {
                return;
            }
        }

        vendaProduto.setProduto(produtoEJB.obter(vendaProduto.getProduto().getIdProduto()));
        venda.getVendaProdutos().add(vendaProduto);
        vendaProduto = new VendaProduto();
    }


    public void graficoLinha() {
      
    	graficoLinha = null;
        if(ano != null) {
        	

        	List<GraficoLinha> caldas = vendaEJB.listar(ano);
            if(caldas.size() == 0) return;
            graficoLinha = new LineChartModel();
            graficoLinha.getAxes().put(AxisType.X, new CategoryAxis("Meses"));
            graficoLinha.setLegendPosition("se");
            LineChartSeries series = new LineChartSeries();
            series.setLabel("Vendas");
            for (GraficoLinha graficoLinha : caldas) {
                series.set(graficoLinha.getMes().toString(), graficoLinha.getTotal());
            }

            graficoLinha.addSeries(series);

            graficoLinha.setLegendPosition("n");
            graficoLinha.setShowPointLabels(true);
        }

    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }


    public VendaProduto getVendaProduto() {
		return vendaProduto;
	}

	public void setVendaProduto(VendaProduto vendaProduto) {
		this.vendaProduto = vendaProduto;
	}

	public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

	public LineChartModel getGraficoLinha() {
		return graficoLinha;
	}

	public void setGraficoLinha(LineChartModel graficoLinha) {
		this.graficoLinha = graficoLinha;
	}

    

}
