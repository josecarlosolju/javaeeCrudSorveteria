package sorveteria.dal.entidade;

import javax.persistence.*;

@Entity
public class VendaProduto {

	@EmbeddedId
	private VendaProdutoPk id;
	
	private Double preco;
	
	@ManyToOne
	@JoinColumn(name = "idProduto")
	@MapsId("idProduto")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "idVenda")
	@MapsId("idVenda")
	private Venda venda;

	public VendaProdutoPk getId() {
		return id;
	}

	public void setId(VendaProdutoPk id) {
		this.id = id;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VendaProduto other = (VendaProduto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
	
}
